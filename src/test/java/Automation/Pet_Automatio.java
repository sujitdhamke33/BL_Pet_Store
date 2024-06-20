package Automation;


import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Pet_Automatio {

    @Test
    public void new_Pet(){
        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"raju\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/pet\n");

        response.prettyPrint();
        response.then().statusCode(200);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void FPet_By_Id()
    {
        Response response = given()
                .header("accept","application/json")
                .get("https://petstore.swagger.io/v2/pet/1");

        response.prettyPrint();
    }

    @Test
    public void Find_Pet_By_Status()
    {
        Response response = given()
                .header("accept", "application/json")
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");

        response.prettyPrint();

    }

    @Test
    public void Existing_Pet_Update()
    {
        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 2,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"dogesh\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/pet");

        response.prettyPrint();
    }

    @Test
    public void Pet_Data_Update()
    {
        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .body("name=Jerry&status=Pending")
                .when()
                .post("https://petstore.swagger.io/v2/pet/2");

        response.prettyPrint();
    }

    @Test
    public  void DeletePet()
    {
        Response response=given()
                .header("accept", "application/json")
                .delete("https://petstore.swagger.io/v2/pet/2");

        response.prettyPrint();

    }
}
