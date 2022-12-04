package Java_3.data;

import Java_3.domain.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryEmployeeRepositoryTest {

    private InMemoryEmployeeRepository tested = new InMemoryEmployeeRepository();

    @Test
    void saveTestWithEmptyName() {
        Employee employee0 = new Employee(null, "Ivanov");
        Employee employee1 = new Employee("", "Ivanov");
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    tested.save(employee0);
                    tested.save(employee1);
                }
        );
        Assertions.assertEquals("Сотрудник не может быть без имени"
                , exception.getMessage());



    }
}