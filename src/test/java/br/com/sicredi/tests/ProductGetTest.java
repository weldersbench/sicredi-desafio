package br.com.sicredi.tests;

import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Epic("Teste de API")
@Feature("Produto")
public class ProductGetTest {

    private final String BASE_URL = "https://dummyjson.com";
    private final String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJlbWlseXMiLCJlbWFpbCI6ImVtaWx5LmpvaG5zb25AeC5kdW1teWpzb24uY29tIiwiZmlyc3ROYW1lIjoiRW1pbHkiLCJsYXN0TmFtZSI6IkpvaG5zb24iLCJnZW5kZXIiOiJmZW1hbGUiLCJpbWFnZSI6Imh0dHBzOi8vZHVtbXlqc29uLmNvbS9pY29uL2VtaWx5cy8xMjgiLCJpYXQiOjE3Mzk3ODc3MTksImV4cCI6MTczOTc5MTMxOX0.dfJ-2SeSKb0jBjFyNJIh6LzPCi3PsGZckWY6dbNodb8";

    private final int productID = 30;

    @Test
    @Story("Busca produto por autenlticação")
    @Description("Verificar se o usuario precisa estar logado para buscar um produto")
    @Severity(SeverityLevel.CRITICAL)
    public void testeBuscarProdutoPorAuth(){

        given()
                .contentType(ContentType.JSON)
                .header("authorization", "Bearer " + token)
                .when()
                .get(BASE_URL + "/auth/products")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    @Story("Busca produto")
    @Description("Verificar se todos os produto são retornados")
    @Severity(SeverityLevel.CRITICAL)
    public void testBuscarProduto(){

        given().when().get(BASE_URL + "/products")
                .then()
                .log().all()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Story("Busca produto por ID")
    @Description("Verificar se um produto especifico é retornado")
    @Severity(SeverityLevel.CRITICAL)
    public void testBuscarProdutoPorID(){

        given()
                .when()
                .get(BASE_URL + "/products/" + productID)
                .then()
                .log().all()
                .body("title", is("Kiwi"))
                .body("category", is("groceries"))
                .body("price", is(2.49F))
                .body("stock", is(1));

    }
}
