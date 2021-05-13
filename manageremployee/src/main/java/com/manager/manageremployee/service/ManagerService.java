package com.manager.manageremployee.service;

import java.util.List;
import java.util.UUID;

import com.manager.manageremployee.model.Employee;
import com.manager.manageremployee.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    private final EmployeeRepo Employeerepo;

@Autowired
public ManagerService(EmployeeRepo Employeerepo) {
    this.Employeerepo = Employeerepo;
}

public Employee addEmployee(Employee employee){
    employee.setEmployeeCode(UUID.randomUUID().toString());
    return Employeerepo.save(employee);
}

public List<Employee> findAllEmployees(){
    return Employeerepo.findAll();
}

public Employee updateEmployee (Employee employee){
    return Employeerepo.save(employee);
}

public Employee findEmployeeById(Long id){
return Employeerepo.findById(id).orElseThrow(() -> new UserNotFoundException ("User by Id " + id + "was not found"));
}

public void deleteEmploy(Long id){
    Employeerepo.deleteEmployeeById(id);
}
}
