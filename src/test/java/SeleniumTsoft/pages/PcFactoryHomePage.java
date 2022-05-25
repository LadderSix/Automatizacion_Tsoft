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

    // Barra de busqueda
    private By buscar = By.xpath("//input[@placeholder=\"Buscar aquí...\"]");
    //private By btnBuscar = By.xpath("//button[contains(text(),'search')]");
    private By btnBuscar = By.xpath("//*[@id=\"searchalgolia\"]/div/div/div/div/div/form/div/button");

    // Productos Celulares
    private By prodID45828 = By.cssSelector("#addtocart_45828_1");
    private By prodID45933 = By.cssSelector("#addtocart_45933_1");

    // Carrito de compras
    private By irAlCarrito = By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[3]/div/div[2]/button/span[1]");
    private By btnVerCarrito = By.xpath("//*[@id=\"contenido_popup_add_to_card\"]/div[2]/div[2]/a[2]");
    //private By precioTotalCompra = By.xpath("//*[@id=\"app\"]/div[5]/div/div[2]/div/section[2]/div/ul/li[2]/div[2]/div[2]/p");
    private By precioTotalCompra = By.xpath("//p[contains(text(), '$')]");
    private By totalProductos = By.xpath("//*[@id=\"app\"]/div[5]/div/div[2]/div/section[1]/div[1]/div[1]/p");
    private By totalProductosCarro = By.cssSelector("#cantidad_productos");
    private By btnEliminarDelCarro = By.cssSelector("#btndeletetocart_45828_1");
    private By irAMiCarro = By.cssSelector("#ir_a_mi_carro");
    private By cerrarVentanaCarrito = By.xpath("//*[@id=\"contenido_popup_add_to_card\"]/div[1]/button");

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
    private By btnMiCuenta = By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[3]/div/div[1]/div[2]/button");
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
            Assert.assertEquals(getText(miCuenta),"Mi cuenta");
            System.out.println("atc00 - Passed");
        }else{
            System.out.println("atc00 - Passed");
        }
    }

    public void registroUsuario(String nombre,String rut,String fono,String email,String direccion,String pass,String checkPass){
        //ingresamos a seccion mi cuenta
        System.out.println("Desplegamos seccion --Mi cuenta--");
        click(miCuenta);
        //ingresamos a seccion registro
        System.out.println("Presionamos en opcion --¿No tienes cuenta? Registrate--");
        click(btnRegistro);

        System.out.println("Ingresando Rut");
        type(rut,rutCliente);

        System.out.println("Ingresando Nombre");
        type(nombre,nombreCliente);

        System.out.println("Ingresando Telefono");
        type(fono,telefonoCliente);

        System.out.println("Ingresando Correo");
        type(email,correoCliente);

        System.out.println("Ingresando Direccion");
        type(direccion,direccionCliente);
        apretarTecla(direccionCliente,Keys.ARROW_DOWN);

        System.out.println("Ingresando Contraseña");
        type(pass,contrasenaCliente);

        System.out.println("Ingresando Confirmacion de contraseña");
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
        type(rut,rutInicio);

        System.out.println("Ingresamos Contrasena");
        type(password,passwordInicio);

        System.out.println("Damos Click en Iniciar Sesion");
        click(btnIniciarSesion);

        System.out.println("Presionamos en --Mi cuenta--");
        click(btnMiCuenta);

        System.out.println(getText(seccionMiCuenta));

        //Validacion de Test
        String miNombre = "Matias Rojas Arias";

        if (isDisplayed(btnMiCuenta)){
            Assert.assertEquals(getText(seccionMiCuenta),miNombre);
            System.out.println("atc02 - Passed");
        }else{
            System.out.println("atc02 - Error!");
        }

    }

    public void agregaProductosAlCarrito(String descripcion){
        System.out.println("Presionamos en Barra Buscadora");
        click(buscar);

        System.out.println("Ingresamos Producto a Buscar");
        type(descripcion,buscar);

        System.out.println("Presionamos en boton de busqueda");
        click(btnBuscar);

        System.out.println("Agregamos producto al carrito");
        click(prodID45828);

        System.out.println("Cerramos Ventana");
        click(cerrarVentanaCarrito);

        //Validacion de Test
        System.out.println("Vamos al carrito");
        click(irAlCarrito);

        String carritoVacio = "0 Productos";
        if (isDisplayed(irAlCarrito)){
            Assert.assertNotEquals(getText(totalProductosCarro), carritoVacio);
            System.out.println("atc03 passed!");

        }else{
            System.out.println("atc03 failed!");
        }

    }
    public void eliminarProductoDeCarrito(){
        System.out.println("Vamos al carrito");
        click(irAlCarrito);
        esperaExplicita(30,btnEliminarDelCarro);

        System.out.println("Eliminado producto del carrito");
        click(btnEliminarDelCarro);

        //Validation de test
        String carritoVacio2 = "0 Productos";

        if(isDisplayed(irAlCarrito)){
            Assert.assertEquals(getText(totalProductosCarro), carritoVacio2);
            System.out.println("ac04 passed!");
        }else{
            System.out.println("ac04 failed!");
        }
    }


}
