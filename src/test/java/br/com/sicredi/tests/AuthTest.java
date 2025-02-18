package br.com.sicredi.tests;

import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Epic("Teste de API")
@Feature("Autenticação")
public class AuthTest {

    private final String BASE_URL = "https://dummyjson.com";

    @Test
    @Story("Login com credenciais corretas")
    @Description("Verificar se o login funciona com usuario e senha validos")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginComSucesso(){
        given()
                .contentType(ContentType.JSON)
                .body("{\"username\": \"emilys\", \"password\": \"emilyspass\"}")
        .when()
                .post(BASE_URL + "/auth/login")
        .then()
                .log().all()
                .body("id", is(1))
                .body("username", is("emilys"))
                .body("email", is("emily.johnson@x.dummyjson.com"))
                .extract()
                .path("token");

    }

    @Test
    @Story("Login com credenciais incorretas")
    @Description("Verificar se o login não funciona com usuario e senha invalidos")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginComCredenciaisInvalidas(){

        given()
                .contentType(ContentType.JSON)
                .body("{ \"username\": \"emilys\", \"password\": \"senhaErrada\" }")
                .when()
                .post(BASE_URL + "/auth/login")
                .then()
                .body("message", is("Invalid credentials"))
                .statusCode(400);
    }
}
