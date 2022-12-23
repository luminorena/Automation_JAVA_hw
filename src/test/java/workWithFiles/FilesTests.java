package workWithFiles;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FilesTests {

    ClassLoader cl = FilesTests.class.getClassLoader();

    @Test
    void zipTest() throws IOException {
        try (InputStream is = cl.getResourceAsStream("resources.zip");
             ZipInputStream zip = new ZipInputStream(is)) {
            ZipEntry zipentry;
            while ((zipentry = zip.getNextEntry()) != null) {
                String ZipName = zipentry.getName();
                System.out.println(ZipName);

                // распаковка
                FileOutputStream fout = new FileOutputStream("new_" + ZipName);
                for (int c = zip.read(); c != -1; c = zip.read()) {
                    fout.write(c);
                }
            }

        }
    }

    @Test
    void csvTest() throws IOException, CsvException {
        try (InputStream is = cl
                .getResourceAsStream("new_CSVSample_user.csv");
             CSVReader reader = new CSVReader(new InputStreamReader(is))) {
            List<String[]> content = reader.readAll();
            String[] row = content.get(1);
            System.out.println(Arrays.toString(row));
            Assertions.assertThat(row[0]).isEqualTo("u2");
            Assertions.assertThat(row[1]).isEqualTo("p2");
        }
    }

   // @Test
   /* void xlsxTest() throws IOException {
        try (InputStream is = cl.getResourceAsStream("new_dbEnd.xlsx")) {
            XLS xls = new XLS(is);
            String stringCellValue = xls
                    .excel
                    .getSheetAt(0)
                    .getRow(1)
                    .getCell(1)
                    .getStringCellValue();
            Assertions.assertThat(stringCellValue).contains("2010-01-01 00:00:00");

        }
    }*/

    @Test
    void pdfTest() throws IOException {
        PDF pdf = new PDF(new File("src\\test\\resources\\new_file.pdf"));
        Assertions.assertThat(pdf.text).contains("ПОСТРОЕНИЕ UML-МОДЕЛИ СИСТЕМЫ");
    }


}