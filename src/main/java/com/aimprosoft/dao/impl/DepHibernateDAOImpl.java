package com.aimprosoft.dao.impl;

import com.aimprosoft.dao.DepartmentDAO;
import com.aimprosoft.model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
/*@Qualifier("departmentDAO")*/
public class DepHibernateDAOImpl implements DepartmentDAO {
    private SessionFactory sessionFactory;
    @Autowired
    public DepHibernateDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }
    private Session currentSession() {

        return sessionFactory.getCurrentSession(); // сеанс из фабрики
    }

    @Override
    public void delete(Department department) throws SQLException {
  //      Long depID = department.getId();
        Session session = currentSession();
        session.getTransaction();
/*        List<Employee> employees = (List<Employee>) session.
                createQuery("from Employee e where e.depId=:depID").
                setParameter("depID", depID).list();
        for (Employee emp: employees){
            session.delete(emp);
        }*/
        session.delete(department);

/*        Long depID = department.getId();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Employee> employees = (List<Employee>) session.
                createQuery("from Employee e where e.depId=:depID").setParameter("depID", depID).
                list();
        session.close();
        for (Employee emp: employees) {
            HibernateUtil.executeDAO(emp,"delete");
        }
        HibernateUtil.executeDAO(department,"delete");*/
    }
    @Override
    public void update(Department department) throws SQLException {

        Session sesion = currentSession();
        sesion.beginTransaction();
        sesion.update(department);

    }
    @Override
    public List<Department> getAll() throws SQLException{
        Session session = currentSession();
        session.beginTransaction();
        List<Department> departments = (List<Department>) session.createQuery("from Department").list();
        return departments;
    }
    /*    @Override
        public List<Department> getAll() throws SQLException {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            List<Department> departments = (List<Department>) session.
                    createQuery("from Department").list();
            session.close();
            return departments;
        }*/
    @Override
    public Department getDepByID(Department department) throws SQLException {
        Long lDepID = department.getId();
        Session session = currentSession();

        department = (Department) session.get(Department.class,lDepID);
        return department;
/*
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();


        session.close();
        return department;*/
    }
    @Override
    public Department existNameInDB(Department department) throws SQLException {
        return  null;
/*        String depName = department.getName();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.
                createQuery("from Department where name=:name");
        query.setParameter("name", depName);
        session.close();
        Department dep = (Department) query.uniqueResult();
        return dep;*/
    }}
//-------------
/*    @Override
    public List<Department> getAll() throws SQLException{
  Session session = currentSession();
  session.beginTransaction();
        List<Department> departments = (List<Department>) session.createQuery("from Department").list();
        return departments;
    }*/