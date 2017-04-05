
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

    private static  final String GET_EMP = "from Employee e where e.depId=:depID";

    private final SessionFactory sessionFactory;

    @Autowired
    public EmpHibernateDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void delete(Employee employee) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
            session.delete(employee);
    }

    @Override
    public void update(Employee employee) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(employee);
    }

    @Override
    public List<Employee> getAll(Long depID) throws SQLException {

        Session session = sessionFactory.getCurrentSession();
        List<Employee> employees = (List<Employee>) session.createQuery(GET_EMP).setParameter("depID", depID).list();
        return employees;
    }

    @Override
    public Employee getEmpByID(Employee employee) throws SQLException {
        Long lEmpID = employee.getId();
        Session session = sessionFactory.getCurrentSession();
        employee = (Employee) session.get(Employee.class, lEmpID);
        return employee;
    }
}


