package com.aimprosoft.dao.impl;

import com.aimprosoft.dao.DepartmentDAO;
import com.aimprosoft.model.Department;
import com.aimprosoft.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("departmentDAO")

public class DepHibernateDAOImpl implements DepartmentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {

        return sessionFactory.getCurrentSession();
    }

    @Override
    public void delete(Department department) throws SQLException {
        Long depID = department.getId();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            List<Employee> employees =
                    (List<Employee>) session.
                            createQuery("from Employee e where e.depId=:depID").setParameter("depID", depID).
                            list();
            for (Employee emp : employees) {
                session.delete(emp);
            }

            session.delete(department);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }



    }

    @Override
    public void update(Department department) throws SQLException {

        Session session = sessionFactory.openSession();
      try {
          session.beginTransaction();
          session.saveOrUpdate(department);
          session.getTransaction().commit();
      }catch (Exception e){
        session.getTransaction().rollback();
      }finally {
          if(session != null)session.close();
      }

    }

    @Override
    public List<Department> getAll() throws SQLException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Department> departments = null;
        try {
            departments = (List<Department>) session.createQuery("from Department").list();
            session.getTransaction().commit();
        }catch (Exception e){
                e.printStackTrace();
        }finally {
            if(session != null)session.close();
        }
        return departments;
    }

    @Override
    public Department getDepByID(Department department) throws SQLException {
        Long lDepID = department.getId();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        department = (Department) session.get(Department.class, lDepID);
        session.getTransaction().commit();
        session.close();
        return department;
    }

    @Override
    public Department existNameInDB(Department department) throws SQLException {
        String depName = department.getName();
        Session session = sessionFactory.openSession();
        Department dep = department;
        try {
            Query query = session.
                    createQuery("from Department where name=:name");
            query.setParameter("name", depName);
            dep = (Department) query.uniqueResult();
            session.getTransaction().commit();
        }
        catch (Exception e){
            session.getTransaction().commit();
        }
        session.close();
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