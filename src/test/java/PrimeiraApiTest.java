import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class PrimeiraApiTest {

    String url = "http://localhost:8080/api";
    RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(url).build();

    @Test
    public void TesteComSucessoPrimeiraApiTest(){

        String path = "/primeiraApi";

        RestAssured.given()
                .spec(requestSpecification)
                    .log().all()
                .when()
                    .get(path)
                .then()
                    .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString("Retorno da api com sucesso!!!"));
    }

    @Test
    public void Ex2testQueryParamPrimeiraApiV1(){

        String path = "/primeiraApiV1";
        String TEXTO = "teste";

        RestAssured.given()
                .spec(requestSpecification)
                .log().all()
                .queryParams("palavra",TEXTO)
                .when()
                .get(path)
                .then()
                .log().all()
                .assertThat()
                .body(Matchers.containsString(TEXTO));

    }

    @Test
    public void Ex3testPathPAramPrimeiraApiV1(){

        String TEXTOPARAM = "teste";
        String path = "/primeiraApiV2/"+TEXTOPARAM;


        RestAssured.given()
                .spec(requestSpecification)
                .log().all()
                .when()
                .get(path)
                .then()
                .log().all()
                .assertThat()
                .body(Matchers.containsString(TEXTOPARAM));

    }

}
