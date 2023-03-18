package com.clementk.SpringBootTutorial.controller;

import com.clementk.SpringBootTutorial.Exception.DepartmentNotFoundException;
import com.clementk.SpringBootTutorial.entity.Department;
import com.clementk.SpringBootTutorial.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
      log.info("Saving in the department controller");
       return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> listDepartments(){
       return departmentService.listDepartment();
    }

    @GetMapping("/departments/{id}")
    public Department listDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.listDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
         departmentService.deleteDepartmentById(departmentId);
         return "Department Deleted Successfully";
    }

    @PutMapping("/departments/{id}")
    public Department UpdateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);

    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name")
                                              String departmentName){
         return departmentService.getDepartmentByName(departmentName);
    }

}
