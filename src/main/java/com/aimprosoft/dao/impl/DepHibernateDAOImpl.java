package com.aimprosoft.dao.impl;

import com.aimprosoft.dao.DepartmentDAO;
import com.aimprosoft.model.Department;
import com.aimprosoft.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Repository("departmentDAO")
//@Transactional
public class DepHibernateDAOImpl implements DepartmentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void DepHibernateDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {

        return sessionFactory.getCurrentSession(); // сеанс из фабрики
    }

    @Override
    public void delete(Department department) throws SQLException {
        Long depID = department.getId();
        Session session = currentSession();
        session.beginTransaction();
        List<Employee> employees =
                (List<Employee>) session.
                        createQuery("from Employee e where e.depId=:depID").setParameter("depID", depID).
                        list();
        for (Employee emp : employees) {
            session.delete(emp);
        }

        session.delete(department);
        session.getTransaction().commit();

    }

    @Override
    public void update(Department department) throws SQLException {

        Session session = currentSession();
        session.beginTransaction();
        session.saveOrUpdate(department);
        session.getTransaction().commit();

    }

    @Override
    public List<Department> getAll() throws SQLException {
        Session session = currentSession();
        session.beginTransaction();
        List<Department> departments = (List<Department>) session.createQuery("from Department").list();
        session.getTransaction().commit();
        return departments;
    }

    @Override
    public Department getDepByID(Department department) throws SQLException {
        Long lDepID = department.getId();
        Session session = currentSession();
        session.beginTransaction();
        department = (Department) session.get(Department.class, lDepID);
        session.getTransaction().commit();
        return department;
    }

    @Override
    public Department existNameInDB(Department department) throws SQLException {
        String depName = department.getName();
        Session session = currentSession();
       // session.beginTransaction();
        Query query = session.
                createQuery("from Department where name=:name");
        query.setParameter("name", depName);
        Department dep = (Department) query.uniqueResult();
       // session.getTransaction().commit();
        return dep;

    }
}
//-------------
/*    @Override
    public List<Department> getAll() throws SQLException{
  Session session = currentSession();
  session.beginTransaction();
        List<Department> departments = (List<Department>) session.createQuery("from Department").list();
        return departments;
    }*/