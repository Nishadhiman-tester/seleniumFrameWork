package PageObjectFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginClass
{
	WebDriver ldriver;
	public  LoginClass(WebDriver rdriver)
	 {
	 ldriver=rdriver;
	 PageFactory.initElements(ldriver,this);
	 }
	@FindBy(id="username") WebElement user;
	@FindBy(id="password") WebElement pass;
	@FindBy(id="submit") WebElement sub;
	public void username1(String u)
	{
		user.sendKeys(u);
}
	public void password1(String p)
	{
		pass.sendKeys(p);
	}
	public void submit1()
	{
		sub.click();
	}

}
