package steps;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageMercadoLibre extends Base {
    private Base base;

    public PageMercadoLibre(WebDriver driver) {
        base=new Base(this.driver);
    }

    public void ingresaUrl() throws InterruptedException {
        String tituloEsperado = "Bienvenidos a MercadoLibre";
        String tituloActual = driver.getTitle();
        System.out.println("Actual: " + tituloActual);
        assertEquals(tituloEsperado, tituloActual);
    }

    By etiquetaPais=By.id("MX");
    public void seleccionarPais() throws InterruptedException{
        Click(etiquetaPais);
    }

    By txtBuscar=By.name("as_word");
    By btnBuscar=By.className("nav-search-btn");
    By etiquetaBusqueda=By.className("ui-search-breadcrumb__title");

    public void consultaProducto(String producto) throws InterruptedException{
        type(producto,txtBuscar);
        Click(btnBuscar);
        String cadenaProducto=producto.toUpperCase().charAt(0) + producto.substring(1, producto.length()).toLowerCase();
        String etiquetaBusquedaActual = ((driver.findElement(etiquetaBusqueda)).getText());
        assertEquals(cadenaProducto, etiquetaBusquedaActual,"Al validar el producto buscado");

    }

    By btnCokies=By.id("cookieDisclaimerButton");

    public void filtro(String condicion, String ubicacion) throws InterruptedException{
        Boolean valor= (driver.findElement(btnCokies)).isDisplayed();
        By linkCondicion=By.xpath("//dt[@class='ui-search-filter-dt-title' and contains(text(), 'Condición')]/../dd/a/span[contains(text(),'"+condicion+"')]");
        By linkUbicacion=By.xpath("//span[@class='ui-search-filter-name' and contains(text(), '"+ubicacion+"')]");
        if(valor.equals(true)) {
            clicleable(btnCokies);
        }

        Click(linkCondicion);
        Click(linkUbicacion);
    }

    By listOrdenar=By.xpath("//div[@class='andes-widther']/div");
    By opcionMayorPrecio=By.xpath("//div[@class='andes-list__item-text' and contains(text(),'Mayor precio')]");
    public void ordenaMayoraMenor(){
        Click(listOrdenar);
        Click(opcionMayorPrecio);
    }


    public  void imprimeProductos(int numProdImprimir){
        for (int i=1;i<=numProdImprimir;i++){
            By listProductos=By.xpath("(//h2[@class='ui-search-item__title'])["+i+"]");
            By listprecios=By.xpath("(//div[@class='ui-search-result__content-columns']/div/div/div/div/span/span[2])["+i+"]");
            System.out.println("Nombre Producto "+i+": "+(driver.findElement(listProductos)).getText());
            System.out.println("Precio Producto "+i+": $"+(driver.findElement(listprecios)).getText()+"\n");

        }
    }

}
