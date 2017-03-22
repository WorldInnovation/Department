package com.aimprosoft.dao.impl;

import com.aimprosoft.dao.EmployeeDAO;
import com.aimprosoft.model.Employee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
/*@Transactional*/
@Repository("employeeDAO")
public class EmpHibernateDAOImpl implements EmployeeDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void EmpHibernateDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {

        return sessionFactory.getCurrentSession();
    }
    @Override
    public void delete(Employee employee) throws SQLException {
        Session session = currentSession();
        session.beginTransaction();
        session.delete(employee);
        session.getTransaction().commit();
    }

    @Override
    public void update(Employee employee) throws SQLException {
        Session session = currentSession();
        session.beginTransaction();
        session.saveOrUpdate(employee);
        session.getTransaction().commit();
    }


    @Override
    public List<Employee> getAll(Long depID) throws SQLException {

        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Employee> employees =
                (List<Employee>) session.
                        createQuery("from Employee e where e.depId=:depID").setParameter("depID", depID).
                        list();
        session.getTransaction().commit();
        return employees;
    }

    @Override
    public Employee getEmpByID(Employee employee) throws SQLException {
        Long lEmpID = employee.getId();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        employee = (Employee) session.get(Employee.class, lEmpID) ;
        session.getTransaction().commit();
        return employee;

    }
}