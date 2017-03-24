package com.aimprosoft.util;


import com.aimprosoft.exeption.ValidateExp;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.context.FieldContext;
import net.sf.oval.context.OValContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomValidator {


    @Autowired
    private Validator validator;

    public void validate(Object object) throws ValidateExp {

        List<ConstraintViolation> constraintViolations = validator.validate(object);
        if (constraintViolations.size() > 0) {

            Map<String, String> errorMap = new HashMap<String, String>();

            for (ConstraintViolation violation : constraintViolations) {
                OValContext context = violation.getContext();
                if (context instanceof FieldContext) {
                    FieldContext fieldContext = (FieldContext) context;
                    Field field = fieldContext.getField();
                    String fieldName = field.getName();
                    String errorMessage = violation.getMessage();
                    errorMap.put(fieldName, errorMessage);
                }
            }
            throw new ValidateExp(errorMap);

        }
    }
}




