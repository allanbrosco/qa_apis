import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class Ex4QueryParamParouImpar {

    @Test
    public void Ex4testQueryParamParOuImpar(){

        String VALORIMPAR = "1";
        String VALORPAR = "2";
        String MSGIMPAR = "O numero " + VALORIMPAR +" é impar";
        String MSGPAR = "O numero " + VALORPAR +" é par";
        String url = "http://localhost:8080/exercicios/parOuImpar";

        RestAssured.given()
                .log().all()
                .queryParams("numero",VALORIMPAR)
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .body(Matchers.containsString(MSGIMPAR));

        RestAssured.given()
                .log().all()
                .queryParams("numero",VALORPAR)
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .body(Matchers.containsString(MSGPAR));

    }
}
