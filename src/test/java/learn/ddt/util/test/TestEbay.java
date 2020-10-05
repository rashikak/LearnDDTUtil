package learn.ddt.util.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import LearnDDTUtil.LearnDDTUtil.AppTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import learn.ddt.pages.HomePage;
import learn.ddt.util.XlsReader;

public class TestEbay extends TestCase {
	WebDriver driver;
	

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public TestEbay(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(TestEbay.class);
	}

	/**
	 * Rigourous Test :-)
	 * @throws IOException 
	 */

	public void testCreateAccount() throws IOException {
		// Read data from Xls
		XlsReader reader = new XlsReader("./src/main/java/learn/ddt/util/ebay-test.xlsx");
		
		int rows= reader.getRowCount("search");
		
		System.out.println("Rows:"+rows);
		
		String searchText1 = reader.getCellData("search", "searchText", 2);
		assertEquals("Rashika", searchText1);
		int searchTextResult1 = Integer.parseInt(reader.getCellData("search", "searchResult", 2));

		// Search in Google
		System.setProperty("webdriver.chrome.driver", "C:\\Driver_Server\\exefiles\\chromedriver.exe");
		driver = new ChromeDriver();
		File sfile=new File("C:\\Git_Project\\LearnDDTUtil\\src\\main\\java\\learn\\ddt\\util\\config.properties");
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(sfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties prop=new Properties();
		prop.load(fis);
		driver.get(prop.getProperty("url"));
		
		HomePage hpage = new HomePage(driver);
		int size=hpage.searchText(searchText1);
	    
		//compare searchText
		assertEquals(searchText1, searchText1);
		
		//compare searchResult
		assertTrue(searchTextResult1<size);

		driver.quit();

	}

}
