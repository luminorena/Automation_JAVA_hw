package FilesLesson;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;


public class FileParseTest {

    ClassLoader cl = FileParseTest.class.getClassLoader();

    @Test
    void pdfTest() throws IOException {
        PDF pdf = new PDF(new File("src\\test\\resources\\file.pdf"));
        System.out.println(pdf.text);
        assertThat(pdf.text).contains("Лабораторная работа № 3 ");

    }

    @Test
    void xlsTest() throws IOException {
        try (InputStream is = cl.getResourceAsStream("dbEnd.xlsx")) {
            XLS xls = new XLS(is);
            String stringCellValue = xls.excel.getSheetAt(0)
                    .getRow(1).getCell(1).getStringCellValue();
            System.out.println(stringCellValue);
            assertThat(stringCellValue).contains("2010-01-01 00:00:00");

        }
    }

    @Test
    void csvTest() throws IOException, CsvException {
        try (InputStream is = cl.getResourceAsStream("CSVSample_user.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(is))) {
            List<String[]> content = reader.readAll();
            String[] row = content.get(1);
            assertThat(row[0]).isEqualTo("u2");
            assertThat(row[1]).isEqualTo("p2");
        }

    }

    @Test
    void zipTest() throws IOException {
        try (InputStream is = cl.getResourceAsStream("resources.zip");
             ZipInputStream zip = new ZipInputStream(is)) {
            ZipEntry zipentry;
            while ((zipentry = zip.getNextEntry()) != null) {
                String ZipName = zipentry.getName();
            }

        }
    }
}
