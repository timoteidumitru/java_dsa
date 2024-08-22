package com.datastructure.multipleDataSource.service;

import com.datastructure.multipleDataSource.model.employee.Employee;
import com.datastructure.multipleDataSource.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
         return  employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee){
        employeeRepository.save(employee);
        return employee;
    }
}
