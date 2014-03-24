package com.lazerycode.selenium.Tests;

import com.lazerycode.selenium.ScreenshotListener;
import com.lazerycode.selenium.SeleniumBase;
import com.sun.jna.platform.win32.Sspi;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Listeners(ScreenshotListener.class)
public class Selenium2ExampleST extends SeleniumBase {
    
  public static WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        this.driver = getDriver();
    }

       public void TypeformLogin(String Username, String Password) {
        // login into Typeform properly
        WebDriver driver = this.driver;

        // And now use this to visit Typeform
        driver.get("https://login.typeform.com/en");


        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("_username"));

        // Enter something
        element.clear();
        element.sendKeys(Username);

        // Find the text input element by its name
        WebElement element2 = driver.findElement(By.name("_password"));

        // Enter something
        element2.clear();
        element2.sendKeys(Password);

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is first: " + driver.getTitle());
    }

    public void CreateNewTypeform(String Titulo) {

    //función para crear un nuevo Typeform

       WebDriver driver = this.driver;

        driver.findElement(By.xpath("//*[@id=\'forms\']/li[1]")).click();

        WebElement element1 = driver.findElement(By.xpath("//*[@id='quickyform_name']"));
        element1.clear();
        element1.sendKeys(Titulo);

        //Gestión de selectores del Pop-Up
        driver.findElement(By.xpath("//*[@id=\"s2id_quickyform_language\"]/a/div/b")).click();
        driver.findElement(By.xpath("/html/body/div[5]/ul/li[1]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"s2id_quickyform_category\"]/a/div/b")).click();
        driver.findElement(By.xpath("/html/body/div[5]/ul/li[1]/div")).click();
        driver.findElement(By.xpath("//*[@id=\'add-form\']/form/div[4]/input")).click();
    }

    public void deleteFirstForm() {
        driver.findElement(By.xpath("//*[@id='forms']/li[2]/ul/li[4]/a")).click();
        driver.findElement(By.xpath("//*[@id='dialog-ok']")).click();

    }

    public void AddWelcome() {

        //Añade welcome screen
        WebDriver driver = this.driver;

        driver.findElement(By.xpath("//*[@id=\'sidebar\']/div[1]/div/ul[1]/li[1]/span")).click();

        WebElement iframe = driver.findElement(By.cssSelector("#popup > iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@id=\'submit\']/span")).click();
        //Sale del Iframe
        driver.switchTo().window(driver.getWindowHandle());
    }

    public void AddThankyou(){


        //Añade thank you screen
        WebDriver driver = this.driver;

        driver.findElement(By.linkText ("+ Add Questions")).click();

        driver.findElement(By.xpath("//*[@id=\'sidebar\']/div[1]/div/ul[1]/li[2]/span")).click();

        WebElement iframe = driver.findElement(By.cssSelector("#popup > iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[@id='submit']/span")).click();
        //Sale del Iframe
        driver.switchTo().window(driver.getWindowHandle());

    }

    public void ShortText(){

        WebDriver driver = this.driver;

        WebElement element = driver.findElement(By.xpath("//*[@id=\'sidebar\']/div[1]/div/ul[2]/li[1]/span"));
        element.click();

        WebElement iframe = driver.findElement(By.cssSelector("#popup > iframe"));
        driver.switchTo().frame(iframe);

        //utilizamos función javascript para rellenar el IFRAME
        super.javascriptExecute("$('#textfield_question').val('This is a short text')",driver);

        driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id='submit']/span")).click();

        driver.switchTo().window(driver.getWindowHandle());
        driver.findElement(By.xpath("//*[@id=\'header\']/div[2]/ul/li[1]/a")).click();

    }

    public void LongText(){

        WebDriver driver = this.driver;

        driver.findElement(By.xpath("//*[@id=\'sidebar\']/div[1]/div/ul[2]/li[3]/span")).click();

        WebElement iframe = driver.findElement(By.cssSelector("#popup > iframe"));
        driver.switchTo().frame(iframe);

        //utilizamos función javascript para rellenar el IFRAME
        super.javascriptExecute("$('#textareafield_question').val('This isa long text with a lot of words!! You can put it more if you want')",driver);

        driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id='submit']/span")).click();

        driver.switchTo().window(driver.getWindowHandle());
        driver.findElement(By.xpath("//*[@id=\'header\']/div[2]/ul/li[1]/a")).click();

    }

    public void Statement(){

        WebDriver driver = this.driver;

        driver.findElement(By.xpath("//*[@id=\'sidebar\']/div[1]/div/ul[2]/li[5]/span")).click();

        WebElement iframe = driver.findElement(By.cssSelector("#popup > iframe"));
        driver.switchTo().frame(iframe);

        //utilizamos función javascript para rellenar el IFRAME
        super.javascriptExecute("$('#statement_content').val('This is a statement!!')",driver);

        driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id='submit']/span")).click();

        driver.switchTo().window(driver.getWindowHandle());
        driver.findElement(By.xpath("//*[@id=\'header\']/div[2]/ul/li[1]/a")).click();

    }

    public void Email(){

        WebDriver driver = this.driver;

        driver.findElement(By.xpath("//*[@id=\'sidebar\']/div[1]/div/ul[2]/li[9]/span")).click();

        WebElement iframe = driver.findElement(By.cssSelector("#popup > iframe"));
        driver.switchTo().frame(iframe);

        //utilizamos función javascript para rellenar el IFRAME
        super.javascriptExecute("$('#email_question').val('This is a email question!!')",driver);

        driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id='submit']/span")).click();

        driver.switchTo().window(driver.getWindowHandle());
        driver.findElement(By.xpath("//*[@id=\'header\']/div[2]/ul/li[1]/a")).click();

    }

    public void Number(){

        WebDriver driver = this.driver;

        driver.findElement(By.xpath("//*[@id=\'sidebar\']/div[1]/div/ul[2]/li[13]/span")).click();

        WebElement iframe = driver.findElement(By.cssSelector("#popup > iframe"));
        driver.switchTo().frame(iframe);

        //utilizamos función javascript para rellenar el IFRAME
        super.javascriptExecute("$('#number_question').val('This is a number question!!')",driver);

        driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id='submit']/span")).click();

        driver.switchTo().window(driver.getWindowHandle());
        driver.findElement(By.xpath("//*[@id=\'header\']/div[2]/ul/li[1]/a")).click();

    }

    public void Website(){

        WebDriver driver = this.driver;

        driver.findElement(By.xpath("//*[@id=\'sidebar\']/div[1]/div/ul[2]/li[14]/span")).click();

        WebElement iframe = driver.findElement(By.cssSelector("#popup > iframe"));
        driver.switchTo().frame(iframe);

        //utilizamos función javascript para rellenar el IFRAME
        super.javascriptExecute("$('#website_question').val('This is a website question!!')",driver);

        driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id='submit']/span")).click();

        driver.switchTo().window(driver.getWindowHandle());
        driver.findElement(By.xpath("//*[@id=\'header\']/div[2]/ul/li[1]/a")).click();

    }
    public void Rating(){

        WebDriver driver = this.driver;

        driver.findElement(By.xpath("//*[@id=\'sidebar\']/div[1]/div/ul[2]/li[10]/span")).click();

        WebElement iframe = driver.findElement(By.cssSelector("#popup > iframe"));
        driver.switchTo().frame(iframe);

        //utilizamos función javascript para rellenar el IFRAME
        super.javascriptExecute("$('#rating_question').val('This is a rating question!!')",driver);

        driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id='submit']/span")).click();

        driver.switchTo().window(driver.getWindowHandle());
        driver.findElement(By.xpath("//*[@id=\'header\']/div[2]/ul/li[1]/a")).click();

    }

    public void YesNo(){

        WebDriver driver = this.driver;

        driver.findElement(By.xpath("//*[@id=\'sidebar\']/div[1]/div/ul[2]/li[8]/span")).click();

        WebElement iframe = driver.findElement(By.cssSelector("#popup > iframe"));
        driver.switchTo().frame(iframe);

        //utilizamos función javascript para rellenar el IFRAME
        super.javascriptExecute("$('#yes_no_question').val('This is a Yes/No question!!')",driver);

        driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id='submit']/span")).click();

        driver.switchTo().window(driver.getWindowHandle());

        driver.findElement(By.xpath("//*[@id=\'header\']/div[2]/ul/li[1]/a")).click();


    }

    public void Dropdown(){

        WebDriver driver = this.driver;

        driver.findElement(By.xpath("//*[@id=\'sidebar\']/div[1]/div/ul[2]/li[7]/span")).click();

        WebElement iframe = driver.findElement(By.cssSelector("#popup > iframe"));
        driver.switchTo().frame(iframe);

        //utilizamos función javascript para rellenar el IFRAME
        super.javascriptExecute("$('#dropdown_question').val('This is a Dropdown question!!')",driver);

        driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);

        WebElement element2 = driver.findElement(By.xpath("//*[@id=\'dropdown_options\']"));

        // Enter something
        element2.clear();
        element2.sendKeys("uno \n dos \n tres \n cuatro \n cinco \n seis \n siete \n ocho");

        driver.findElement(By.xpath("//*[@id='submit']/span")).click();

        driver.switchTo().window(driver.getWindowHandle());
        driver.findElement(By.xpath("//*[@id=\'header\']/div[2]/ul/li[1]/a")).click();

    }


    @Test
    public void TypeformExample() {
        TypeformLogin("lorinwen10@gmail.com","waterpolo10");
        CreateNewTypeform("New test with selenium");
        AddThankyou();
        AddWelcome();
        //ShortText();
        //LongText();
        //Statement();
        //Email();
        //Number();
        //Website();
        //Rating();
        YesNo();
        //Dropdown();
        deleteFirstForm();
    }
}