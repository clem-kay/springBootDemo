package com.clementk.SpringBootTutorial.service;

import com.clementk.SpringBootTutorial.entity.Department;
import com.clementk.SpringBootTutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentId(1L)
                .departmentAddress("BU")
                .departmentName("IT")
                .departmentCode("IT-01")
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on valid data")
    public void whenValidDepartmentName_thenDepartmentShouldBeFound(){
        String departmentName = "IT";
        Department found = departmentService.getDepartmentByName(
                departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}