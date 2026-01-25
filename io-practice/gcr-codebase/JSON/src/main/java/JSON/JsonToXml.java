package JSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXml {

    public static void main(String[] args) throws Exception {

        String json = """
        {
          "name": "Aditi",
          "age": 22,
          "city": "Delhi"
        }
        """;
 
        ObjectMapper jsonMapper = new ObjectMapper();
        JsonNode jsonNode = jsonMapper.readTree(json);
 
        XmlMapper xmlMapper = new XmlMapper();
 
        String xml = xmlMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonNode);

        System.out.println(xml);
    }
}
