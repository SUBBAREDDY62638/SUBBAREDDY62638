package SubbareddyAcadeamy.pageobjects;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.interactions.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class standAloneTest {

	public static void main(String[] args) throws InterruptedException {
		String Productname="ZARA COAT 3";
		
		
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.get("https://rahulshettyacademy.com/client/");
		LandingPage LandingPage= new LandingPage(driver);
        driver.manage().window().maximize();
        LandingPage.goTo();
        LandingPage.loginapplication("anshika@gmail.com", "Iamking@000");
       
//        List<WebElement> products = driver.findElements(By.xpath("//img[@class='card-img-top']"));
          List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        WebElement prod = products.stream().filter(product->
        product.findElement(By.cssSelector("b")).getText().equals(Productname)).findFirst().orElse(null);
        System.out.println(prod);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        
       
        
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container"))); 
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
        
        List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
        
      boolean match = cartproducts.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(Productname));
      Assert.assertTrue(match);
      driver.findElement(By.cssSelector(".totalRow button")).click();
      
      
      
      Actions ac= new Actions(driver);
      ac.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
      driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
      driver.findElement(By.cssSelector(".action__submit")).click();
      String text = driver.findElement(By.cssSelector(".hero-primary")).getText();
      Assert.assertEquals(text, "THANKYOU FOR THE ORDER.");
      System.out.println(text);
//      Assert.assertTrue(equalsIgnoreCase("THANKYOU FOR THE ORDER."));
      driver.close();
      
        
        
        
        
        
        
        
        
        
 
	
	}

	


}
