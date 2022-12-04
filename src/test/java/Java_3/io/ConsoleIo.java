package Java_3.io;

import Java_3.data.EmployeeRepository;
import Java_3.domain.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

public class ConsoleIo implements Io{
    private final Scanner sc = new Scanner(System.in);
    private final  EmployeeRepository employeeRepository;

    public ConsoleIo(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee readEmployee() throws IllegalAccessException {
        System.out.println("Введите имя сотрудника:");
        String name = sc.nextLine();
        System.out.println("Введите фамилию сотрудника:");
        String surname = sc.nextLine();
        Optional<Employee> employee = employeeRepository.lookup(name, surname);
        if (employee.isPresent()) {
            printEmployee("Найден сотрудник: ", employee.get());
            return employee.get();
        }
        else {
            Employee addedEmployee = new Employee(name, surname);
            employeeRepository.save(addedEmployee);
            printEmployee("Добавлен новый сотрудник: ", addedEmployee);
            return addedEmployee;
        }

    }

    @Override
    public void printEmployee(String message, Employee employee) {
        String msg = employee.getDateOfLoseTaxResidence() == null
                ? message + employee.getName() + " " + employee.getSurName()
                : message + employee.getName() + " "
                + employee.getSurName() + " ,дата потери резидентства: "
                + employee.getDateOfLoseTaxResidence();
        System.out.println(msg);
    }

    @Override
    public Employee inputDepartureDate(Employee employee)  {
        System.out.println("Введите дату отъезда из страны:");
        String sourceDate = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date departureDate = sdf.parse(sourceDate);
            employee.setDepartureDate(departureDate);
        } catch (ParseException e) {
            throw  new IllegalStateException("Введена дата неверного формата");
        }
        return employee;
    }
}
