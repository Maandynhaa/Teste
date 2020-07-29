package br.com.inmetrics.teste.runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/features/", 
glue = {"br.com.inmetrics.teste.steps"},
//Para execução de testes funcionais
tags = {"@funcionais"},
//Para execução testes api
//tags = {"@api"},
plugin = {"pretty", "html:target/report-html", "json:target/report.json" },
monochrome = false,
snippets = SnippetType.CAMELCASE,
dryRun = false,
strict = false
)
public class RunCucumberTest {
	
	
}