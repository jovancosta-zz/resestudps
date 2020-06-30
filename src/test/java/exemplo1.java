import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class exemplo1 {

    @Test
    public void exemplogt() {
        RestAssured.baseURI = "https://pokeapi.co/api/v2/";
        RequestSpecification request = RestAssured.given();
        Response response = request.get("pokemon/1/");

        System.out.println(response.statusCode());

        Assert.assertEquals(200, response.statusCode());

        System.out.println(response.jsonPath().get("forms[0].name").toString());
        Assert.assertEquals("bulbasaur", response.jsonPath().get("forms[0].name").toString());
    }
}