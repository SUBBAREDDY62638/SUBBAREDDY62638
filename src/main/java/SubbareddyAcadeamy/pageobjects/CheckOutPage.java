package SubbareddyAcadeamy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import subbareddyacademy.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent{
	
	WebDriver driver;
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css=".action__submit") WebElement submit;
	@FindBy(css="[placeholder='Select Country']") WebElement country;
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]") WebElement selectCountry;
	
	
	
	public void selectCountry()
	{
		
	}

	
	

}
