package ActionPages;

import io.restassured.RestAssured;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CreateUser {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://uat-deckard.payfare.com";
        HashMap<String, String> headerContains = new HashMap<>();

        headerContains.put("X-PFClient-Key", "e83ed3f7-1c3b-4d68-b74c-dc6f03ab0f0a");
        headerContains.put("X-PFClient-Secret", "12278cfe-1060-4cc7-b8a2-b9d389bd2fd9");
        headerContains.put("Content-Type", "application/json");

//        String createUserResponce = given().log().all().headers(headerContains)
//                .body("\n" +
//                        "    \"first_name\": \"Dhananjay\",\n" +
//                        "    \"last_name\": \"Smith\",\n" +
//                        "    \"phone_number\": \"+16477107432\",\n" +
//                        "    \"email\": \"John6926119+force+1@payfare.com\",\n" +
//                        "    \"reward_tier\": \"Platinum\",\n" +
//                        "    \"address\": {\n" +
//                        "        \"address_line1\": \"111 Lafayette Road\",\n" +
//                        "        \"city\": \"Syracuse\",\n" +
//                        "        \"region\": \"NY\",\n" +
//                        "        \"postal_code\": \"13205\",\n" +
//                        "        \"country_code\": \"us\"\n" +
//                        "    },\n" +
//                        "    \"date_of_birth\": \"1975-02-02\",\n" +
//                        "    \"external_id\": \"ext-id-6926119\",\n" +
//                        "    \"express_consent\": [\n" +
//                        "        {\n" +
//                        "            \"name\": \"Agreement A\",\n" +
//                        "            \"date\": \"2018-01-01\",\n" +
//                        "            \"accepted\": 1\n" +
//                        "        }\n" +
//                        "    ],\n" +
//                        "    \"preferred_language\": \"en-us\"")
//                .when().post("/v1/users")
//                .then().log().all().assertThat().statusCode(200).extract().asString();
//
//        System.out.println(createUserResponce);

        String finalKycResponse = given().log().all().headers(headerContains)
                .when().get("/v1/users/2b9e75c9-306f-4aaf-b436-6fab95bb9c57/kyc")
                .then().log().all().statusCode(200).extract().asString();
        System.out.println(finalKycResponse);
    }
}
