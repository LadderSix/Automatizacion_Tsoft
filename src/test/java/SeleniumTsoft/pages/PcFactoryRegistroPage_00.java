package SeleniumTsoft.pages;

import SeleniumTsoft.base.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PcFactoryRegistroPage_00 extends SeleniumBase {
    public PcFactoryRegistroPage_00(WebDriver driver){
        super(driver);
    }
    // Repositorio objetos para Home Pc Factory
    // Pagina Principal
    private By miCuenta = By.xpath("//*[@id=\"app\"]/div[1]/div[6]/div[3]/div/div[1]/div[2]/button/div/span");
    private By btnRegistro = By.xpath("//a[@href=\"/registro\"]");

    // Sección de registro
    private By rutCliente = By.cssSelector("#id_rut_man_cliente");
    private By nombreCliente = By.cssSelector("#id_nombre_man_cliente");
    private By telefonoCliente = By.cssSelector("#phone");
    private By correoCliente = By.cssSelector("#id_email_man_cliente");
    private By direccionCliente = By.cssSelector("#autocomplete");
    private By aliasDireccion = By.cssSelector("#nombre_direccion");
    private By contrasenaCliente = By.cssSelector("#id_clave_man_cliente");
    private By confirmarCotrasenaCliente = By.cssSelector("#id_reingrese_man_cliente");
    private By btnGuardarRegistro = By.cssSelector("#btn_guardar_cliente");

    public void registroUsuario(String nombre,String rut,String fono,String email,String direccion,String nomDireccion,String pass,String checkPass) throws InterruptedException{
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
        esperaCamuflada(1000);
        apretarTecla(direccionCliente, Keys.ARROW_DOWN);
        apretarTecla(direccionCliente,Keys.ENTER);

        System.out.println("Ingresando nombre de direccion");
        type(nomDireccion,aliasDireccion);
        esperaCamuflada(1000);

        System.out.println("Ingresando Contraseña");
        type(pass,contrasenaCliente);
        esperaCamuflada(1000);

        System.out.println("Ingresando Confirmacion de contraseña");
        type(checkPass,confirmarCotrasenaCliente);
        esperaCamuflada(1000);

        System.out.println("Presionamos en boton --Guardar--");
        //click(btnGuardarRegistro);
    }

}
