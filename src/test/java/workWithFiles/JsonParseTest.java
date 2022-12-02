package workWithFiles;

import workWithFiles.model.JsonModel;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;


public class JsonParseTest {
    ClassLoader cl = JsonParseTest.class.getClassLoader();


    @Test
    void JsonParse() throws IOException {

        try (InputStream is = cl.getResourceAsStream("testJson.json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(
                    DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JsonModel jsonModel = objectMapper.readValue(is
                    , JsonModel.class);
            Assertions.assertThat(jsonModel.name).isEqualTo("filesystem");
            Assertions.assertThat(jsonModel.type).isEqualTo("library");
            Assertions.assertThat(jsonModel.description)
                    .isEqualTo("Provides basic utilities for the filesystem");
            Assertions.assertThat(jsonModel.homepage).isEqualTo("https://symfony.com");
            Assertions.assertThat(jsonModel.license).isEqualTo("MIT");
            Assertions.assertThat(jsonModel.authors.get(0)).isEqualTo("Fabien Potencier");
            Assertions.assertThat(jsonModel.authors.get(1)).isEqualTo("Symfony Community");
            Assertions.assertThat(jsonModel.require.php).isEqualTo(">=7.2.5");
            Assertions.assertThat(jsonModel.require.sync).isEqualTo("~1.8");
            Assertions.assertThat(jsonModel.minimum_stability).isEqualTo("dev");

        }
    }
}
