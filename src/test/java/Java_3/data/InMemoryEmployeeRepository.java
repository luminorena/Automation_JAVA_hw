package Java_3.data;

import Java_3.domain.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemoryEmployeeRepository implements EmployeeRepository{
    private final static Map<UUID, Employee> storage = new HashMap<>();
    // блок статической инициализации, сюда можно пихать статик поля
    static {
      Employee exisingEmployee0 = new Employee(UUID.randomUUID(),
              "Вася", "Пупкин");
        Employee exisingEmployee1 = new Employee(UUID.randomUUID(),
                "Петя", "Петров");
      storage.put(exisingEmployee0.getId(), exisingEmployee0);
      storage.put(exisingEmployee1.getId(), exisingEmployee1);
    }

    @Override
    public Optional<Employee> lookup(String name, String surName) {
        for (Employee employee : storage.values()) {
            if (employee.getName().equals(name) && employee.getSurName().equals(surName)) {
                return Optional.of(employee);
            }
        }
            return Optional.empty();

    }

    @Override
    public Employee save(Employee employee) {
        if (employee.getId() != null && storage.get(employee.getId()) != null) {
            throw new IllegalArgumentException("Объект уже сохранен в storage!");
        }
        if (employee.getName() == null || employee.getSurName().equals("")) {
            throw new IllegalArgumentException("Сотрудник не может быть без имени");
        }
        employee.setId(UUID.randomUUID());
        storage.put(employee.getId(), employee);
        return employee;

    }

    @Override
    public Employee update(Employee employee) throws IllegalAccessException {
        if (employee.getId() == null || storage.get(employee.getId()) == null) {
            throw new IllegalAccessException("Объект не может быть " +
                    "изменен, так как отсутствует в storage!");
        }
        storage.put(employee.getId(), employee);
        return employee;
    }
}
