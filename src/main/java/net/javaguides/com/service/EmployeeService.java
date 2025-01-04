//package net.javaguides.com.service;
//
//import net.javaguides.com.model.Department;
//import net.javaguides.com.model.Employee;
//import net.javaguides.com.repository.DepartmentRepository;
//import net.javaguides.com.repository.EmployeeRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmployeeService {
//    @Autowired
//    private DepartmentRepository departmentRepository;
//
//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    public Employee saveEmployee(Employee employee) {
//        Department department = employee.getDepartment();
//        if (department != null && department.getId() == null ) {
//            department = departmentRepository.save(department);
//        }
//        employee.setDepartment(department);
//        return employeeRepository.save(employee);
//    }
//}
