import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Dog;

public class JacksonAnnotations {

    public static void main(String[] args) throws JsonProcessingException {
        Dog dog = new Dog();
        dog.setDogName("Hello");
        dog.setIgnored("ignored");
        dog.setAge(123);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(dog);
        System.out.println(s);
    }

}
