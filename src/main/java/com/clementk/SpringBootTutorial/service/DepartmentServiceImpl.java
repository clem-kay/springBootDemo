package com.clementk.SpringBootTutorial.service;

import com.clementk.SpringBootTutorial.Exception.DepartmentNotFoundException;
import com.clementk.SpringBootTutorial.entity.Department;
import com.clementk.SpringBootTutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> listDepartment() {
        return departmentRepository.findAll();
    }
    @Override
    public Department listDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        return departmentRepository.findById(departmentId).orElseThrow(()-> new DepartmentNotFoundException("Department not found"));
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();

        if (department.getDepartmentName()!= null){
            depDB.setDepartmentName(department.getDepartmentName());
        }if (department.getDepartmentCode()!= null){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }if (department.getDepartmentAddress()!= null){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

}
