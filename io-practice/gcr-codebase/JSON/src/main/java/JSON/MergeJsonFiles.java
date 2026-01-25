package JSON;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;

public class MergeJsonFiles {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
 
        JsonNode json1 = mapper.readTree(new File("src/main/resources/file1.json"));
        JsonNode json2 = mapper.readTree(new File("src/main/resources/file2.json"));
 
        ObjectNode merged = mapper.createObjectNode();
 
        merged.setAll((ObjectNode) json1);
 
        merged.setAll((ObjectNode) json2);
 
        String result = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(merged);

        System.out.println(result);
    }
}
