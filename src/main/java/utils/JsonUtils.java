package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonUtils {

    public static Map<String, Object> getJsonDataAsMap(String jsonFileName) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        String completeJsonPath = System.getProperty("user.dir") + "/src/test/resources/" + jsonFileName;
        Map<String, Object> jsonFiledata = objectMapper.readValue(new File(completeJsonPath), new TypeReference<>() {
        });

        return jsonFiledata;
    }
}

