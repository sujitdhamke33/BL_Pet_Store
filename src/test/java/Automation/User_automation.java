package Automation;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class User_automation {
    @Test
    public void create_ur(){
        Response res = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 101,\n" +
                        "  \"username\": \"hardik\",\n" +
                        "  \"firstName\": \"string\",\n" +
                        "  \"lastName\": \"string\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \"Hardik\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/user");
                 res.prettyPrint();
        res.then().statusCode(200);

    }

    @Test
    public void login(){
        Response res = given()
                .header("accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/login?username=Hardik&password=Hardik");
        res.prettyPrint();
    }
@Test
    public void update(){
        Response res = given()
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 111,\n" +
                        "  \"username\": \"Sahil\",\n" +
                        "  \"firstName\": \"string\",\n" +
                        "  \"lastName\": \"string\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \"Sahil\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/user/Hardik");
        res.prettyPrint();
    }

    @Test
    public void getByUsername(){
        Response res = given()
                .header("accept","application/json")
                .when()
                .post("https://petstore.swagger.io/v2/user/Sahil");
        res.prettyPrint();
    }

    @Test
    public void delete(){
        Response res = given()
                .header("accept","application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/user/Sahil");
        res.prettyPrint();
    }

    @Test
    public void deleteLogin(){
        Response res = given()
                .header("accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/logout");
        res.prettyPrint();
    }
    @Test
     public void createWithArray(){
        Response res = given()
                     .header("accept","application/json")
                     .header("Content-Type","application/json")
                     .body("[\n" +
                             "  {\n" +
                             "    \"id\": 222,\n" +
                             "    \"username\": \"Rohit\",\n" +
                             "    \"firstName\": \"string\",\n" +
                             "    \"lastName\": \"string\",\n" +
                             "    \"email\": \"string\",\n" +
                             "    \"password\": \"Rohit\",\n" +
                             "    \"phone\": \"string\",\n" +
                             "    \"userStatus\": 0\n" +
                             "  },{\n" +
                             "    \"id\": 223,\n" +
                             "    \"username\": \"Rohit1\",\n" +
                             "    \"firstName\": \"string\",\n" +
                             "    \"lastName\": \"string\",\n" +
                             "    \"email\": \"string\",\n" +
                             "    \"password\": \"Rohit1\",\n" +
                             "    \"phone\": \"string\",\n" +
                             "    \"userStatus\": 0\n" +
                             "  }\n" +
                             "]")
                     .when()
                     .post("https://petstore.swagger.io/v2/user/createWithArray");
             res.prettyPrint();
         }
     }

