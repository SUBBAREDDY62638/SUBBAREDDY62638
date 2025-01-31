package SubbareddyAcadeamy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import subbareddyacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	@FindBy(css=".cartSection h3")List<WebElement> cardProducts;
	@FindBy(css=".totalRow button")WebElement ChrckoutEle;
	
public  CartPage(WebDriver driver)
{
	super(driver);
	this.driver= driver;
	PageFactory.initElements(driver, this);

}
public Boolean verifyProductDisplay(String productName) {
	

	Boolean match=cardProducts.stream().anyMatch(cardProduct->cardProduct.getText().equalsIgnoreCase(productName));
	return match;


}

public void goToCheckOut()
{
	ChrckoutEle.click();
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
