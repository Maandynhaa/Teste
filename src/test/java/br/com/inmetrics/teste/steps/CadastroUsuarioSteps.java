package br.com.inmetrics.teste.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import br.com.inmetrics.teste.pages.CadastroUsuarioPage;
import br.com.inmetrics.teste.support.YamlHelper;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CadastroUsuarioSteps {

	private CadastroUsuarioPage cadUsuario;
	private WebDriver driver;

	@Before(order = 0, value = "@cadastro_usuario")
	public void CadastroUsuario() {
		driver = YamlHelper.inicio();
		this.cadUsuario = new CadastroUsuarioPage(driver);
	}

	@Dado("que acesso a página de cadastro")
	public void que_acesso_a_página_de_cadastro() {
		cadUsuario.selecionarCadastro();
	}

	@Quando("informo usuário {string}")
	public void informo_usuário(String usuario) {
		cadUsuario.inseriUsuario(usuario);
	}

	@Quando("informo senhas {string}")
	public void informo_senhas(String senha) {
		cadUsuario.inseriSenha(senha);
		cadUsuario.inseriSenhaConfirmacao(senha);
		cadUsuario.clicarEntre();
	}

	@Então("recebo uma mensagem {string}")
	public void recebo_uma_mensagem(String msg) {
		cadUsuario.validarMensagem(msg);
	}

	@After(order = 1, value = "@cadastro_usuario")
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshot/" + cenario.getName() + ".jpg"));
			driver.quit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After(order = 0, value = "@cadastro_usuario")
	public void fecharBrownser() {
		driver.quit();
	}

}
