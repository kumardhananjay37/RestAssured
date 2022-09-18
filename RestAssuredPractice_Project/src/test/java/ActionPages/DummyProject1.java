package ActionPages;

import CommonFunctions.PayLoads;
import CommonFunctions.ReUseableMethods;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class DummyProject1 {

    public static void main(String[] args) {
        JsonPath jsonPath = ReUseableMethods.rawToJson(PayLoads.dummyJasonResponse());
        int allCourseSize = jsonPath.getInt("courses.size()");
        System.out.println(allCourseSize);
        String secondCourseTitle = jsonPath.getString("courses[2].title");
        System.out.println(secondCourseTitle);
        for (int i = 0; i < allCourseSize; i++) {
            Object title = jsonPath.get(String.format("courses[%s].title", i));
            System.out.println(String.format("%s title name is: %s", i, title));
            System.out.println(String.format(jsonPath.get(String.format("courses[%s].title", i))));
        }
        /**
         * Print the date with specific association
         * */
        for (int i = 0; i < allCourseSize; i++) {
            String title = jsonPath.get(String.format("courses[%s].title", i));
            if (title.equalsIgnoreCase("Cypress")) {
                int copiesCount = jsonPath.getInt(String.format("courses[%s].copies", i));
                System.out.println(copiesCount);
                break;
            }
        }

        /**
         * Validate purchase amount is equal to the total amount spent on each courses along with their copies.
         * */

        int expectedPurchagedAmount = jsonPath.getInt("dashboard.purchaseAmount");
        int actualTotalAmountForPurchasedCost = 0;
        for (int i = 0; i < allCourseSize; i++) {
            int price = jsonPath.getInt(String.format("courses[%s].price", i));
            int copies = jsonPath.getInt(String.format("courses[%s].copies", i));
            actualTotalAmountForPurchasedCost += price * copies;
        }
        System.out.println(actualTotalAmountForPurchasedCost);
        Assert.assertEquals(expectedPurchagedAmount,actualTotalAmountForPurchasedCost);

    }
}
