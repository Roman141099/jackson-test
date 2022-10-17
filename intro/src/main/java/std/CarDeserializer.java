package std;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import model.Car;

import java.io.IOException;

public class CarDeserializer extends StdDeserializer<Car> {

    public CarDeserializer() {
        super(Car.class);
    }

    @Override
    public Car deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectCodec codec = jsonParser.getCodec();
        JsonNode treeNode = codec.readTree(jsonParser);
        String modelAndCar = treeNode.get("modelAndCar").asText();
        return new Car(modelAndCar.split("_")[0], modelAndCar.split("_")[1]);
    }
}
