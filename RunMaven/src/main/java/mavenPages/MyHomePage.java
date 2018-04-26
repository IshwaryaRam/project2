package mavenPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import wdMethods.ProjectMethods;

public class MyHomePage extends ProjectMethods{
	
	public MyHomePage() {		
		PageFactory.initElements(driver,this);
	}	
	
	
	
	@FindBy(how= How.LINK_TEXT,using ="Leads")
	private WebElement eleLeads;
	
	@And("Click in leads tab")
	public MyLeadsPage clickLeads() {
		click(eleLeads);
		return new MyLeadsPage();
		
	}
	
	
	
	
	
	
	

}
