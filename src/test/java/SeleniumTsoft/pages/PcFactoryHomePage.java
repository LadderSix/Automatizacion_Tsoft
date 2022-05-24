package SeleniumTsoft.pages;

import SeleniumTsoft.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class PcFactoryHomePage extends SeleniumBase {
    public PcFactoryHomePage(WebDriver driver){
        super(driver);
    }

    // Repositorio objetos para Home Pc Factory
    // Pagina Principal
    private By miCuenta = By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[3]/div/div[1]/div[2]/button/div/span");
    private By btnRegistro = By.xpath("//a[@href=\"/registro\"]");

    //Barra de busqueda
    private By buscar = By.xpath("//input[@placeholder=\"Buscar aquí...\"]");
    //private By btnBuscar = By.xpath("//button[contains(text(),'search')]");
    private By btnBuscar = By.xpath("//*[@id=\"searchalgolia\"]/div/div/div/div/div/form/div/button");
    private By prodID45828 = By.cssSelector("#addtocart_45828_1");


    // Sección de registro
    private By rutCliente = By.cssSelector("#id_rut_man_cliente");
    private By nombreCliente = By.cssSelector("#id_nombre_man_cliente");
    private By telefonoCliente = By.cssSelector("#phone");
    private By correoCliente = By.cssSelector("#id_email_man_cliente");
    private By direccionCliente = By.cssSelector("#autocomplete");
    private By contrasenaCliente = By.cssSelector("#id_clave_man_cliente");
    private By confirmarCotrasenaCliente = By.cssSelector("#id_reingrese_man_cliente");
    private By btnGuardarRegistro = By.cssSelector("#btn_guardar_cliente");

    // Seccion de inicio de sesión
    private By rutInicio = By.cssSelector("#rutId1_uno");
    private By passwordInicio = By.cssSelector("#rutId2_uno");
    private By btnIniciarSesion = By.cssSelector("#btn_login_uno");
    private By seccionMiCuenta = By.xpath("//*[@id=\"loginOn\"]/div/div/div/span");
    private By linkEditarPerfil = By.xpath("//a[@href=\"/misdatos\"]");
    private By misDatos = By.xpath("//*[@id=\"mis_datos\"]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/p");

    // Metodos
    public void seccionMiCuenta(){
        //ingresamos a seccion mi cuenta
        System.out.println("Desplegamos seccion --Mi cuenta--"+ getText(miCuenta));
        click(miCuenta);

        //Validacion de Test

        if (isDisplayed(miCuenta)){
            Assert.assertEquals("Mi cuenta",getText(miCuenta));
            System.out.println("atc00 - Passed");
        }else{
            System.out.println("atc00 - Passed");
        }
    }

    public void registroUsuario(String nombre,String rut,String fono,String email,String direccion,String pass,String checkPass){
        //ingresamos a seccion mi cuenta
        System.out.println("Desplegamos seccion --Mi cuenta--"+ getText(miCuenta));
        click(miCuenta);
        esperaExplicita(30,miCuenta);

        //ingresamos a seccion registro
        System.out.println("Presionamos en opcion --¿No tienes cuenta? Registrate--");
        click(btnRegistro);
        esperaExplicita(30,btnRegistro);

        System.out.println("Ingresando Rut");
        esperaExplicita(30,rutCliente);
        type(rut,rutCliente);

        System.out.println("Ingresando Nombre");
        esperaExplicita(30,nombreCliente);
        type(nombre,nombreCliente);

        System.out.println("Ingresando Telefono");
        esperaExplicita(30,telefonoCliente);
        type(fono,telefonoCliente);

        System.out.println("Ingresando Correo");
        esperaExplicita(30,correoCliente);
        type(email,correoCliente);

        System.out.println("Ingresando Direccion");
        type(direccion,direccionCliente);
        esperaExplicita(30,direccionCliente);
        apretarTecla(direccionCliente,Keys.ARROW_DOWN);
        esperaExplicita(30,direccionCliente);

        System.out.println("Ingresando Contraseña");
        esperaExplicita(60,contrasenaCliente);
        type(pass,contrasenaCliente);

        System.out.println("Ingresando Confirmacion de contraseña");
        esperaExplicita(30,confirmarCotrasenaCliente);
        type(checkPass,confirmarCotrasenaCliente);

        System.out.println("Presionamos en boton --Guardar--");
        click(btnGuardarRegistro);

        /*//Validacion de Test

        if (isDisplayed()){
            Assert.assertEquals(,);
            System.out.println("atc01 - Passed");
        }else{
            System.out.println("atc01 - Error!");
        }*/

    }

    public void inicioDeSesion(String rut,String password){
        esperaExplicita(30,miCuenta);
        click(miCuenta);

        System.out.println("Ingresamos RUT");
        esperaExplicita(30,rutInicio);
        type(rut,rutInicio);

        System.out.println("Ingresamos Contrasena");
        esperaExplicita(30,passwordInicio);
        type(password,passwordInicio);

        System.out.println("Damos Click en Iniciar Sesion");
        click(btnIniciarSesion);

        /*System.out.println("Presionamos en --Mi cuenta--");
        click(seccionMiCuenta);

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        System.out.println("Presionamos en link --Editar Perfil--");
        click(linkEditarPerfil);

        //Validacion de Test

        if (isDisplayed(misDatos)){
            Assert.assertEquals("Matias Rojas Arias",getText(misDatos));
            System.out.println("atc02 - Passed");
        }else{
            System.out.println("atc02 - Error!");
        }*/

    }

    public void agregaProductosAlCarrito(String descripcion){
        System.out.println("Presionamos en Barra Buscadora");
        click(buscar);

        System.out.println("Ingresamos Producto a Buscar");
        esperaExplicita(30,buscar);
        type(descripcion,buscar);

        System.out.println("Presionamos en boton de busqueda");
        click(btnBuscar);
        esperaExplicita(45,btnBuscar);

        System.out.println("Agregamos producto al carrito");
        esperaExplicita(30,prodID45828);
        click(prodID45828);

        //Validacion de Test

    }


}
