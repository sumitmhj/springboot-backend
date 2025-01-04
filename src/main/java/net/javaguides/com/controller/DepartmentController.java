package net.javaguides.com.controller;

import net.javaguides.com.exception.ResourceNotFoundException;
import net.javaguides.com.model.Department;
import net.javaguides.com.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department){
        return departmentRepository.save(department);
//        Department savedDepartment = departmentRepository.save(department);
//        return new ResponseEntity<Department>(savedDepartment, HttpStatus.CREATED).getBody();
    }

    @GetMapping("{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable long id){
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
        return ResponseEntity.ok(department);
    }

    @PutMapping("{id}")
    public ResponseEntity<Department> updateDepartmentById(@PathVariable long id, @RequestBody Department department){
        Department updateDepartment = departmentRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Department not there"));
        updateDepartment.setName(department.getName());
        departmentRepository.save(updateDepartment);
        return ResponseEntity.ok(updateDepartment);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable long id){
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not there"));
        departmentRepository.delete(department);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
