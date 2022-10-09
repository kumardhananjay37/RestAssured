package DataProviderExcelSheet;

import io.restassured.RestAssured;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojoClasses.Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ExcelSheetDataProvider {
    @DataProvider(name = "Get_Data")
    public Object[][] getData() throws IOException {
        FileInputStream fis = new FileInputStream("File Location");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("SheetName will come here");
        int rowCount = sheet.getPhysicalNumberOfRows();
//        int columnCount=sheet.getCo
        Object[][] data = new Object[rowCount][2];// that means there n number of row but the column count is 2.
        for (int i = 0; i < rowCount; i++) {
            XSSFRow row=sheet.getRow(i);
            data[i][0]=row.getCell(0).toString();
            data[i][1]=row.getCell(1).toString();
        }
        return data;
    }

    @Test(dataProvider = "Get_Data")
    public void myTest(String userName,String workProfile){
        RestAssured.baseURI="https://reqres.in";
//        /api/users
        given().log().all().header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"name\": \""+userName+"\",\n" +
                        "    \"job\": \""+workProfile+"\"\"\n" +
                        "}")
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201);
    }

}
