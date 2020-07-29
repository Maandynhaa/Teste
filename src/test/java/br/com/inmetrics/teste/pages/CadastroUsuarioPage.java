package br.com.inmetrics.teste.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroUsuarioPage {
	WebDriver driver;

	public CadastroUsuarioPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selecionarCadastro() {
		driver.findElement(By.linkText("Cadastre-se")).click();
	}

	public void inseriUsuario(String usuario) {
		driver.findElement(By.name("username")).sendKeys(usuario);
	}

	public void inseriSenha(String senha) {
		driver.findElement(By.name("pass")).sendKeys(senha);
	}

	public void inseriSenhaConfirmacao(String senha) {
		driver.findElement(By.name("confirmpass")).sendKeys(senha);
	}

	public void clicarEntre() {
		driver.findElement(By.className("login100-form-btn")).click();
	}

	public void validarMensagem(String msg) {
		boolean validarMsg = driver.getPageSource().contains(msg);
		assertTrue(validarMsg);
	}

}
