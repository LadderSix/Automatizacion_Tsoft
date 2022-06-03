package SeleniumTsoft.pages;

import SeleniumTsoft.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PcFactoryMonitoresPage_00 extends SeleniumBase {
    public PcFactoryMonitoresPage_00(WebDriver driver){
        super(driver);
    }

    // Repositorio objetos para Pc Factory Monitores Pages

    //private By btnMenuMonitores = By.xpath("//*[@id=\"app\"]/div[3]/div/div[1]/a[13]/div");
    private By btnMenuMonitores = By.xpath("//div[contains(text(),'Monitores y Proyectores')]");
    private By btnSubMenuMonitores = By.xpath("//*[@id=\"submenu-2-menu\"]/div[1]/div/div[4]/a");
    private By btnMenu = By.xpath("//*[@id=\"app\"]/div[2]/div[3]/div[3]/button/i");
    private By btnRangoDePrecio = By.xpath("//*[@id=\"filtros-lista\"]/div[2]/div[1]/label");
    private By rangoPrecioOpcion2 = By.cssSelector("#Rango-de-Precio-3-2");
    private By btnFiltrar = By.cssSelector("#btn_aplicar_filtro_aux");

    public void buscarMonitoresMenoresA200(){
        System.out.println("Presionamos en Menu");
        click(btnMenu);

        System.out.println("Presionamos en Menu --Proyectores--");
        click(btnMenuMonitores);

        System.out.println("Presionamos en Sub Menu --Monitores y Proyectores--");
        click(btnSubMenuMonitores);

        System.out.println("Presionamos en Lista desplegable --Rango de Precio--");
        click(btnRangoDePrecio);

        System.out.println("Seleccionamos Filtro entre --100.000 y 199.999 --");
        click(rangoPrecioOpcion2);

        System.out.println("Presionamos en Boton Filtrar");
        click(btnFiltrar);

        //Validacion de Test


    }
}
