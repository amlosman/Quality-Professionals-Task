package StepDef;

import org.testng.annotations.Test;
import readers.JsonReader;
import utils.UserUtils;

public class UserEndpointTests {
JsonReader jsonReader = new JsonReader("src/test/resources/TestData.json");
    @Test(description = "Validate request with valid data")
    public void sendRequestWithValidData(){
        UserUtils.sendRequestWithValidData(jsonReader.jsonObject);
    }
    @Test(description = "Validate Request without body")
    public void validateRequestWithoutBody(){
        UserUtils.sendRequestWithoutBody();
    }


}
