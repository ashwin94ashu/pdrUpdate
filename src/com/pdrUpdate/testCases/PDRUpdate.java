package com.pdrUpdate.testCases;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;

import com.pdrUpdate.UI.PdrUpdateui;
import com.pdrUpdate.readFiles.ReadTextFile;

public class PDRUpdate 
{

public static WebDriver driver= null;


	public void test() throws Exception
	{
		ReadTextFile txtData=new ReadTextFile();
		ArrayList<String> CrcData=txtData.getCrcValues();
		
		String us=PdrUpdateui.userId;
		String pw=PdrUpdateui.pwd;
		String op=PdrUpdateui.ot;
		String prn=PdrUpdateui.pr;
		System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe"); // chrome driver path
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		// launching chrome
		//JavascriptExecutor js = (JavascriptExecutor) driver; // for scroll down
		
		driver.get("http://newep.lge.com/");
		driver.manage().window().maximize();
		
		WebElement user = driver.findElement(By.xpath("//*[@id=\"USER\"]"));
		user.sendKeys(us);
		//"ashwing.bhat"
		
		WebElement pwd = driver.findElement(By.xpath("//*[@id=\"LDAPPASSWORD\"]"));
		pwd.sendKeys(pw);
		//"LG12soft43"
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		
		WebElement otp = driver.findElement(By.xpath("//*[@id=\"OTPPASSWORD\"]"));
		otp.sendKeys(op);
		
		driver.findElement(By.xpath("//*[@id=\"loginSsobtn\"]")).submit();
		
		//PDR part
		
		driver.navigate().to("http://pdr.lge.com/"); 
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		
		WebElement register = driver.findElement(By.xpath("//td[text()='Registration/Search']")); // click on Registration/Search
		register.click();
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		WebElement search = driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[2]/div[2]/div/div/div/table/tbody/tr[2]/td")); // click on Search PDR
		search.click();
		
		driver.manage().timeouts().implicitlyWait(05,TimeUnit.SECONDS) ;
		WebElement num = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div[4]/div/div[2]/div[2]/div/form/table/tbody/tr[2]/td/input")); // enter PDR number 
		num.sendKeys(prn);
		//PR20WW5005481
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		
		//scroll down 
		Thread.sleep(4000);
		WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div[4]/div/div[2]/div[3]/div/div[1]/table/tbody/tr/td"));
		Coordinates co=((Locatable) element).getCoordinates();
		co.inViewPort();
		
		driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div/div[4]/div/div[2]/div[3]/div/div[1]/table/tbody/tr/td")).click(); // click on Registration/Search
		
		// click on checkbox
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div/div[3]/div/div/div[1]/div/div[1]/div/table/tbody/tr/td[1]")).click();;
		
	
		// open pripco
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[5]/div/table/tbody/tr/td")).click();
		
	
		if(driver.findElement(By.xpath("/html/body/div[7]")) != null)
		{
		Thread.sleep(5000);
		// Edit test area
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;
		WebElement text= driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[2]/div/form/table/tbody/tr[7]/td[2]/nobr/textarea"));
		text.sendKeys("PDR Updated");
		}
		
		driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div/div[2]/div/div[2]/div/div[1]/div/table/tbody/tr/td")).click();
		
		driver.findElement(By.xpath("/html/body/div[8]/div/div[1]/div/div[2]/div/div[1]")).click();
        Thread.sleep(7000);
        
        Thread.sleep(6000);
        driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS) ;
        driver.findElement(By.xpath("/html/body/div[8]/div/div[1]/div/div[2]/div/div")).click();
        
        driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS) ;
        driver.findElement(By.xpath("/html/body/div[8]/div[1]/div[3]")).click();
        
        Thread.sleep(4000);
		WebElement scrl = driver.findElement(By.xpath("//*[contains(text(),'CUP')]"));
		Coordinates cor=((Locatable) scrl).getCoordinates();
		cor.inViewPort();
		
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		//double click on input text field 
		
		//SWV
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		Actions action=new Actions(driver);
		WebElement locator= driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div/div/div/div/div[1]/div/div[1]/div[19]/div/div[2]/div[1]/table/tbody/tr[2]/td[5]"));
		action.doubleClick(locator).build().perform();
		
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		WebElement swv = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div/div/div/div/div[1]/div/div[1]/div[19]/div/div[2]/div[1]/table/tbody/tr[2]/td[5]/div/span/table/tbody/tr/td[1]/input"));
		swv.clear();
		swv.sendKeys((CharSequence)CrcData.get(0));
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.RETURN).build().perform();
		
		//SWOV
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		Actions action1=new Actions(driver);
		WebElement locator1= driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div/div/div/div/div[1]/div/div[1]/div[19]/div/div[2]/div[1]/table/tbody/tr[3]/td[5]"));
		action1.doubleClick(locator1).build().perform();
		
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		WebElement swov = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div/div/div/div/div[1]/div/div[1]/div[19]/div/div[2]/div[1]/table/tbody/tr[3]/td[5]/div/span/table/tbody/tr/td[1]/input"));
		swov.clear();
		swov.sendKeys((CharSequence)CrcData.get(1));
		action1.sendKeys(Keys.TAB).build().perform();
		action1.sendKeys(Keys.RETURN).build().perform();
		
		
		//DBCRC
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		Actions action2=new Actions(driver);
		WebElement locator2= driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div/div/div/div/div[1]/div/div[1]/div[19]/div/div[2]/div[1]/table/tbody/tr[7]/td[5]"));
		action2.doubleClick(locator2).build().perform();
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		WebElement db = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div/div/div/div/div[1]/div/div[1]/div[19]/div/div[2]/div[1]/table/tbody/tr[7]/td[5]/div/span/table/tbody/tr/td[1]/input"));
		db.clear();
		db.sendKeys((CharSequence)CrcData.get(2));
		action2.sendKeys(Keys.TAB).build().perform();
		action2.sendKeys(Keys.RETURN).build().perform();
		

		//FPRI
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		Actions action3=new Actions(driver);
		WebElement locator3= driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div/div/div/div/div[1]/div/div[1]/div[19]/div/div[2]/div[1]/table/tbody/tr[9]/td[5]"));
		action3.doubleClick(locator3).build().perform();
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		WebElement fpri = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div/div/div/div/div[1]/div/div[1]/div[19]/div/div[2]/div[1]/table/tbody/tr[9]/td[5]/div/span/table/tbody/tr/td[1]/input"));
		fpri.clear();
		fpri.sendKeys((CharSequence)CrcData.get(3));
		action3.sendKeys(Keys.TAB).build().perform();
		action3.sendKeys(Keys.RETURN).build().perform();
		
		//FILECRC
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		Actions action4=new Actions(driver);
		WebElement locator4= driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div/div/div/div/div[1]/div/div[1]/div[19]/div/div[2]/div[1]/table/tbody/tr[10]/td[5]"));
		action4.doubleClick(locator4).build().perform();

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		WebElement crc = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div/div/div/div/div[1]/div/div[1]/div[19]/div/div[2]/div[1]/table/tbody/tr[10]/td[5]/div/span/table/tbody/tr/td[1]/input"));
		crc.clear();
		crc.sendKeys((CharSequence)CrcData.get(4));
		action4.sendKeys(Keys.TAB).build().perform();
		action4.sendKeys(Keys.RETURN).build().perform();
		
		
		//CUPPS
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		Actions action5=new Actions(driver);
		WebElement locator5= driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div/div/div/div/div[1]/div/div[1]/div[19]/div/div[2]/div[1]/table/tbody/tr[11]/td[5]"));
		action5.doubleClick(locator5).build().perform();
		
		/*WebElement compcup=driver.findElement(By.xpath("/html/body/div[11]/div[2]/div/div/div/div/div/div/div[1]/div/div[1]/div[19]/div/div[2]/div[1]/table/tbody/tr[11]/td[5]"));
		String cupValue = (String)(compcup.getText());*/
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
		WebElement cup = driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div/div/div/div/div[1]/div/div[1]/div[19]/div/div[2]/div[1]/table/tbody/tr[11]/td[5]/div/span/table/tbody/tr/td[1]/input"));
		//cup.clear();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		cup.sendKeys((CharSequence)CrcData.get(5));
		
		//System.out.println(cup);
		/*System.out.println("read"+cupValue);
		if(!cupValue.equals("N/A"))
		{
			
			System.out.println("Not equal");
			System.out.println((CharSequence)CrcData.get(5));
			
		}
		else
		{
			cup.sendKeys("N/A");
			System.out.println("Equal");
			System.out.println((CharSequence)CrcData.get(5));
			/*action5.sendKeys(Keys.TAB).build().perform();
			action5.sendKeys(Keys.RETURN).build().perform();
			System.out.println(cupValue);
		}*/
		
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		Actions actionS=new Actions(driver);
		WebElement save= driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div/div/div/div/div/div[2]/div/div"));
		actionS.doubleClick(save).build().perform();
		
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("/html/body/div[10]/div/div[1]/div/div[2]/div/div[1]")).click();
		
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("/html/body/div[10]/div/div[1]/div/div[2]/div/div")).click();
		
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("/html/body/div[8]/div[1]/div[4]")).click();
		
		System.out.println("Error free!!! :-) ");
		
		/*
		 * Delete PRI code
		 * driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
		 *
		driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div/div[1]/div/div[1]/div/div[2]/div/div[2]/div/table/tbody/tr/td")).click();
		
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[9]/div/div[1]/div/div[2]/div/div[1]/table/tbody/tr/td")).click();
		
		if(driver.findElement(By.xpath("/html/body/div[10]")) != null)
		{
		Thread.sleep(5000);
		// Edit test area
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		WebElement text= driver.findElement(By.xpath("/html/body/div[10]/div[2]/div/div/div/div/div/div/div[1]/div/div/div/form/table/tbody/tr[2]/td[2]/nobr/textarea"));
		text.sendKeys("test");
		}
		*/
		
		/*
		 * Approval page
		 * driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//div[3]/div/table/tbody/tr/td[contains(text(),'Approval')]")).click();*/
		//driver. close();
	}
}
