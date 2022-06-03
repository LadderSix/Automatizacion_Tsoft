package TestCases;

import SeleniumTsoft.pages.PcFactoryHomePage_00;
import SeleniumTsoft.pages.PcFactoryMonitoresPage_00;
import SeleniumTsoft.pages.PcFactoryRegistroPage_00;
import org.testng.annotations.Test;

public class TestSuitePcFactory extends TestBase {
    protected PcFactoryHomePage_00 pcHome;
    protected PcFactoryRegistroPage_00 pcRegistro;
    protected PcFactoryMonitoresPage_00 pcMonitores;

    String nombre = "matiasr";
    String rut = "175553878";
    String fono = "946920304";
    String email = "m.rojasarias@outlook.com";
    String direccion = "Americo Vespucio 2102 penalolen";
    String nomDireccion = "casa";
    String contrasena = "@Rojas651";
    String confirmarContrasena = "@Rojas651";


    /*@Test
    public void atc00_example(){
        pcHome = new PcFactoryHomePage(driver);
        pcHome.goToUrl("https://www.pcfactory.cl/");
        pcHome.seccionMiCuenta();
    }*/

    @Test
    public void atc01_RegistrandoUsuario() throws InterruptedException{
        pcHome = new PcFactoryHomePage_00(driver);
        pcHome.goToUrl("https://www.pcfactory.cl/");
        pcRegistro.registroUsuario(nombre,rut,fono,email,direccion,nomDireccion,contrasena,confirmarContrasena);
    }
    /*@Test
    public void atc02_InicioDeSesion() throws InterruptedException{
        pcHome = new PcFactoryHomePage(driver);
        pcHome.goToUrl("https://www.pcfactory.cl/");
        pcHome.inicioDeSesion("175553878","MatiasRojas651!");
    }*/
    /*@Test
    public void atc03_agregarProductorAlCarrito(){
        pcHome = new PcFactoryHomePage_00(driver);
        pcHome.goToUrl("https://www.pcfactory.cl/");
        pcHome.agregaProductosAlCarrito("celulares");
    }*/
    /*@Test
    public void atc04_eliminarProductosCarrito(){
        pcHome = new PcFactoryHomePage_00(driver);
        pcHome.goToUrl("https://www.pcfactory.cl/");
        pcHome.eliminarProductoDeCarrito();
    }*/
    /*@Test
    public void atc05_buscarMonitores(){
        pcHome = new PcFactoryHomePage(driver);
        pcHome.goToUrl("https://www.pcfactory.cl/");
        pcHome.buscarMonitoresMenoresA200();
    }*/

}
