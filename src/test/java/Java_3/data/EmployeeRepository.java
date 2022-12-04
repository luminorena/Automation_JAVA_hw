package Java_3.data;

import Java_3.domain.Employee;

import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> lookup (String name, String surName);
    Employee save(Employee employee) throws IllegalAccessException;
    Employee update(Employee employee) throws IllegalAccessException;
}
