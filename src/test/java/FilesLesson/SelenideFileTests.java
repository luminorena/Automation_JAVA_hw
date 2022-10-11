package FilesLesson;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.Selenide;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideFileTests {
    // если нет ссылки на href
   /* static {
        Configuration.fileDownload = FileDownloadMode.PROXY;
    }*/

    @Test
    void selenideFileDownloadTest() throws IOException {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File downloadedFile = $("#raw-url").download();
        try (InputStream inputStream = new FileInputStream(downloadedFile)) {
            byte[] fileSource = inputStream.readAllBytes();
            String fileContent = new String(fileSource, StandardCharsets.UTF_8);
            Assertions.assertThat(fileContent)
                    .contains("This repository is the home of the next generation of JUnit");
        }


    }

    @Test
    void uploadFile() throws Exception{
        Configuration.holdBrowserOpen = true;
        open("https://fineuploader.com/demos.html");
        $("input[type='file']").uploadFromClasspath("cat.jpg");
        $("div.qq-file-info").shouldHave(text("cat.jpg"));
    }
}
