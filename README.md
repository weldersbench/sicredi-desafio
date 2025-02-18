Tecnologias Utilizadas

- Java 11+
- JUnit 5
- RestAssured
- Allure Reports
- Maven

Como Executar os Testes

1ª Clone o Repositório

it clone https://github.com/seu-usuario/sicredi-desafio.git
cd sicredi-desafio

2ª Instale as Dependencias

mvn clean install

3ª Executar os testes
mvn test

4ª Gerar relatorio Allure

mvn allure:serve

Plano de testes e Estrategia

- Testes de Sucesso: Verificam o comportamento esperado das APIs.
- Testes negativos: Validam respostas para entradas invalidas.
- Testes de Autenticação: Garantem que apenas usuarios autorizados acessam os endpoints protegidos.
- Cobertura de fluxo de exceção: Testa respostas de erro e status HTTP apropriados.


