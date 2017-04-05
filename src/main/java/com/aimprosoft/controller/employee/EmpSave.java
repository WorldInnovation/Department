package com.aimprosoft.controller.employee;

import com.aimprosoft.controller.InternalController;
import com.aimprosoft.exeption.ValidateExp;
import com.aimprosoft.model.Department;
import com.aimprosoft.model.Employee;
import com.aimprosoft.service.DepartmentService;
import com.aimprosoft.service.EmployeeService;
import com.aimprosoft.util.FormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@Controller("/EmpSave")
public class EmpSave implements InternalController {

    @Autowired
    @Qualifier("employServiceImpl")
    private EmployeeService employeeService;

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, SQLException {
        String empID = req.getParameter("EmpID");
        String firstName = req.getParameter("FirstName");
        String secondName = req.getParameter("SecondName");
        String grade = req.getParameter("Grade");
        String birthday = req.getParameter("Birthday");
        String eMail = req.getParameter("EMail");
        String depID = req.getParameter("DepID");
        Employee employee = new Employee();
        Long lEmpID = FormatUtils.getLongFromStr(empID);
        if (lEmpID != null) {
            employee.setId(lEmpID);
        }//edit
        employee.setFirstName(firstName);
        employee.setSecondName(secondName);
        Integer iGrade = FormatUtils.getIntFromStr(grade);
        if (iGrade != null) employee.setGrade(iGrade);
        Date dBirthday = FormatUtils.getDateFromString(birthday);//stringToValue(birthday)

        if (dBirthday != null) employee.setBirthday(dBirthday);
        Long lDepID = FormatUtils.getLongFromStr(depID);
        if (lDepID != null) employee.setDepID(lDepID);
        employee.setMail(eMail);

        try {
            employeeService.updateEmployee(employee);
        } catch (ValidateExp exp) {
            req.setAttribute("depID", depID);
            req.setAttribute("empID", empID);
            req.setAttribute("errorMap", exp.getErrorMap());
            //req.setAttribute("employee", employee);
            req.getRequestDispatcher("WEB-INF/jsp/empEdit.jsp").forward(req, resp);
        }
        String sendParam = "?DepID=".concat(depID);
        resp.sendRedirect("/EmployeesList".concat(sendParam));
    }
}