package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PassengerDetails {

	WebElement FirstName;
	WebElement LastName;
	WebElement next;
	
	public PassengerDetails (WebDriver driver) {
		
		FirstName = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		LastName = driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]"));
		next = driver.findElement(By.xpath("//body[1]/div[1]/form[1]/input[3]"));
	}
	
	public void setDetails() {
		FirstName.sendKeys("Ashwini");
		LastName.sendKeys("Kale");
		next.click();
	}
	
	public void Details() {
		this.setDetails();
	}
	 
}
