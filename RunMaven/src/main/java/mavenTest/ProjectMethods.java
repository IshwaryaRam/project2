package mavenTest;

import org.testng.annotations.*;

public class ProjectMethods extends SeMethods{


	@Parameters({"url","username","password"})
	@BeforeMethod
	public void login(String url, String username, String password) {
		//open browser, maximize, wait time
		startApp("chrome", url);


		//username
		type(locateElement("id", "username"), username);
		//password

		type(locateElement("id", "password"), password);
		//login
		click(locateElement("class", "decorativeSubmit"));

	}

	@AfterMethod
	public void closeApp() {
		closeBrowser();
	}

	public void closeOpenBrowser() {
		closeAllBrowsers();
	}
}
