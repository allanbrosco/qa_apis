import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class Ex6ValidaCpf {

    @Test
    public void validaCpf(){

        String url = "http://localhost:8080/exercicios/validarCpf";

        String CPFVALIDO = "84700459468";

        RestAssured.given()
                .log().all()
                .queryParams("cpf",CPFVALIDO)
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString("CPF Valido"));

    }

    @Test
    public void invalidaCpf(){

        String url = "http://localhost:8080/exercicios/validarCpf";

        String CPFINVALIDO = "84700459469";

        RestAssured.given()
                .log().all()
                .queryParams("cpf",CPFINVALIDO)
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString("CPF Invalido"));
    }

}
