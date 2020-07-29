package br.com.inmetrics.teste.steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UsuariosSteps {
	private RequestSpecification request;
	private Response response;
	private ValidatableResponse json;
	public static final String URI = "https://inm-api-test.herokuapp.com/empregado";
	public static final ContentType CONTENT_TYPE = ContentType.JSON;
	private static int CREATED_ID;

	@Dado("faço a autenticação")
	public void façoAAutenticação() {
		request = given().log().all().auth().basic("inmetrics", "automacao");
	}

	@Dado("defino os parametros POST")
	public void defino_os_parametros_POST() {
		String body_func = "{\"admissao\": \"28/07/2020\",\"cargo\": \"Analista de testes API\",\"comissao\": \"500,00\",\"cpf\": \"977.958.720-93\",\"departamentoId\": 1,\"nome\": \"Amanda Teste API\",\"salario\": \"1.000,00\",\"sexo\": \"f\",\"tipoContratacao\": \"clt\"}";
		request = given().log().all().auth().basic("inmetrics", "automacao").contentType(CONTENT_TYPE).body(body_func);
	}

	@Quando("envio uma solicitacao HTTP POST")
	public void envio_uma_solicitacao_HTTP_POST() {
		response = request.when().post(URI + "/cadastrar");
	}

	@Então("recupero id do empregado")
	public void recupero_id_do_empregado() {
		CREATED_ID = response.then().extract().jsonPath().getInt("empregadoId");
	}

	@Quando("envio a solicitação HTTP GET do usuário cadastrado")
	public void envio_a_solicitação_HTTP_GET_do_usuário_cadastrado() {
		response = request.when().get(URI + "/list/" + CREATED_ID);
	}

	@Quando("envio a solicitação HTTP GET de todos usuários")
	public void envio_a_solicitação_HTTP_GET_de_todos_usuários() {
		response = request.when().get(URI + "/list_all/");
	}

	@Então("recebo status {int}")
	public void receboStatus(int status) {
		json = response.then().log().all().statusCode(status);
	}

	@Então("localizo usuário")
	public void localizo_usuário() {
		json = response.then().body("empregadoId", equalTo(CREATED_ID));
	}

	@Dado("defino os parametros PUT")
	public void defino_os_parametros_PUT() {
		String body_func = "{\"admissao\": \"28/07/2020\",\"cargo\": \"Alteração\",\"comissao\": \"500,00\",\"cpf\": \"977.958.720-93\",\"departamentoId\": 1,\"nome\": \"Amanda API Alteração\",\"salario\": \"1.000,00\",\"sexo\": \"f\",\"tipoContratacao\": \"clt\"}";
		request = given().log().all().auth().basic("inmetrics", "automacao").contentType(CONTENT_TYPE).body(body_func);
	}

	@Quando("envio a solicitação HTTP PUT do usuário cadastrado")
	public void envio_a_solicitação_HTTP_PUT_do_usuário_cadastrado() {
		response = request.when().put(URI + "/alterar/" + CREATED_ID);
	}

}
