package Java_3.io;

import Java_3.data.EmployeeRepository;
import Java_3.domain.Employee;
import com.toedter.calendar.JDateChooser;

import javax.annotation.Nonnull;
import javax.swing.*;

import java.util.Optional;

import static javax.swing.JOptionPane.OK_OPTION;

public class GUIIo implements Io {
    private final EmployeeRepository employeeRepository;

    public GUIIo(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public @Nonnull Employee readEmployee() throws IllegalAccessException {
        JTextField name = new JTextField();
        JTextField surname = new JTextField();
        Object[] msgBody = {
                "Имя: ", name,
                "Фамилия: ", surname
        };
        int option = JOptionPane.showConfirmDialog(null, msgBody,
                "Введите данные сотрудника", JOptionPane.OK_CANCEL_OPTION);
        if (option == OK_OPTION) {
            Optional<Employee> employee = employeeRepository
                    .lookup(name.getText(), surname.getText());
            if (employee.isPresent()) {
                printEmployee("Найден сотрудник: ", employee.get());
                return employee.get();
            }
            else {
                Employee addedEmployee = new Employee(name.getText(), surname.getText());
                employeeRepository.save(addedEmployee);
                printEmployee("Добавлен новый сотрудник: ", addedEmployee);
                return addedEmployee;
            }

        }
        else {
            JOptionPane.showMessageDialog(null, "Действие отменено");
            System.exit(0);
        }
        return null;
    }

    @Override
    public void printEmployee(String message, Employee employee) {
        String msg = employee.getDateOfLoseTaxResidence() == null
                ? message + employee.getName() + " " + employee.getSurName()
                : message + employee.getName() + " "
                + employee.getSurName() + " ,дата потери резидентства: "
                + employee.getDateOfLoseTaxResidence();
        JOptionPane.showMessageDialog(null, msg);

    }

    @Override
    public Employee inputDepartureDate(Employee employee) {
        JDateChooser jDateChooser = new JDateChooser();
        Object[] msgBody = {
                "Дата отъезда: ", jDateChooser

        };
         JOptionPane.showConfirmDialog(null, msgBody,
                "Введите данные сотрудника", JOptionPane.DEFAULT_OPTION);
         employee.setDepartureDate(jDateChooser.getDate());
         return employee;
    }
}
