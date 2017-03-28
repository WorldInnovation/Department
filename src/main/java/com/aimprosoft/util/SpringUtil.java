package com.aimprosoft.util;

import com.aimprosoft.dao.DepartmentDAO;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;


@Service
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    public static DepartmentDAO getDepartmentService() {
        return (DepartmentDAO) applicationContext.getBean("departmentDAO");
    }
}
