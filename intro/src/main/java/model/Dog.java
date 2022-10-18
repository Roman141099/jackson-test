package model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import std.UTCDateTimeDeserializer;

import java.time.OffsetDateTime;
import java.util.Map;

@Data
@JsonPropertyOrder({"name", "age"})
@NoArgsConstructor
public class Dog {

    @JsonSetter("name")
    private String name;
    @JsonIgnore
    private String ignored;
    private int age;
    @JsonDeserialize(using = UTCDateTimeDeserializer.class)
    private OffsetDateTime lastTimeCalled;
    private Map<String, String> props;
    @JsonRawValue
    private String rawValue;

    @JsonAnyGetter
    public Map<String, String> getProps() {
        return props;
    }

    @JsonCreator
    public Dog(
            @JsonProperty("name") String name) {
        this.name = name;
    }

    //    @JsonValue
    public String val(){
        return "{\"test\": \"testDog\"}";
    }

}
