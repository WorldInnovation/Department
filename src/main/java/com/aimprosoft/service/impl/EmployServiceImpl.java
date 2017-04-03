package com.aimprosoft.service.impl;


import com.aimprosoft.dao.EmployeeDAO;
import com.aimprosoft.exeption.ValidateExp;
import com.aimprosoft.model.Employee;
import com.aimprosoft.service.EmployeeService;
import com.aimprosoft.util.CustomValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service("employServiceImpl")
public class EmployServiceImpl implements EmployeeService {

    @Autowired
    @Qualifier("employeeDAO")
    private EmployeeDAO employeeDAO;
    @Autowired
    @Qualifier("customValidator")
    private CustomValidator validator;

    @Transactional//(propagation=Propagation.REQUIRED, readOnly=false)
    @Override
    public void updateEmployee(Employee employee) throws ValidateExp, SQLException {
        validator.validate(employee);
        employeeDAO.update(employee);
    }
    @Transactional//(propagation=Propagation.REQUIRED, readOnly=false)
    @Override
    public void deleteEmployee(Employee employee) throws SQLException {

        employeeDAO.delete(employee);
    }
    @Transactional//(propagation=Propagation.SUPPORTS, readOnly=true)
    @Override
    public List<Employee> listEmployee(Long lDepID) throws SQLException {

        return employeeDAO.getAll(lDepID);
    }
    @Transactional//(propagation=Propagation.SUPPORTS, readOnly=true)
    @Override
    public Employee getEmpByID(Employee employee) throws SQLException {
        return employeeDAO.getEmpByID(employee);
    }
}