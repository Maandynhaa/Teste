package br.com.inmetrics.teste.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import br.com.inmetrics.teste.pages.FuncionarioPage;
import br.com.inmetrics.teste.support.YamlHelper;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class FuncionarioSteps {
	private WebDriver driver;
	private FuncionarioPage funcionario;

	@Before(order = 0, value = "@funcionario")
	public void inicio() {
		driver = YamlHelper.inicio();
		this.funcionario = new FuncionarioPage(driver);
	}

	@Dado("que acesso a página cadastro de funcionário")
	public void que_acesso_a_página_cadastro_de_funcionário() {
		funcionario.inserirUsuario("amanda123");
		funcionario.inserirSenha("amanda12");
		funcionario.clicarEntre();
		funcionario.selecionarCadastroFuncionário();
	}

	@Quando("informo os dados {string},{string},{string},{string},{string},{string},{string}")
	public void informo_os_dados(String nome, String cpf, String sexo, String admissao, String cargo, String salario,
			String tipoContratacao) {
		funcionario.inserirNomeFunc(nome);
		funcionario.inserirCpf(cpf);
		funcionario.selecionarSexo(sexo);
		funcionario.inserirDataAdmissao(admissao);
		funcionario.inserirCargo(cargo);
		funcionario.inserirSalario(salario);
		funcionario.clicarTipoContratacao(tipoContratacao);
		funcionario.clicarCadastrar();
	}

	@Então("recebo mensagem de sucesso {string}")
	public void recebo_mensagem_de_sucesso(String msg) {
		funcionario.validarMensagem(msg);
	}

	@Dado("que acesso a página edição de funcionário")
	public void que_acesso_a_página_edição_de_funcionário() {
		funcionario.inserirUsuario("amanda123");
		funcionario.inserirSenha("amanda12");
		funcionario.clicarEntre();
		funcionario.clicarEditar();
	}

	@Quando("altero o dado {string}")
	public void altero_o_dado(String nome) {
		funcionario.limparNomeFunc();
		funcionario.inserirNomeFunc(nome);
		funcionario.clicarCadastrar();
	}

	@Dado("que acesso a página de funcionário")
	public void que_acesso_a_página_de_funcionário() {
		funcionario.inserirUsuario("amanda123");
		funcionario.inserirSenha("amanda12");
		funcionario.clicarEntre();
	}

	@Quando("excluo funcionário cadastrado")
	public void excluo_funcionário_cadastrado() {
		funcionario.clicarExcluirFunc();
	}

	@After(order = 1, value = "@funcionario")
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshot/" + cenario.getName() + ".jpg"));
			driver.quit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After(order = 0, value = "@funcionario")
	public void fecharBrownser() {
		driver.quit();
	}

}
