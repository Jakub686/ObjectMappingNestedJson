import com.fasterxml.jackson.core.JsonParseException;

import java.io.*;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadWriteMapJsonFile {
    public static void main(String[] args) {
        //TODO z jsona stworzyc tymczasowy obiekt z ktorego stworze obiekt do mapy

        //read from file
        ObjectMapper mapper = new ObjectMapper();
        RequestSetFormFile requestSetFormFile = new RequestSetFormFile();
        try {
            requestSetFormFile = mapper.readValue(new File("D:\\java examples\\ObjectMappingNestedJson\\src\\main\\java\\fromFile.json"), RequestSetFormFile.class);
            System.out.println(requestSetFormFile.getType());
            System.out.println(requestSetFormFile.getKey());
            Value value = requestSetFormFile.getValue();
            System.out.println(value.getName());
            Car car = value.getCar();
            System.out.println(car.getModel());
            System.out.println(car.getYear());
            Rocket rocket = value.getRocket();
            System.out.println(rocket.getName());
            System.out.println(rocket.getLaunches());

        } catch (JsonParseException e) {
        } catch (JsonMappingException e) {
        } catch (IOException e) {
        }

        //Write to file

        try {
            String json = mapper.writeValueAsString(requestSetFormFile);
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\java examples\\ObjectMappingNestedJson\\src\\main\\java\\intoFile.json"));
            writer.write(json);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
