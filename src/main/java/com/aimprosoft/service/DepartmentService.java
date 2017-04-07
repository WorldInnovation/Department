package com.aimprosoft.service;

import com.aimprosoft.exeption.ValidateExp;
import com.aimprosoft.model.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentService {

    List <Department> showDepartments () throws  SQLException;
    void saveOrUpdateDepartment(Department department) throws ValidateExp, SQLException;
    void deleteDepartment (Department department) throws  SQLException;
    Department getDepartmentById(String depId) throws SQLException;
}