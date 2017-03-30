package com.aimprosoft.util;


import com.aimprosoft.dao.DepartmentDAO;
import com.aimprosoft.model.Department;
import net.sf.oval.constraint.CheckWithCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OvalValidDepName implements CheckWithCheck.SimpleCheck {

    @Autowired
    private DepartmentDAO departmentDAO;

    @Override
    public boolean isSatisfied(Object o, Object o1) {
        String depName = o1.toString();
        Department dep = (Department) o;

        Department department = new Department();
        department.setName(depName);
        try {
            department = departmentDAO.existNameInDB(department);
        } catch (Exception e) {
            e.printStackTrace();

        }

        return (department == null || department.getId().equals(dep.getId()));

    }
}
