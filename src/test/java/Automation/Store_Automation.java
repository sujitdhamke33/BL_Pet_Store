package Automation;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Store_Automation {
    @Test
    public void place_Order(){
      Response res = given()
              .header("accept","application/json")
              .header("Content-Type","application/json")
              .body("{\n" +
                      "  \"id\": 1,\n" +
                      "  \"petId\": 0,\n" +
                      "  \"quantity\": 10,\n" +
                      "  \"shipDate\": \"2024-05-28T17:00:20.848Z\",\n" +
                      "  \"status\": \"placed\",\n" +
                      "  \"complete\": true\n" +
                      "}")
              .when()
              .post("https://petstore.swagger.io/v2/store/order");
      res.prettyPrint();
    }

@Test
    public void getBYId(){
        Response res = given()
                .header("accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/order/1\n");
        res.prettyPrint();
    }

    @Test
    public void status(){
        Response res = given()
                .header("accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory");
        res.prettyPrint();
    }

    @Test
    public void delete(){
        Response res = given()
                .header("accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/order/1");
        res.prettyPrint();
    }
}
