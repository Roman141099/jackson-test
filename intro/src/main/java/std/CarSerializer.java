package std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import model.Car;

import java.io.IOException;

public class CarSerializer extends StdSerializer<Car> {

    public CarSerializer() {
        super(Car.class);
    }

    @Override
    public void serialize(Car car, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("modelAndCar", car.getColor() + "_" + car.getType());
        jsonGenerator.writeEndObject();
    }
}
