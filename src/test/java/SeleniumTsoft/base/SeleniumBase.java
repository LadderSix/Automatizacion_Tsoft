package SeleniumTsoft.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SeleniumBase {
    //atributos
    protected WebDriver driver;

    //Constructor Base
    public SeleniumBase(WebDriver driver){
        this.driver = driver;
    }

    //Envoltorios Wrapper
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements (By locator){
        return driver.findElements(locator);
    }

    public String getText (By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void closeDriver(){
        driver.close();
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public Boolean isSelected(By locator) {
        try {
            return driver.findElement(locator).isSelected();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void goToUrl(String url){
        driver.get(url);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void switchFrameByIndex(int n){
        driver.switchTo().frame(n);
    }

    public String ventanasAbierta(){
        return driver.getWindowHandle();
    }

    public Set<String> ventanasAbiertas(){
        return driver.getWindowHandles();
    }

    public int cantidadVentanas(){
        return driver.getWindowHandles().size();
    }

    public void cambiarVentana(String n){
        driver.switchTo().window(n);
    }

    public void limpiar(By locator){
        driver.findElement(locator).clear();
    }

    public void esperaExplicitaPresencia30s(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void esperaExplicitaElToBeClickleable30s(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void seleccionarByValueListaEstatica(By locator, String value){
        Select s = new Select(driver.findElement(locator));
        s.selectByValue(value);
    }

    // metodos de esperar de forma parametrizadas.
    public void esperaImplicita(int segundos){
        driver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
    }

    public void esperaExplicita(int segundos,By locator){
        WebDriverWait wait = new WebDriverWait(driver, segundos);
        wait.until(ExpectedConditions.elementToBeClickable(locator));

    }
    public void esperaCamuflada(int segundos) throws InterruptedException{
        Thread.sleep(segundos);
    }
    public void apretarTecla(By locator, Keys tecla){
        driver.findElement(locator).sendKeys(tecla);
    }

}
