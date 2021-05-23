package test;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

@Listeners(TestNGListener.class)
public class test {
	WebDriver driver;
	
	XSSFWorkbook Workbook;
    XSSFSheet sheet1;

@BeforeMethod
	public void setup() throws IOException {
//		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
		 driver = new EdgeDriver();
		driver.get("https://www.simplilearn.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
FileInputStream fis = new FileInputStream("exceldata.xlsx");
        
        Workbook = new XSSFWorkbook(fis);
        sheet1 = Workbook.getSheetAt(0);
	}

@Test
@Parameters({"name","pwd"})
	public void login(String uname,String pwd) throws InterruptedException {
		WebElement login = driver.findElement(By.linkText("Log in"));
		login.click();
		WebElement username = driver.findElement(By.name("user_login"));
		uname=sheet1.getRow(0).getCell(0).getStringCellValue();
		username.sendKeys(uname);
		WebElement psd = driver.findElement(By.name("user_pwd"));
		pwd=sheet1.getRow(0).getCell(1).getStringCellValue();
		psd.sendKeys(pwd);
		WebElement rem = driver.findElement(By.className("rememberMe"));
		rem.click();
		WebElement btn = driver.findElement(By.name("btn_login"));
		btn.click();
Thread.sleep(2000);
		WebElement errmsg = driver.findElement(By.id("msg_box"));
		String exp = errmsg.getText();
		String act = "The email or password you have entered is invalid.";
		if (act.equals(exp)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		
		Assert.assertEquals(act, exp);
	}
@AfterMethod
	public void exit() {
		driver.quit();

	}
}
