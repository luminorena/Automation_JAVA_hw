package Java_3;

import Java_3.core.Application;
import Java_3.core.TaxDateCalculator;
import Java_3.data.InMemoryEmployeeRepository;
import Java_3.io.ConsoleIo;
import Java_3.io.GUIIo;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException, IllegalAccessException {


        new Application(
                new GUIIo(
                        new InMemoryEmployeeRepository()
                ),
                new TaxDateCalculator()
        ).run();


/*
        String intern = name.intern();
        System.out.println(intern);

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(final File file) {
                return file.exists() && file.isDirectory();
            }
        };

        System.out.println(fileFilter.accept(new File("new_dbEnd.xlx")));*/
    }
}
