#language: pt
@funcionais
@funcionario
	Funcionalidade: Funcionario
	-Cadastro de funcionário
	-Atualização de funcionário
	-Remoção de funcionário	
  
  Esquema do Cenário: Cadastrar funcionário
   Dado que acesso a página cadastro de funcionário
   Quando informo os dados <nome>,<cpf>,<sexo>,<admissao>,<cargo>,<salario>,<tipo_contratacao>
   Então recebo mensagem de sucesso <msg>
    
  Exemplos:
  |nome    |cpf             |sexo      |admissao    |cargo							 |salario   |tipo_contratacao|msg                                  |
  |"Amanda"|"114.440.560-26"|"Feminino"|"28/07/2020"|"Analista de Testes"|"1.000,00"|"clt"  				 |"Usuário cadastrado com sucesso"     |
  
 	
 	Esquema do Cenário: Alterar funcionário
   Dado que acesso a página edição de funcionário
   Quando altero o dado <nome>
   Então recebo mensagem de sucesso <msg>
   
  Exemplos:
  |nome    |msg                                  |
  |"Teste" |"Informações atualizadas com sucesso"| 
  
   Esquema do Cenário: Remover funcionário
   Dado que acesso a página de funcionário
   Quando excluo funcionário cadastrado
   Então recebo mensagem de sucesso <msg>
   
  Exemplos:
  |msg                               |
  |"Funcionário removido com sucesso"| 