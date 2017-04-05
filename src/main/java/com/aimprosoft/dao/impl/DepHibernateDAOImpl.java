package com.aimprosoft.dao.impl;

import com.aimprosoft.dao.DepartmentDAO;
import com.aimprosoft.model.Department;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("departmentDAO")
public class DepHibernateDAOImpl implements DepartmentDAO {

    private static final String GET_DEP = "from Department";
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Department department) throws SQLException {

        Session session = sessionFactory.getCurrentSession();
        session.delete(department);

    }

    @Override
    public void update(Department department) throws SQLException {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(department);

    }

    @Override
    public List<Department> getAll() throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        List<Department> departments = null;
        departments = (List<Department>) session.createQuery(GET_DEP).list();
        return departments;
    }

    @Override
    public Department getDepByID(Department department) throws SQLException {
        Long lDepID = department.getId();
        Session session = sessionFactory.getCurrentSession();
        department = (Department) session.get(Department.class, lDepID);
        return department;
    }

    @Override
    public Department existNameInDB(Department department) throws SQLException {
        String depName = department.getName();
        Session session = sessionFactory.getCurrentSession();
        Department dep = department;
        Query query = session.
                createQuery("from Department where name=:name");
        query.setParameter("name", depName);
        dep = (Department) query.uniqueResult();
        return dep;

    }
}

