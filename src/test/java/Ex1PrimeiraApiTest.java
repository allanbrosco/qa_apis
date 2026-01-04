import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class Ex1PrimeiraApiTest {

    @Test
    public void TesteComSucessoPrimeiraApiTest(){

        String url = "http://localhost:8080/api/primeiraApi";

        RestAssured.given()
                    .log().all()
                .when()
                    .get(url)
                .then()
                    .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString("Retorno da api com sucesso!!!"));
    }
}
