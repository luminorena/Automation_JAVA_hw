package Java_3.core;

import Java_3.domain.Employee;
import Java_3.io.Io;

import java.text.ParseException;
import java.util.Date;

public class Application {
    private final Io io;
    private final TaxDateCalculator taxDateCalculator;

    public Application(Io io, TaxDateCalculator taxDateCalculator) {
        this.io = io;
        this.taxDateCalculator = taxDateCalculator;
    }

    public void run() throws IllegalAccessException, ParseException {
        Employee employee = io.readEmployee();
        io.inputDepartureDate(employee);
        taxDateCalculator.calculateLostDate(employee);
        io.printEmployee("Результат: ", employee);

    }
}
