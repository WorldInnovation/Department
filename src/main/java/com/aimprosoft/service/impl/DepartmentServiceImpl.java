package com.aimprosoft.service.impl;


import com.aimprosoft.dao.DepartmentDAO;
import com.aimprosoft.exeption.ValidateExp;
import com.aimprosoft.model.Department;
import com.aimprosoft.service.DepartmentService;
import com.aimprosoft.util.CustomValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service("departmentService")
//@Transactional
public class DepartmentServiceImpl  implements DepartmentService{

    @Autowired

    private DepartmentDAO departmentDAO ;//DepartmentDAOImpl();
    @Autowired
    private  CustomValidator validator ;

    @Override
    public void saveOrUpdateDepartment(Department department) throws ValidateExp, SQLException {
        validator.validate(department);
        departmentDAO.update(department);
    }

    @Override
    public List<Department> showDepartments() throws  SQLException {

        return (List<Department>) departmentDAO.getAll();
    }

    @Override
    public void deleteDepartment(Department department) throws SQLException {

        departmentDAO.delete(department);
    }

    @Override
    public Department getDepartmentById(Department department) throws SQLException {
        return departmentDAO.getDepByID(department);
    }
}