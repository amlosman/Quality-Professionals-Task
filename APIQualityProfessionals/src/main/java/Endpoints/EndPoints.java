package Endpoints;

import lombok.Getter;
import org.apache.http.annotation.Contract;

public enum  EndPoints{
    UserEndPoint("/user");
   public String value;
    EndPoints(String value) {
        this.value= value;
    }
}
