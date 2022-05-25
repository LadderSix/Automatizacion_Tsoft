package TestCases;

import SeleniumTsoft.pages.PcFactoryHomePage;
import org.testng.annotations.Test;

public class TestSuite extends TestBase {
    protected PcFactoryHomePage pcHome;
    String nombre = "matiasr";
    String rut = "175553878";
    String fono = "946920304";
    String email = "m.rojasarias@outlook.com";
    String direccion = "Americo Vespucio 2102 penalolen";
    String contrasena = "1234";
    String confirmarContrasena = "1234";


    /*@Test
    public void atc00_example(){
        pcHome = new PcFactoryHomePage(driver);
        pcHome.goToUrl("https://www.pcfactory.cl/");
        pcHome.seccionMiCuenta();
    }*/

    @Test
    public void atc01_RegistrandoUsuario(){
        pcHome = new PcFactoryHomePage(driver);
        pcHome.goToUrl("https://www.pcfactory.cl/");
        pcHome.registroUsuario(nombre,rut,fono,email,direccion,contrasena,confirmarContrasena);
    }
    @Test
    public void atc02_InicioDeSesion(){
        pcHome = new PcFactoryHomePage(driver);
        pcHome.goToUrl("https://www.pcfactory.cl/");
        pcHome.inicioDeSesion("175553878","MatiasRojas651!");
    }
    @Test
    public void atc03_agregarProductorAlCarrito(){
        pcHome = new PcFactoryHomePage(driver);
        pcHome.goToUrl("https://www.pcfactory.cl/");
        pcHome.agregaProductosAlCarrito("celulares");
    }
    @Test
    public void atc04_eliminarProductosCarrito(){
        pcHome = new PcFactoryHomePage(driver);
        pcHome.goToUrl("https://www.pcfactory.cl/");
        pcHome.eliminarProductoDeCarrito();
    }

}
