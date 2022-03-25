package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebElement uid;
	WebElement pwd;
	WebElement signin;
	
	public  LoginPage (WebDriver driver) {
		
		uid = driver.findElement(By.xpath("//input[@id='username']"));
		pwd = driver.findElement(By.xpath("//input[@id='password']"));
		signin = driver.findElement(By.xpath("//body/div[@id='container']/form[1]/div[1]/div[1]/p[4]/input[1]"));
	}
	
   public void setUserName() {
	uid.sendKeys("agileway");
    }
   
   public void serPassword() {
	   pwd.sendKeys("testwise");
   }
   
   public void setSignIn() {
	   signin.click();
   }
   
   public void login() {
	   this.setUserName();
	   this.serPassword();
	   this.setSignIn();
   }

}
