package com.aimprosoft.service;


import com.aimprosoft.exeption.ValidateExp;
import com.aimprosoft.model.Employee;

import java.sql.SQLException;
import java.util.List;


public interface EmployeeService {

    void updateEmployee (Employee employee) throws ValidateExp, SQLException;
    void deleteEmployee (Employee employee) throws  SQLException;
    List<Employee> listEmployee (String empId) throws SQLException;
    Employee getEmpByID (String empId)   throws SQLException;

}