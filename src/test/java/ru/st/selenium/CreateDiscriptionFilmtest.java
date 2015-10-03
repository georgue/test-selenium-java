package ru.st.selenium;

import static org.testng.AssertJUnit.assertEquals;

import org.junit.After;
import org.testng.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedCondition.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.thoughtworks.selenium.webdriven.commands.IsTextPresent;

import ru.st.selenium.pages.TestBase;
import ru.stqa.selenium.factory.WebDriverFactory;

import com.thoughtworks.selenium.webdriven.SeleneseCommand;
 
public class CreateDiscriptionFilmtest extends TestBase{	
	@Test
	public void testUntitled(){
				
		driver.get(baseUrl + "/php4dvd/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement wait_user = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
		wait_user.sendKeys("admin");
	
	
		WebElement wait_pass = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));			
		wait_pass.sendKeys("admin");
		
		WebElement wait_submit = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("submit")));		    
	    wait_submit.click();
	    
		
		WebElement add_movie_buttom = driver.findElement(By.xpath("//div[@id=\"content\"]/*/*/*[2]/*/*/*/a[@href]"));
		add_movie_buttom.click();
		
		
		WebElement title_Input = driver.findElement(By.xpath("//form[@id=\"updateform\"]/*/*/tr[2]/td[2]/input[1]"));
		title_Input.sendKeys("����������");
		
		
		WebElement year_Input = driver.findElement(By.xpath("//form[@id=\"updateform\"]/*/*/tr[4]/td[2]/input[1]"));
		year_Input.sendKeys("2014");
		
		 
		WebElement seen_No_Checkbox = driver.findElement(By.xpath("//form[@id=\"updateform\"]/*/*/tr[9]/*[2]/input[@id=\"seen_no\"]"));
		seen_No_Checkbox.click();
		
		seen_No_Checkbox.submit();
		
		WebElement findCreateDiscription = driver.findElement(By.xpath("//div/div/div/section/div/div[1]/div[2]/h2"));
		
		// String str = findCreateDiscription.getAttribute("text");
		// String str = findCreateDiscription.getAttribute("innerHTML");
		String str = findCreateDiscription.getText();
		assertEquals(str, "���������� (2014)");
		
		WebElement btn_remove = driver.findElement(By.xpath("//*[contains(text(), \"Remove\")]"));
		btn_remove.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		driver.get("http://localhost/php4dvd/?logout"); 
		
		
		
				
			}
	
}

