package mavenPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import wdMethods.ProjectMethods;

public class LoginPage extends ProjectMethods{
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.ID,using="username")
	private WebElement eleUserName;
	
	@And("Enter login username as (.*) in maven")
	public LoginPage typeUserName(String uName) {
		type(eleUserName, uName);
		return this;
	}
	
	
	@FindBy(how=How.ID,using="password")
	private WebElement elePassword;
	
	@And("Enter login password as (.*) in maven")
	public LoginPage enterPassword(String pwd) {
		type(elePassword, pwd);
		return this;
	}
	
	
	@FindBy(how=How.CLASS_NAME,using="decorativeSubmit")
	private WebElement eleLogin;
	
	@And("Click login button")
	public HomePage clickLogIn() {
		click(eleLogin);
		return new HomePage();		
	}
	
	@When("Click login button for negative flow")
	public LoginPage clickLogInForFailer() {
		click(eleLogin);
		return this;		
	}
	
	@FindBy(how=How.ID,using="errorDiv")
	private WebElement eleErrorMsg;
	@Then("Verify login is failed")
	public LoginPage verifyErrorMsg(String data) {
	verifyPartialText(eleErrorMsg, data);
		return this;		
	}
}
