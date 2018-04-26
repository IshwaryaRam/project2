package mavenPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import wdMethods.ProjectMethods;

public class MyLeadsPage extends ProjectMethods{

	public MyLeadsPage() {		
		PageFactory.initElements(driver,this);
	}	



	@FindBy(how= How.LINK_TEXT,using ="Create Lead")
	private WebElement eleCreateLeads;

	@And("Click on Create lead")
	public CreateLeadsPage clickCreateLeads() {
		click(eleCreateLeads);
		return new CreateLeadsPage();

	}

/*	@FindBy(how=How.LINK_TEXT, using ="Find Leads")
	private WebElement eleFindLeads;

	@And("Click on find leads")
	public FindLeadsPage clickFindLeads() {
		click(eleFindLeads);
		return new FindLeadsPage();
	}
	
	@FindBy(how= How.LINK_TEXT,using ="Merge Leads")
	private WebElement eleMergeLeads;

	@And("Click on merge leads")
	public MergeLeadsPage clickMergeLeads() {
		click(eleMergeLeads);
		return new MergeLeadsPage();

	}
*/	
	
}







