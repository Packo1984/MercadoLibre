package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue={"steps"},
        features = {"src/test/resources/MercadoLibre.feature"},
        plugin= {"html:target/report/cucumber-report.html"}

        )

public class RunCucumberTest {
}
