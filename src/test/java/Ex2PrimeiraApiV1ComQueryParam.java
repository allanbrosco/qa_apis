import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class Ex2PrimeiraApiV1ComQueryParam {

    @Test
    public void Ex2testQueryParamPrimeiraApiV1(){

        String url = "http://localhost:8080/api/primeiraApiV1";
        String TEXTO = "teste";

        RestAssured.given()
                    .log().all()
                .queryParams("palavra",TEXTO)
                .when()
                    .get(url)
                .then()
                .log().all()
                .assertThat()
                .body(Matchers.containsString(TEXTO));

    }
}
