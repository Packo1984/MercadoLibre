    package steps;

    import io.cucumber.java.Before;
    import io.cucumber.java.en.And;
    import io.cucumber.java.en.Given;
    import io.cucumber.java.en.Then;
    import io.cucumber.java.en.When;
    import org.openqa.selenium.WebDriver;

    import java.io.IOException;

    public class StepsMercadoLibre {
        private WebDriver driver;
        PageMercadoLibre pageMercadoLibre;


        @Before()
        public void setup() {
            pageMercadoLibre =new PageMercadoLibre(driver);
            driver= pageMercadoLibre.chromeDriverConetion();
            pageMercadoLibre.visit("https://www.mercadolibre.com  ");
            driver.manage().window().maximize();
        }

        @Given("Ingresar a la pagina de Mercado Libre satisfactoriamente")
        public void ingresaSatisfactoriamente() throws InterruptedException {
           pageMercadoLibre.ingresaUrl();

        }

        @When("^Seleccionar país México")
        public void escogerPais() throws IOException, InterruptedException {
            pageMercadoLibre.seleccionarPais();
        }

        @And("^Buscar producto \"(.*)\"$")
        public void buscarProducto(String producto) throws IOException, InterruptedException {
            pageMercadoLibre.consultaProducto(producto);
        }

        @And("^filtrar por condición \"(.*)\" y ubicación \"(.*)\"$")
        public void filtroCondicionUbicacion(String condicion, String ubicacion) throws IOException, InterruptedException {
            pageMercadoLibre.filtro(condicion,ubicacion);
        }

        @And("Ordenar de Mayor a Menor precio")
        public void Ordenar(){
            pageMercadoLibre.ordenaMayoraMenor();
        }

        @Then("^imprimir productos \"(.*)\"")
        public void obtieneProductos(int numProdImprimir) {
            pageMercadoLibre.imprimeProductos(numProdImprimir);
        }

    }
