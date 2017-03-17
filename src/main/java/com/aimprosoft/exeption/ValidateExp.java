package com.aimprosoft.exeption;

import java.util.HashMap;
import java.util.Map;


public class ValidateExp extends Exception {
    private Map<String, String> errorMap = new HashMap<String, String>();

    public ValidateExp(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }

    public Map<String, String> getErrorMap() {
        return errorMap;
    }
}