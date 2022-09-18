package CommonFunctions;

import io.restassured.path.json.JsonPath;

public class ReUseableMethods {
    public static JsonPath rawToJson(String response)
    {
        JsonPath jsonPath=new JsonPath(response);
        return jsonPath;
    }
}
