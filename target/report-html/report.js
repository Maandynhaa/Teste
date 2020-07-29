$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/usuario_api.feature");
formatter.feature({
  "name": "Teste REST api de Usuários",
  "description": "",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "name": "@api"
    }
  ]
});
formatter.scenario({
  "name": "Criar usuário",
  "description": "",
  "keyword": "Cenário",
  "tags": [
    {
      "name": "@api"
    }
  ]
});
formatter.step({
  "name": "defino os parametros POST",
  "keyword": "Dado "
});
formatter.match({
  "location": "UsuariosSteps.defino_os_parametros_POST()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "envio uma solicitacao HTTP POST",
  "keyword": "Quando "
});
formatter.match({
  "location": "UsuariosSteps.envio_uma_solicitacao_HTTP_POST()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "recupero id do empregado",
  "keyword": "Então "
});
formatter.match({
  "location": "UsuariosSteps.recupero_id_do_empregado()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "recebo status 202",
  "keyword": "E "
});
formatter.match({
  "location": "UsuariosSteps.receboStatus(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Listar usuário cadastrado",
  "description": "",
  "keyword": "Cenário",
  "tags": [
    {
      "name": "@api"
    }
  ]
});
formatter.step({
  "name": "faço a autenticação",
  "keyword": "Dado "
});
formatter.match({
  "location": "UsuariosSteps.façoAAutenticação()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "envio a solicitação HTTP GET do usuário cadastrado",
  "keyword": "Quando "
});
formatter.match({
  "location": "UsuariosSteps.envio_a_solicitação_HTTP_GET_do_usuário_cadastrado()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "recebo status 202",
  "keyword": "Então "
});
formatter.match({
  "location": "UsuariosSteps.receboStatus(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "localizo usuário",
  "keyword": "E "
});
formatter.match({
  "location": "UsuariosSteps.localizo_usuário()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Listar todos os usuários",
  "description": "",
  "keyword": "Cenário",
  "tags": [
    {
      "name": "@api"
    }
  ]
});
formatter.step({
  "name": "faço a autenticação",
  "keyword": "Dado "
});
formatter.match({
  "location": "UsuariosSteps.façoAAutenticação()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "envio a solicitação HTTP GET de todos usuários",
  "keyword": "Quando "
});
formatter.match({
  "location": "UsuariosSteps.envio_a_solicitação_HTTP_GET_de_todos_usuários()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "recebo status 200",
  "keyword": "Então "
});
formatter.match({
  "location": "UsuariosSteps.receboStatus(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Alterar usuário cadastrado",
  "description": "",
  "keyword": "Cenário",
  "tags": [
    {
      "name": "@api"
    }
  ]
});
formatter.step({
  "name": "defino os parametros PUT",
  "keyword": "Dado "
});
formatter.match({
  "location": "UsuariosSteps.defino_os_parametros_PUT()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "envio a solicitação HTTP PUT do usuário cadastrado",
  "keyword": "Quando "
});
formatter.match({
  "location": "UsuariosSteps.envio_a_solicitação_HTTP_PUT_do_usuário_cadastrado()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "recebo status 202",
  "keyword": "Então "
});
formatter.match({
  "location": "UsuariosSteps.receboStatus(int)"
});
formatter.result({
  "status": "passed"
});
});