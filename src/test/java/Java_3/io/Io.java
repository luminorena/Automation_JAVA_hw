package Java_3.io;

import Java_3.domain.Employee;

import javax.annotation.Nonnull;
import java.text.ParseException;

public interface Io {

    @Nonnull
    Employee readEmployee() throws IllegalAccessException;
    void printEmployee(String message, Employee employee);
    Employee inputDepartureDate(Employee employee) throws ParseException;
}
