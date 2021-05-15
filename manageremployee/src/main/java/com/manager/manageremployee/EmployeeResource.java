package com.manager.manageremployee;

import java.util.List;

import com.manager.manageremployee.model.Employee;
import com.manager.manageremployee.service.ManagerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final ManagerService managerService;


    public EmployeeResource(ManagerService managerService){
        this.managerService = managerService;
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees (){
        List<Employee> employees = managerService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id")Long id){
        Employee employee = managerService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee (@RequestBody Employee employee){
        Employee newEmployee = managerService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee (@RequestBody Employee employee){
        Employee updateEmployee = managerService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
       managerService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
