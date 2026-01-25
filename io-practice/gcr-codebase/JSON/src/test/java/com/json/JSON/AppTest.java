package com.json.JSON;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void jacksonShouldSerializeObject() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        App p = new App();
        p.setName("Aditi");
        p.setAge(22);

        String json = mapper.writeValueAsString(p);

        assertEquals("{\"name\":\"Aditi\",\"age\":22}", json);
    }
}
