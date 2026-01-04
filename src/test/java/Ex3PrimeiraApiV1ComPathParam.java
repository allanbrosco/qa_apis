import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.security.PublicKey;

public class Ex3PrimeiraApiV1ComPathParam {

    @Test
    public void Ex3testPathPAramPrimeiraApiV1(){

        String TEXTOPARHPARAM = "Path Paramentro";
        String url = "http://localhost:8080/api/primeiraApiV2/"+TEXTOPARHPARAM;


        RestAssured.given()
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .body(Matchers.containsString(TEXTOPARHPARAM));

    }
}
