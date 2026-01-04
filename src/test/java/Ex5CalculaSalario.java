import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class Ex5CalculaSalario {

    @Test
    public void calculasalario(){

        String pathParamSalario = "3000";
        String url = "http://localhost:8080/exercicios/calculaSalario/"+pathParamSalario;

        RestAssured.given()
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString("Salario bruto = 3000.0"))
                .body(Matchers.containsString("Salario liquido = 2050.6516"))
                .body(Matchers.containsString("INSS =  854.1484000000002"))
                .body(Matchers.containsString("Imposto de Renda = 95.19999999999999"));


    }
}
