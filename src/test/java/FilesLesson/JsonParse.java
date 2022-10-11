package FilesLesson;

import FilesLesson.model.TestJson;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class JsonParse {
    ClassLoader ci = JsonParse.class.getClassLoader();

    @Test
    void jsonTestWithGson() throws IOException {
        try (InputStream is = ci.getResourceAsStream("testJson.json")){
            Gson gson = new Gson();
            JsonObject jsonObject = gson
                    .fromJson(new InputStreamReader(is), JsonObject.class);
            assertThat(jsonObject.get("name").getAsString()).isEqualTo("Olga");
            assertThat(jsonObject.get("age").getAsInt()).isEqualTo(32);
            assertThat(jsonObject.get("profession").getAsString()).isEqualTo("QA");

        }


    }

    @Test
    void jsonTestWithGsonAndModel() throws IOException {
        try (InputStream is = ci.getResourceAsStream("testJson.json")){
            Gson gson = new Gson();
            TestJson testJson = gson
                    .fromJson(new InputStreamReader(is), TestJson.class);
            assertThat(testJson.name).isEqualTo("Olga");
            assertThat(testJson.age).isEqualTo(32);
            assertThat(testJson.profession).isEqualTo("QA");
            assertThat(testJson.passport.number).isEqualTo(123456);
            assertThat(testJson.passport.issueDate).isEqualTo("02.12.2022");


        }


    }
}
