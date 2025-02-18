package br.com.sicredi.tests;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Epic("Testes de API")
@Feature("Ambiente")
public class ApplicationStatusTest {

    @Test
    @Story("Teste de Ambiente")
    @Description("Verificando se o ambiente está ok")
    @Severity(SeverityLevel.CRITICAL)
    public void testStatusApplication() {

        RestAssured.baseURI = "https://dummyjson.com";

        given()
        .when()
                .get("/test")
        .then()
                .log().all()
                .statusCode(200)
                .body("status", is("ok"));
    }
}
