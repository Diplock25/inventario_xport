package com.diplock.inventarioxport.service;

import com.diplock.inventarioxport.repository.EmployeeRepository;
import com.diplock.inventarioxport.model.Employee;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public Employee save(Employee employee) {
    return (Employee) employeeRepository.save(employee);
  }

  @Override
  public Employee findById(Long id) {
    final Optional<Employee> employee = this.employeeRepository.findById(id);

    return employee.orElse(null);

  }
}
