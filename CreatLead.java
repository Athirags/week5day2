package wwk5.day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadExcelData;

public class CreatLead extends ProjectSpecificMethod{	
@Test(dataProvider="testData")
	public void runCreatLead(String UserName,String Password,String Cname,String FName ,String LName) throws InterruptedException{
		//WebDriverManager.chromedriver().setup();
		//ChromeDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.get("http://leaftaps.com/opentaps/");
		//  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).sendKeys(UserName);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(Cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(FName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(LName);
		driver.findElement(By.name("submitButton")).click();	
}
@DataProvider
public String[][] testData() throws IOException {
String[][] data = ReadExcelData.readdata("tc001");
	return data;
}
/*public String[][] testData(){
	String[][]array=new String[2][5];
	array [0][0]="Demosalesmanager";
	array [0][1]="crmsfa";
	array [0][2]="TL"
	array [0][3]="HARI";
	array [0][4]="R";
	array [1][0]="Democsr";
	array [1][1]="crmsfa";
	array [1][2]="TL";
	array [1][3]="BABU";
	array [1][4]="M";
	return array;
}
*/
}


