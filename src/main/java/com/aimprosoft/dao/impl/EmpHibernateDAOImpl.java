package com.aimprosoft.dao.impl;

import com.aimprosoft.dao.EmployeeDAO;
import com.aimprosoft.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("employeeDAO")
public class EmpHibernateDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Employee employee) throws SQLException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.delete(employee);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }
        session.close();
    }

    @Override
    public void update(Employee employee) throws SQLException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.saveOrUpdate(employee);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
        }
        session.close();
    }


    @Override
    public List<Employee> getAll(Long depID) throws SQLException {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Employee> employees =
                (List<Employee>) session.
                        createQuery("from Employee e where e.depId=:depID").setParameter("depID", depID).
                        list();
        session.getTransaction().commit();
        session.close();
        return employees;
    }

    @Override
    public Employee getEmpByID(Employee employee) throws SQLException {
        Long lEmpID = employee.getId();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        employee = (Employee) session.get(Employee.class, lEmpID);
        session.getTransaction().commit();
        session.close();
        return employee;
    }
}