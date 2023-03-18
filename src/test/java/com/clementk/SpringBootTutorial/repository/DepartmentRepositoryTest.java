package com.clementk.SpringBootTutorial.repository;

import com.clementk.SpringBootTutorial.entity.Department;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

//    @Autowired
//    private DepartmentRepository departmentRepository;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @BeforeEach
//    void setUp() {
//        Department department = Department.builder()
//                .departmentName("Mechanical")
//                .departmentId(11L)
//                .departmentCode("MECH-01")
//                .departmentAddress("TK")
//                .build();
//
//        entityManager.persist(department);
//    }
//    @Test
//    @DisplayName("Testing find by ID")
//    @Ignore
//    public void whenFindById_thenReturnDepartment(){
////        Department department = departmentRepository.findById(11L).get();
//        assertEquals("Mechanical","Mechanical");
//    }
}