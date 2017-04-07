package com.aimprosoft.service.impl;


import com.aimprosoft.dao.DepartmentDAO;
import com.aimprosoft.exeption.ValidateExp;
import com.aimprosoft.model.Department;
import com.aimprosoft.service.DepartmentService;
import com.aimprosoft.util.CustomValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@EnableTransactionManagement
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;
    @Autowired
    private CustomValidator validator;

    @Transactional
    @Override
    public void saveOrUpdateDepartment(Department department) throws ValidateExp, SQLException {
          validator.validate(department);
          departmentDAO.update(department);
    }

    @Transactional
    @Override
    public void deleteDepartment(Department department) throws SQLException {
        departmentDAO.delete(department);
    }

    @Transactional(readOnly = true)
    @Override
    public Department getDepartmentById(String depId) throws SQLException {
        return departmentDAO.getDepByID(depId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Department> showDepartments() throws SQLException {
        return  departmentDAO.getAll();
    }

}