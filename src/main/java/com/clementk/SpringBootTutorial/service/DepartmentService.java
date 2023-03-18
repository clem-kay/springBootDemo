package com.clementk.SpringBootTutorial.service;

import com.clementk.SpringBootTutorial.Exception.DepartmentNotFoundException;
import com.clementk.SpringBootTutorial.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> listDepartment();

    public Department listDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    Department getDepartmentByName(String departmentName);
}
