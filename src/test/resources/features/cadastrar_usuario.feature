#language: pt
@funcionais
@cadastro_usuario
Funcionalidade: Cadastro de usuário

  Cenário: Cadastrar usuário existente
    Dado que acesso a página de cadastro
    Quando informo usuário "amanda123"
    E informo senhas "amanda12"
    Então recebo uma mensagem "Usuário já cadastrado"
