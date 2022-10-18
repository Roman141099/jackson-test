import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Dog;

import java.time.OffsetDateTime;
import java.util.Map;

public class JacksonAnnotations {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

//        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

        Dog dog = new Dog();
        dog.setName("Hello");
        dog.setIgnored("ignored");
        dog.setAge(123);
        dog.setProps(Map.of("prop1", "prop2", "prop3", "prop4"));
        dog.setRawValue("RawValue");
        dog.setLastTimeCalled(OffsetDateTime.now());

        String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dog);
        System.out.println(s);

        Dog doggy = objectMapper.readerFor(Dog.class)
                .readValue("{\"lastTimeCalled\": \"2022-10-10T14:10:10+04:00\", \"name\": \"NAME\"}");
        System.out.println();

    }

}
