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
import java.util.List;

@Controller("/EmployeesList")
public class EmployeesList implements InternalController {
    @Autowired
    private EmployeeService employeeService;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, SQLException {
        String depID = req.getParameter("DepID");
        req.setAttribute("depID", depID);
        Long lDepID = FormatUtils.getLongFromStr(depID);
        if (lDepID != null) {
            List<Employee> employees = employeeService.listEmployee(depID);
            req.setAttribute("employees", employees);
        }
        req.getRequestDispatcher("WEB-INF/jsp/empList.jsp").forward(req, resp);
    }
}