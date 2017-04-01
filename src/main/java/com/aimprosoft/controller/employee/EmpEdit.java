package com.aimprosoft.controller.employee;

import com.aimprosoft.controller.InternalController;
import com.aimprosoft.model.Employee;
import com.aimprosoft.service.EmployeeService;
import com.aimprosoft.util.FormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Controller("/EmpEdit")
public class EmpEdit implements InternalController {
    @Autowired
    private EmployeeService employeeService;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, SQLException {
        String empID = req.getParameter("EmpID");
        String depID = req.getParameter("DepID");
        Long lEmpID = FormatUtils.getLongFromStr(empID);
        req.setAttribute("depID", depID);
        Employee employee = new Employee();
        if (lEmpID != null) {
            employee.setId(lEmpID);
            employee = employeeService.getEmpByID(employee);
            req.setAttribute("empID", empID);
            req.setAttribute("employee", employee);
        }
        req.getRequestDispatcher("WEB-INF/jsp/empEdit.jsp").forward(req, resp);
    }
}
