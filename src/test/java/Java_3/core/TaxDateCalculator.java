package Java_3.core;

import Java_3.domain.Employee;

import java.util.Calendar;
import java.util.Date;

public class TaxDateCalculator {
    //single responsibility principle - каждый объект должен иметь одну обязанность
    public void calculateLostDate(Employee employee){
        Calendar cal = Calendar.getInstance();
        cal.setTime(employee.getDepartureDate());
        cal.add(Calendar.DATE, 183);
        employee.setDateOfLoseTaxResidence(cal.getTime());
    }
}
