package SubbareddyAcadeamy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import subbareddyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="userEmail") WebElement useremail;
	@FindBy(id="userPassword") WebElement userPassword;
	@FindBy(id="login") WebElement login;
	
	
	
	public void loginapplication(String email,String password) {
		
		useremail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	
	
	
	
}
