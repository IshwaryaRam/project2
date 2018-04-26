package mavenRunner;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import wdMethods.ProjectMethods;

public class Hooks extends ProjectMethods{

	@Before
	public void before(Scenario sc) {
		startResult();
		startTestModule("TC01_Create lead","Create new leads using cucumber");	
	//	startTestModule("TC02_Edit lead","Edit leads using cucumber");	
	//	startTestModule("TC03_Delete lead","Delete leads using cucumber");	
	//	startTestModule("TC04_Find lead","Find leads using cucumber");	
	//	startTestModule("TC05_Duplicate lead","Duplicate leads using cucumber");	
	//	startTestModule("TC06_Merge lead","Merge leads using cucumber");	
		System.out.println(sc.getName());
		test = startTestCase("Leads");
		test.assignCategory("Smoke");
		test.assignAuthor("Ishu");
		startApp("chrome");	
		
	
		
	}
	
	@After
	public void after(Scenario sc) {
		System.out.println(sc.getStatus());
		closeAllBrowsers();
		endResult();
	}
	
}
