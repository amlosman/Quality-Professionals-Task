package Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import readers.JsonReader;
import utils.UserUtils;

import java.util.List;

public class UserEndpointTests {
    JsonReader jsonReader = new JsonReader("src/test/resources/TestData.json");

    @Test(description = "Validate request with valid data", dataProvider = "TestData")
    public void sendRequestWithValidData(Object testDate) {
        UserUtils.sendRequestWithValidData(testDate);
    }

    @Test(description = "Validate Request without body")
    public void validateRequestWithoutBody() {
        UserUtils.sendRequestWithoutBody();
    }


    @DataProvider(name = "TestData")
    public Object[][] getTestData() {
        List<Object> objects = jsonReader.getNode("TestDataObject");
        Object[][] object = new Object[objects.size()][1];
        for (int i = 0; i < objects.size(); i++) {
            object[i][0] = objects.get(i);
        }
        return object;
    }
}
