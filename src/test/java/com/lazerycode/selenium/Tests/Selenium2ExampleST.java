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

        WebElement element = driver.findElement(By.xpath("//*[@id=\'forms\']/li[1]"));
        element.click();

        WebElement element1 = driver.findElement(By.xpath("//*[@id='quickyform_name']"));
        element1.clear();
        element1.sendKeys(Titulo);

        //Gestión de selectores del Pop-Up
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"s2id_quickyform_language\"]/a/div/b"));
        element2.click();
        WebElement element3 = driver.findElement(By.xpath("/html/body/div[5]/ul/li[1]/div"));
        element3.click();
        WebElement element4 = driver.findElement(By.xpath("//*[@id=\"s2id_quickyform_category\"]/a/div/b"));
        element4.click();
        WebElement element5 = driver.findElement(By.xpath("/html/body/div[5]/ul/li[1]/div"));
        element5.click();
        WebElement element6 = driver.findElement(By.xpath("//*[@id=\'add-form\']/form/div[4]/input"));
        element6.click();

    }

    public void AddWelcome() {

        //Añade welcome screen
        WebDriver driver = this.driver;

        WebElement element2 = driver.findElement(By.xpath("//*[@id=\'sidebar\']/div[1]/div/ul[1]/li[1]/span"));
        element2.click();

        WebElement iframe = driver.findElement(By.cssSelector("#popup > iframe"));
        driver.switchTo().frame(iframe);
        WebElement element3 = driver.findElement(By.xpath("//*[@id=\'submit\']/span"));
        element3.click();
        //Sale del Iframe
        driver.switchTo().window(driver.getWindowHandle());
    }

    public void AddThankyou(){


        //Añade thank you screen
        WebDriver driver = this.driver;

        WebElement element = driver.findElement(By.linkText ("+ Add Questions"));
        element.click();

        WebElement element1 = driver.findElement(By.xpath("//*[@id=\'sidebar\']/div[1]/div/ul[1]/li[2]/span"));
        element1.click();

        WebElement iframe = driver.findElement(By.cssSelector("#popup > iframe"));
        driver.switchTo().frame(iframe);
        WebElement element2 = driver.findElement(By.xpath("//*[@id='submit']/span"));
        element2.click();
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

        WebElement element2 = driver.findElement(By.xpath("//*[@id='submit']/span"));
        element2.click();

        driver.switchTo().window(driver.getWindowHandle());

    }

    public void LongText(){

        WebDriver driver = this.driver;

        WebElement element = driver.findElement(By.xpath("//*[@id=\'sidebar\']/div[1]/div/ul[2]/li[3]/span"));
        element.click();

        WebElement iframe = driver.findElement(By.cssSelector("#popup > iframe"));
        driver.switchTo().frame(iframe);

        //utilizamos función javascript para rellenar el IFRAME
        super.javascriptExecute("$('#textareafield_question').val('This isa long text with a lot of words!! You can put it more if you want')",driver);

        driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);

        WebElement element2 = driver.findElement(By.xpath("//*[@id='submit']/span"));
        element2.click();

        driver.switchTo().window(driver.getWindowHandle());

    }

    public void Statement(){

        WebDriver driver = this.driver;

        WebElement element = driver.findElement(By.xpath("//*[@id=\'sidebar\']/div[1]/div/ul[2]/li[5]/span"));
        element.click();

        WebElement iframe = driver.findElement(By.cssSelector("#popup > iframe"));
        driver.switchTo().frame(iframe);

        //utilizamos función javascript para rellenar el IFRAME
        super.javascriptExecute("$('#statement_content').val('This is a statement!!')",driver);

        driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);

        WebElement element2 = driver.findElement(By.xpath("//*[@id='submit']/span"));
        element2.click();

        driver.switchTo().window(driver.getWindowHandle());

    }

    public void Email(){

        WebDriver driver = this.driver;

        WebElement element = driver.findElement(By.xpath("//*[@id=\'sidebar\']/div[1]/div/ul[2]/li[9]/span"));
        element.click();

        WebElement iframe = driver.findElement(By.cssSelector("#popup > iframe"));
        driver.switchTo().frame(iframe);

        //utilizamos función javascript para rellenar el IFRAME
        super.javascriptExecute("$('#email_question').val('This is a email question!!')",driver);

        driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);

        WebElement element2 = driver.findElement(By.xpath("//*[@id='submit']/span"));
        element2.click();

        driver.switchTo().window(driver.getWindowHandle());

    }

    public void Number(){

        WebDriver driver = this.driver;

        WebElement element = driver.findElement(By.xpath("//*[@id=\'sidebar\']/div[1]/div/ul[2]/li[13]/span"));
        element.click();

        WebElement iframe = driver.findElement(By.cssSelector("#popup > iframe"));
        driver.switchTo().frame(iframe);

        //utilizamos función javascript para rellenar el IFRAME
        super.javascriptExecute("$('#number_question').val('This is a number question!!')",driver);

        driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);

        WebElement element2 = driver.findElement(By.xpath("//*[@id='submit']/span"));
        element2.click();

        driver.switchTo().window(driver.getWindowHandle());

    }

    public void Website(){

        WebDriver driver = this.driver;

        WebElement element = driver.findElement(By.xpath("//*[@id=\'sidebar\']/div[1]/div/ul[2]/li[14]/span"));
        element.click();

        WebElement iframe = driver.findElement(By.cssSelector("#popup > iframe"));
        driver.switchTo().frame(iframe);

        //utilizamos función javascript para rellenar el IFRAME
        super.javascriptExecute("$('#website_question').val('This is a website question!!')",driver);

        driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);

        WebElement element2 = driver.findElement(By.xpath("//*[@id='submit']/span"));
        element2.click();

        driver.switchTo().window(driver.getWindowHandle());

    }
    public void Rating(){

        WebDriver driver = this.driver;

        WebElement element = driver.findElement(By.xpath("//*[@id=\'sidebar\']/div[1]/div/ul[2]/li[10]/span"));
        element.click();

        WebElement iframe = driver.findElement(By.cssSelector("#popup > iframe"));
        driver.switchTo().frame(iframe);

        //utilizamos función javascript para rellenar el IFRAME
        super.javascriptExecute("$('#rating_question').val('This is a rating question!!')",driver);

        driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);

        WebElement element2 = driver.findElement(By.xpath("//*[@id='submit']/span"));
        element2.click();

        driver.switchTo().window(driver.getWindowHandle());

    }

    public void YesNo(){

        WebDriver driver = this.driver;

        WebElement element = driver.findElement(By.xpath("//*[@id=\'sidebar\']/div[1]/div/ul[2]/li[8]/span"));
        element.click();

        WebElement iframe = driver.findElement(By.cssSelector("#popup > iframe"));
        driver.switchTo().frame(iframe);

        //utilizamos función javascript para rellenar el IFRAME
        super.javascriptExecute("$('#yes_no_question').val('This is a Yes/No question!!')",driver);

        driver.manage().timeouts().setScriptTimeout(2,TimeUnit.SECONDS);

        WebElement element2 = driver.findElement(By.xpath("//*[@id='submit']/span"));
        element2.click();

        driver.switchTo().window(driver.getWindowHandle());

    }



    @Test
    public void TypeformExample() {
        TypeformLogin("lorinwen10@gmail.com","waterpolo10");



/* HTTPS De DANI

        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
        HttpPost post = new HttpPost("https://admin.typeform.com/form/delete/70822");
        try{
            HttpResponse response = defaultHttpClient.execute(post);

            int statuscode = response.getStatusLine().getStatusCode();
            System.out.println(statuscode);
            System.out.println(response.toString());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally
        {
            //Important: Close the connect
            defaultHttpClient.getConnectionManager().shutdown();
        }

*/

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

    }
}