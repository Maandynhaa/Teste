package br.com.inmetrics.teste.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginUsuarioPage {
	WebDriver driver;

	public LoginUsuarioPage(WebDriver driver) {
		this.driver = driver;
	}

	public void validarAcesso() {
		driver.getPageSource().contains("Login");
	}

	public void inserirUsuario(String usuario) {
		driver.findElement(By.name("username")).sendKeys(usuario);
	}

	public void inserirSenha(String senha) {
		driver.findElement(By.name("pass")).sendKeys(senha);
	}

	public void clicarEntre() {
		driver.findElement(By.className("login100-form-btn")).click();
	}

	public void validarLoginSucesso() {
		boolean validarLogin = driver.findElement(By.id("tabela_wrapper")).isDisplayed();
		assertTrue(validarLogin);
	}

	public void validarMensagem(String msg) {
		boolean validarMsg = driver.getPageSource().contains(msg);
		assertTrue(validarMsg);
	}

}
