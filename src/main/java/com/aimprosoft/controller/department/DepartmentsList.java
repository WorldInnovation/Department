package com.aimprosoft.controller.department;

import com.aimprosoft.controller.InternalController;
import com.aimprosoft.model.Department;
import com.aimprosoft.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Component("/")
public class DepartmentsList implements InternalController {
    @Autowired
    private DepartmentService departmentService;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, SQLException {
        List<Department> departments = departmentService.showDepartments();
        req.setAttribute("departments", departments);
        req.getRequestDispatcher("WEB-INF/jsp/depList.jsp").forward(req, resp);
    }
}