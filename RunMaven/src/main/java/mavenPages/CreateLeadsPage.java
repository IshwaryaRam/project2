package mavenPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import wdMethods.ProjectMethods;

public class CreateLeadsPage extends ProjectMethods{

	public CreateLeadsPage() {		
		PageFactory.initElements(driver,this);
	}	



	@FindBy(how= How.ID,using = "createLeadForm_companyName")
	private WebElement eleCompanyName;

	@And("Enter company Name as (.*) in createLeads page")
	public CreateLeadsPage enterCompanyName( String cName) {
		type(eleCompanyName,cName);
		return this;
	}

	@FindBy(how= How.ID,using = "createLeadForm_firstName")
	private WebElement eleFirstName;

	@And("Enter first name as (.*) in createLeads page")
	public CreateLeadsPage enterFirstName( String fName) {
		type(eleFirstName,fName);
		return this;
	}

	@FindBy(how= How.ID,using = "createLeadForm_lastName")
	private WebElement eleLastName;

	@And("Enter last name as (.*) in createLeads page")
	public CreateLeadsPage enterLastName( String lName) {
		type(eleLastName,lName);
		return this;
	}

	@FindBy(how= How.CLASS_NAME,using = "smallSubmit")
	private WebElement eleCreateLeadButton;

	@When("Click on create lead button")
	public ViewLeadsPage clickCreateLeadButton() {
		click(eleCreateLeadButton);
		return new ViewLeadsPage();
	}

}
