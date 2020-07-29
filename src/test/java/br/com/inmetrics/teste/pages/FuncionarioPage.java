package br.com.inmetrics.teste.pages;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;

public class FuncionarioPage {
	WebDriver driver;

	public FuncionarioPage(WebDriver driver) {
		this.driver = driver;
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

	public void selecionarCadastroFuncionário() {
		driver.findElement(By.xpath("//a[@href='/empregados/new_empregado']")).click();
	}

	public void inserirNomeFunc(String nome) {
		driver.findElement(By.id("inputNome")).sendKeys(nome);
	}

	public void limparNomeFunc() {
		driver.findElement(By.id("inputNome")).clear();
	}

	public void inserirCpf(String cpf) {
		driver.findElement(By.id("cpf")).sendKeys(cpf);
	}

	public void selecionarSexo(String sexo) {
		Select selecionarSexo = new Select(driver.findElement(By.id("slctSexo")));
		selecionarSexo.selectByVisibleText(sexo);
	}

	public void inserirDataAdmissao(String admissao) {
		driver.findElement(By.id("inputAdmissao")).sendKeys(admissao);
	}

	public void inserirCargo(String cargo) {
		driver.findElement(By.id("inputCargo")).sendKeys(cargo);
	}

	public void inserirSalario(String salario) {
		driver.findElement(By.id("dinheiro")).sendKeys(salario);
	}

	public void clicarTipoContratacao(String tipoContratacao) {
		driver.findElement(By.id(tipoContratacao)).click();

	}

	public void clicarCadastrar() {
		driver.findElement(By.className("cadastrar-form-btn")).click();

	}

	public void validarMensagem(String msg) {
		boolean validarMsg = driver.getPageSource().contains(msg);
		assertTrue(validarMsg);
	}

	public void clicarEditar() {
		driver.findElement(By.className("fa-pencil")).click();
	}

	public void clicarExcluirFunc() {
		driver.findElement(By.id("delete-btn")).click();
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
