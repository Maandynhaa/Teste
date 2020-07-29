#language: pt
@api   
Funcionalidade: Teste REST api de Usuários 

 Cenário: Criar usuário
   	Dado defino os parametros POST
    Quando envio uma solicitacao HTTP POST
    Então recupero id do empregado
    E recebo status 202
 
  Cenário: Listar usuário cadastrado
    Dado faço a autenticação
    Quando envio a solicitação HTTP GET do usuário cadastrado
    Então recebo status 202
    E localizo usuário 
   
  Cenário: Listar todos os usuários
    Dado faço a autenticação
    Quando envio a solicitação HTTP GET de todos usuários
    Então recebo status 200
   
  Cenário: Alterar usuário cadastrado
    Dado defino os parametros PUT
    Quando envio a solicitação HTTP PUT do usuário cadastrado
    Então recebo status 202
