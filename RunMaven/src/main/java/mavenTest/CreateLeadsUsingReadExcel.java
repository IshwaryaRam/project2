package mavenTest;

import java.io.IOException;

import org.testng.annotations.*;


public class CreateLeadsUsingReadExcel extends ProjectMethods{

	@Test(dataProvider="fetchData")
	public void createLeads(String cName, String fName, String lName, String eMail, String phone) throws InterruptedException {
		//crm/sfa 
		click(locateElement("xpath","//a[contains( text() , 'CRM/SFA')]"));

		//leads
		click(locateElement("linkText","Leads"));

		//create leads
		click(locateElement("linkText","Create Lead"));
		//company name
		type(locateElement("id", "createLeadForm_companyName"), cName);
		//first name
		type(locateElement("id", "createLeadForm_firstName"), fName);
		//last name
		type(locateElement("id", "createLeadForm_lastName"), lName);
		//email id
		type(locateElement("id","createLeadForm_primaryEmail"),eMail);
		//phone
		type(locateElement("id","createLeadForm_primaryPhoneNumber"),phone);
		//submit or create leads
		click(locateElement("class","smallSubmit"));

	}
	
	@DataProvider(name="fetchData")
	public Object[][] getData() throws IOException {
		CreateLeadExcel rExcel = new CreateLeadExcel();
		
		Object[][] data= rExcel.readExcel();
		return data;
	}
}