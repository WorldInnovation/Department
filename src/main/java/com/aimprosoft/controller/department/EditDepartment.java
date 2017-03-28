package com.aimprosoft.controller.department;

import com.aimprosoft.controller.InternalController;
import com.aimprosoft.model.Department;
import com.aimprosoft.service.DepartmentService;
import com.aimprosoft.util.FormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Controller("/EditDepartment")
public class EditDepartment implements InternalController {
    @Autowired
    private DepartmentService departmentService;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, SQLException {
        String strDepId = req.getParameter("DepID");
        Long depId = FormatUtils.getLongFromStr(strDepId);
        Department department = new Department();
        if (depId != null) {
            department.setId(depId);
            department = departmentService.getDepartmentById(department);
            req.setAttribute("depId", depId);
        }//edit
        req.setAttribute("department", department);
        req.getRequestDispatcher("WEB-INF/jsp/editDep.jsp").forward(req, resp);
    }
}

