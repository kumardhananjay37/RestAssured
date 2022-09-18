package ActionPages;

import CommonFunctions.PayLoads;
import CommonFunctions.ReUseableMethods;
import ConstantsPackage.Constants;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class FirstAPI {
    public static void main(String[] args) {
        /**
         * base URI= https://rahulshettyacademy.com
         * given: All input fields will come under given including header
         * When: All resource will come after base URL with HTTP methods under when
         * Then: All validation will come under then.
         * */
        RestAssured.baseURI = Constants.BASE_URL;
        /**
         * log().all() for given function prints the request body.
         * log().all() for then function prints the response body.
         * */
//        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
//                .body(PayLoads.requestBody())
//                .when().post("maps/api/place/add/json")
//                .then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"));

        /**
         * now we are storing the response into string by extracting the response from response and put it into a String.
         * */

        /**
         * Add place
         * */
        String response = given().log().all().queryParam("key", "qaclick123").header(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON)
                .body(PayLoads.requestBodyForAdd())
                .when().post(PayLoads.resourceForBase("add"))
                .then().log().all().assertThat().statusCode(Constants.STATUS_200).body("scope", equalTo("APP")).extract().asString();
//        System.out.println(response);
//        JsonPath jsonPath = new JsonPath(response);
        JsonPath jsonPath = ReUseableMethods.rawToJson(response);
        String referenceId = jsonPath.getString("reference");
        String place_id = jsonPath.getString("place_id");
        System.out.println(referenceId);
        /**
         * Update place
         */

        given().log().all().queryParam("key", "qaclick123").header(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON)
                .body((PayLoads.requestBodyForUpdate(place_id)))
                .when().put(PayLoads.resourceForBase("update"))
                .then().log().all().assertThat().statusCode(Constants.STATUS_200).body("msg", equalTo("Address successfully updated"));

        /**
         * Get place
         * As we know no Get method have request body and header therefore we don't use them here.
         * */
        String responseAfterAddressUpdate = given().log().all().queryParam("key", "qaclick123")
                .queryParam("place_id", place_id)
                .when().get(PayLoads.resourceForBase("get"))
                .then().log().all().assertThat().statusCode(Constants.STATUS_200).extract().response().asString();
//        JsonPath jsonPath1=new JsonPath(responseAfterAddressUpdate);
        JsonPath jsonPath1 = ReUseableMethods.rawToJson(responseAfterAddressUpdate);
        String actualAddressAfterUpdate = jsonPath1.getString("address");
//        System.out.println(responseAfterAddressUpdate);
//        System.out.println(actualAddressAfterUpdate);
        String expectedUpdatedAddress = "Fatehpur, Sheohar";
        Assert.assertEquals(expectedUpdatedAddress,actualAddressAfterUpdate);

    }
}
