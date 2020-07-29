package br.com.inmetrics.teste.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import br.com.inmetrics.teste.pages.LoginUsuarioPage;
import br.com.inmetrics.teste.support.YamlHelper;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class LoginUsuarioSteps {
	private WebDriver driver;
	private LoginUsuarioPage loginUsuario;

	@Before(order = 0, value = "@login")
	public void LoginUsuarioStep() {
		driver = YamlHelper.inicio();
		this.loginUsuario = new LoginUsuarioPage(driver);
	}

	@Dado("que acesso a página de login")
	public void que_acesso_a_página_de_login() {
		loginUsuario.validarAcesso();
	}

	@Quando("informo o usuário {string}")
	public void informo_o_usuário(String usuario) {
		loginUsuario.inserirUsuario(usuario);
	}

	@Quando("informo senha {string}")
	public void informo_senha(String senha) {
		loginUsuario.inserirSenha(senha);
		loginUsuario.clicarEntre();
	}

	@Então("devo visualizar lista de funcionários")
	public void devo_visualizar_lista_de_funcionários() {
		loginUsuario.validarLoginSucesso();
	}

	@Então("recebo a mensagem {string}")
	public void recebo_a_mensagem(String msg) {
		loginUsuario.validarMensagem(msg);
	}

	@After(order = 1, value = "@login")
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshot/" + cenario.getName() + ".jpg"));
			driver.quit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After(order = 0, value = "@login")
	public void fecharBrownser() {
		driver.quit();
	}

}
