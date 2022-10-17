import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import model.Car;
import std.CarDeserializer;
import std.CarSerializer;

import java.lang.reflect.Type;
import java.util.List;

public class JacksonService {

    private final ObjectMapper objectMapper;

    public JacksonService() {
        objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(new CarSerializer());
        module.addDeserializer(Car.class, new CarDeserializer());
        objectMapper.registerModule(module);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public String serializeCar(Car car){
        try {
            return objectMapper.writeValueAsString(car);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error";
        }
    }

    public Car deserializeCar(String car){
        try {
            return objectMapper.readValue(car, Car.class);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public String getType(String json){
        try {
            JsonNode main = objectMapper.readTree(json);
            return main.get("type").asText();
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public List<Car> getList(String json){
        try {
            return objectMapper.readValue(json, new TypeReference<>() {});
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}
