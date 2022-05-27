package wwk5.day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadExcelData;

public class EditLead extends ProjectSpecificMethod {
	@Test(dataProvider="testData")
	public static void runEditLead(String UserName,String Password,String phonrNumber,String updateLeadFormcompanyName ) throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		//ChromeDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.get("http://leaftaps.com/opentaps/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).sendKeys(UserName);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phonrNumber);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(updateLeadFormcompanyName);
		driver.findElement(By.name("submitButton")).click();
		
}
@DataProvider
public String[][] testData() throws IOException {
String[][] data = ReadExcelData.readdata("tc004");
	return data;
}
}






