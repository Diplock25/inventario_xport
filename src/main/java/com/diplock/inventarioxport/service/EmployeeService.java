package com.diplock.inventarioxport.service;


import com.diplock.inventarioxport.model.Employee;

public interface EmployeeService {
  Employee save(Employee employee);

  Employee findById(Long id);

}
