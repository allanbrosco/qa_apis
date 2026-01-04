package api_futebol;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

public class ExemploPetStore {

    @Test
    public void adicionarNovoUsuario() {

        String bodyuser = "[{\n" +
                "    \"id\": 124,\n" +
                "    \"username\": \"allanbrosco\",\n" +
                "    \"firstName\": \"Allan\",\n" +
                "    \"lastName\": \"Brosco\",\n" +
                "    \"email\": \"allanbrosco@hotmail.com\",\n" +
                "    \"password\": \"123456\",\n" +
                "    \"phone\": \"11950885316\",\n" +
                "    \"userStatus\": 1\n" +
                "  }]";

        String url = "https://petstore.swagger.io/v2/user/createWithList";
         RestAssured.given()
                 .log().all()
                 .header("Content-Type",  " application/json")
                 .body(bodyuser)
                 .when()
                 .post(url)
                 .then()
                 .log().all()
                 .assertThat()
                 .statusCode(200);
    }

}
