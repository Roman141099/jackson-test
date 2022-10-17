import model.Car;

public class IntroJackson {

    public static void main(String[] args) {
        carFromString();
    }

    static void carToString(){
        JacksonService jacksonService = new JacksonService();
        String car = jacksonService.serializeCar(new Car("White", "Sedan"));
        System.out.println(car);
    }

    static void carFromString(){
        JacksonService jacksonService = new JacksonService();
        Car car = jacksonService.deserializeCar("{\"modelAndCar\":\"White_Sedan\"}");
//                jacksonService.deserializeCar("{\"color\":\"White\",\"type\":\"Sedan\"}");
        System.out.println(car);
    }

    static void type(){
        JacksonService jacksonService = new JacksonService();
        String json = "{\"color\":\"White\",\"type\":\"Sedan\"}";
        System.out.println(jacksonService.getType(json));
    }

    static void list(){
        JacksonService jacksonService = new JacksonService();
        String json = "[{\"color\":\"White\",\"type\":\"Sedan\"}, {\"color\":\"White\",\"type\":\"Sedan\"}]";
        System.out.println(jacksonService.getList(json));
    }

    static void listUnrecognized(){
        JacksonService jacksonService = new JacksonService();
        String json = "[{\"color\":\"White\",\"type\":\"Sedan\", \"weight\":\"100\"}, {\"color\":\"White\",\"type\":\"Sedan\"}]";
        System.out.println(jacksonService.getList(json));
    }

}
