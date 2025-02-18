package br.com.sicredi.tests;

import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@Epic("Teste de API")
@Feature("Produto")
public class ProductTest {

    private final String BASE_URL = "https://dummyjson.com";
    private final String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJlbWlseXMiLCJlbWFpbCI6ImVtaWx5LmpvaG5zb25AeC5kdW1teWpzb24uY29tIiwiZmlyc3ROYW1lIjoiRW1pbHkiLCJsYXN0TmFtZSI6IkpvaG5zb24iLCJnZW5kZXIiOiJmZW1hbGUiLCJpbWFnZSI6Imh0dHBzOi8vZHVtbXlqc29uLmNvbS9pY29uL2VtaWx5cy8xMjgiLCJpYXQiOjE3Mzk3ODc3MTksImV4cCI6MTczOTc5MTMxOX0.dfJ-2SeSKb0jBjFyNJIh6LzPCi3PsGZckWY6dbNodb8";

    @Test
    @Story("Cadastrar Produto")
    @Description("Verificar se é cadastrado um novo produto corretamente")
    @Severity(SeverityLevel.CRITICAL)
    public void testAddProduto(){

        given()
                .contentType(ContentType.JSON)
                .body("{ \"title\": \"Perfume Oil\", " +
                        "\"description\": \"Mega Discount, Impression of A...\", " +
                        "\"price\": \"13\", \"discountPercentage\": \"8.4\", \"rating\": \"4.26\", " +
                        "\"stock\": \"65\", \"brand\": \"Impression of Acqua Di Gio\", \"category\": \"fragrances\", " +
                        "\"thumbnail\": \"https://i.dummyjson.com/data/products/11/thumnail.jpg\"}")
        .when()
                .post(BASE_URL + "/products/add")
        .then()
                .log().all()
                .statusCode(201)
                .body("id", notNullValue())
                .body("title", is("Perfume Oil"));

    }
}
