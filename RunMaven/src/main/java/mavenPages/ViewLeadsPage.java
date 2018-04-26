package mavenPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import wdMethods.ProjectMethods;

public class ViewLeadsPage extends ProjectMethods{
	
	public ViewLeadsPage() {		
		PageFactory.initElements(driver,this);
	}	
	
	/*//edit button
	@FindBy(how= How.XPATH, using="//a[text()='Edit']")
	private WebElement eleEditLeadButton;
	
	@And("Click on edit button")
	public OpenTapsCRMPage clickEditLeadButton() {
		click(eleEditLeadButton);
		return new OpenTapsCRMPage();
	}
	
	//duplicate button
	@FindBy(how=How.LINK_TEXT, using= "Duplicate Lead")
	private WebElement eleDuplicateLeadBtn;

	@And("Click on duplicate button")
	public DuplicateLeadsPage clickDuplicateLead() {
		click(eleDuplicateLeadBtn);
		return new DuplicateLeadsPage();
	}*/
		
	//delete button
	@FindBy(how=How.CLASS_NAME, using= "subMenuButtonDangerous")
	private WebElement eleDeleteLeadBtn;

	@When("Click on delete button")
	public MyLeadsPage clickDeleteLead() {
		click(eleDeleteLeadBtn);
		return new MyLeadsPage();
	}

	//verify company name 
	@FindBy(how= How.ID, using= "viewLead_companyName_sp")
	private WebElement eleVerifyCompanyName;
	
	@And("Verify companyName as (.*) in viewLeads page")
		public ViewLeadsPage verifyCompanyName(String verCName) {
		verifyPartialText(eleVerifyCompanyName, verCName);
		return this;
	}
	
	//verify first name 
	@FindBy(how= How.ID,using ="viewLead_firstName_sp")
	private WebElement eleVerifyFirstName;
	
	@And("Verify firstName as (.*) in viewLeads page")
	public ViewLeadsPage verifyFirstName(String verFName) {
		verifyExactText(eleVerifyFirstName,verFName);
		return this;
		}
	
	//verify last name 
	@FindBy(how= How.ID, using= "viewLead_lastName_sp")
	private WebElement eleVerifyLastName;
	
	@And("Verify lastName as (.*) in viewLeads page")
	public ViewLeadsPage verifyLastName(String verLName) {
		verifyPartialText(eleVerifyLastName, verLName);
		return this;
	}
	






}
