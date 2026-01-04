import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;

public class TestesExercicios {

    String url = "http://localhost:8080/exercicios/";
    RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(url).build();

    @Test
    public void Ex4testQueryParamParOuImpar() {

        String VALORIMPAR = "1";
        String VALORPAR = "2";
        String MSGIMPAR = "O numero " + VALORIMPAR + " é impar";
        String MSGPAR = "O numero " + VALORPAR + " é par";
        String path = "/parOuImpar";

        RestAssured.given()
                .spec(requestSpecification)
                .log().all()
                .queryParams("numero", VALORIMPAR)
                .when()
                .get(path)
                .then()
                .log().all()
                .assertThat()
                .body(Matchers.containsString(MSGIMPAR));

        RestAssured.given()
                .spec(requestSpecification)
                .log().all()
                .queryParams("numero", VALORPAR)
                .when()
                .get(path)
                .then()
                .log().all()
                .assertThat()
                .body(Matchers.containsString(MSGPAR));
    }

    @Test
    public void calculasalario() {
        String pathParamSalario = "3000";
        String path = "/calculaSalario/" + pathParamSalario;

        RestAssured.given()
                .spec(requestSpecification)
                .log().all()
                .when()
                .get(path)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString("Salario bruto = 3000.0"))
                .body(Matchers.containsString("Salario liquido = 2050.6516"))
                .body(Matchers.containsString("INSS =  854.1484000000002"))
                .body(Matchers.containsString("Imposto de Renda = 95.19999999999999"));
    }

    @Test
    public void validaCpf() {
        String path = "/validarCpf";
        String CPFVALIDO = "84700459468";

        RestAssured.given()
                .spec(requestSpecification)
                .log().all()
                .queryParams("cpf", CPFVALIDO)
                .when()
                .get(path)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString("CPF Valido"));
    }

    @Test
    public void invalidaCpf() {
        String path = "/validarCpf";
        String CPFINVALIDO = "84700459469";

        RestAssured.given()
                .spec(requestSpecification)
                .log().all()
                .queryParams("cpf", CPFINVALIDO)
                .when()
                .get(path)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString("CPF Invalido"));
    }
}