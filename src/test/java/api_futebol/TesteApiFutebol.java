package api_futebol;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.requestSpecification;

public class TesteApiFutebol {
    @Test
    public void ExercicioApi_Futebol() {
        String path = "https://api.api-futebol.com.br/v1/campeonatos";
        String CPFVALIDO = "84700459468";

        RestAssured.given()
                .log().all()
                .header("Authorization", "Bearer live_369a3475ba039356ce2add7815da12")
                .when()
                .get(path)
                .then()
                .log().all()
                .assertThat()
                .statusCode(429)
                .body(Matchers.containsString("Voc\\u00ea atingiu o limite di\\u00e1rio de requisi\\u00e7\\u00f5es. Fa\\u00e7a upgrade do seu plano ou tente amanh\\u00e3.\",\"code\":429"));
    }
}
