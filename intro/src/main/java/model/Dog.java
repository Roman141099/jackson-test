package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

@Data
@JsonPropertyOrder({"name", "age"})
public class Dog {

    @JsonSetter("name")
    private String dogName;
    @JsonIgnore
    private String ignored;
    private int age;

    @JsonValue
    public String val(){
        return "{\"test\": \"testDog\"}";
    }

}
