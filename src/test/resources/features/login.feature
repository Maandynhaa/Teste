#language: pt
@funcionais
@login
Funcionalidade: Login de usuário
  Realizar login de usário
  

 Cenário: Login com sucesso
    Dado que acesso a página de login
    Quando informo o usuário "amanda_amy12@hotmail.com"
    E informo senha "amanda12"
    Então devo visualizar lista de funcionários
    
  Cenário: Login com dados inválidos
    Dado que acesso a página de login
    Quando informo o usuário "amanda#hotmail.com"
    E informo senha "amanda"
    Então recebo a mensagem "Usuário ou Senha inválidos"
   