package com.aimprosoft.service.impl;


import com.aimprosoft.dao.DepartmentDAO;
import com.aimprosoft.exeption.ValidateExp;
import com.aimprosoft.model.Department;
import com.aimprosoft.service.DepartmentService;
import com.aimprosoft.util.CustomValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;
    @Autowired
    private CustomValidator validator;

    @Transactional//(propagation=Propagation.REQUIRES_NEW)
    @Override
    public void saveOrUpdateDepartment(Department department) throws ValidateExp, SQLException {
        validator.validate(department);
        departmentDAO.update(department);
    }
    @Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
    @Override
    public List<Department> showDepartments() throws SQLException {

        return (List<Department>) departmentDAO.getAll();
    }

    @Transactional//(propagation=Propagation.REQUIRES_NEW)
    @Override
    public void deleteDepartment(Department department) throws SQLException {

        departmentDAO.delete(department);
    }
    @Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
    @Override
    public Department getDepartmentById(Department department) throws SQLException {
        return departmentDAO.getDepByID(department);
    }
}