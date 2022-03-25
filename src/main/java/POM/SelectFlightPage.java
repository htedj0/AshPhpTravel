package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectFlightPage {
	
		Select from;
		Select to;
		Select depday;
		Select depmon;
		Select retday;
		Select retmon;
		WebElement cont;
		
		public  SelectFlightPage (WebDriver driver) {
			
			from = new Select(driver.findElement(By.xpath("//tbody/tr[2]/td[2]/select[1]")));
			to = new Select(driver.findElement(By.xpath("//tbody/tr[3]/td[2]/select[1]")));
			depday =  new Select(driver.findElement(By.xpath("//select[@id='departDay']")));
			depmon = new Select(driver.findElement(By.xpath("//select[@id='departMonth']")));
			retday = new Select(driver.findElement(By.xpath("//select[@id='returnDay']")));
			retmon = new Select(driver.findElement(By.xpath("//select[@id='returnMonth']")));
			cont =driver.findElement(By.xpath("//body/div[@id='container']/form[1]/input[1]"));
		}
		
	  public void setLocations() {
		  from.selectByVisibleText("New York");
		  to.selectByVisibleText("Sydney");
	  }
	  
	  public void setDates() {
		  depday.selectByVisibleText("05");
		  depmon.selectByVisibleText("March 2021");
		  retday.selectByVisibleText("07");
		  retmon.selectByVisibleText("March 2021");
	  }
	  
	  public void Continue() {
		  cont.click();
	  }
	   
	   public void SelectFlight() {
		   this.setLocations();
		   this.setDates();
		   this.Continue();
	   }

	

}
