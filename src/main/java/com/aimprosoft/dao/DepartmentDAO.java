package com.aimprosoft.dao;

import com.aimprosoft.model.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO<T> {

    void delete(T entity) throws SQLException;

    void update(T entity) throws SQLException;

    List<T> getAll() throws SQLException;

    Department getDepByID(String id) throws SQLException;

    Department existNameInDB(String name) throws SQLException;
}