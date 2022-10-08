package ActionPages;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import java.io.InputStream;

import static io.restassured.RestAssured.*;

public class DeckOfCards {
    private static String response;
    private static JsonPath jsonPath;

    public static void main(String[] args) {
        baseURI = "https://www.deckofcardsapi.com";

        response = given().log().all().queryParam("deck_count", "1")
                .when().get("/api/deck/new/shuffle/")
                .then().log().all().assertThat().statusCode(200).extract().asString();
        jsonPath = new JsonPath(response);
        String deckId = jsonPath.getString("deck_id");

//        "https://www.deckofcardsapi.com/api/deck/<<deck_id>>/draw/?count=2"
        response=given().log().all().queryParam("count","2")
                .when().get("/api/deck/"+deckId+"/draw/")
                .then().log().all().assertThat().statusCode(200).extract().asString();
        jsonPath = new JsonPath(response);
        System.out.println(jsonPath.getInt("remaining"));
    }
}
