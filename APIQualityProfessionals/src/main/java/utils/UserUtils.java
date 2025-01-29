package utils;

import Endpoints.EndPoints;
import Endpoints.PropertiesReader;
import org.openqa.selenium.remote.Response;

public class UserUtils {
    public static void sendRequestWithValidData(Object bodyDate) {
         RestHelper.restPostRequestWithBody(PropertiesReader.getValue("BaseURL"), bodyDate, EndPoints.UserEndPoint, 200);
    }
    public static void sendRequestWithoutBody() {
        RestHelper.restPostRequestWithoutBody(PropertiesReader.getValue("BaseURL"), EndPoints.UserEndPoint, 405);
    }
}
