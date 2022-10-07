package ActionPages;


import static io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;

public class ReqRes {
    public static void main(String[] args) {
        baseURI = "https://reqres.in/";
/***  GET request--------------------------------->>>>>>>
 */
//        given().log().all().queryParam("page", 2)
//                .when().get("api/users")
//                .then().log().all().assertThat().statusCode(200);
/**
 * POST request--------------------------------->>>>>>>
 * */
//        given().log().all().header("Content-Type", "application/json")
//                .body("{\n" +
//                        "    \"name\": \"morpheus\",\n" +
//                        "    \"job\": \"leader\"\n" +
//                        "}")
//                .when().post("api/users?page=2")
//                .then().log().all().assertThat().statusCode(201);
//    }
// PUT request--------------------------------->>>>>>>

//        given().log().all().header("Content-Type","application/json")
//                .body("{\n" +
//                        "    \"name\": \"morpheus\",\n" +
//                        "    \"job\": \"zion resident\"\n" +
//                        "}")
//                .when().put("/api/users/2")
//                .then().log().all().assertThat().statusCode(200);
// DELETE---------------------------------->>>>>>>>>
        given().log().all().header("Content-Type", "application/json")
                .when().delete("/api/users/2")
                .then().log().all().assertThat().statusCode(204);
    }

}
