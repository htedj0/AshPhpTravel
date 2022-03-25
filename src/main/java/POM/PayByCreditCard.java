package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PayByCreditCard {
     WebElement CardType;
     WebElement Cardno;
     Select Exmon;
     Select Exyr;
     WebElement paynow;
     
     public PayByCreditCard (WebDriver driver) {
    	 
    	 CardType = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
    	 Cardno = driver.findElement(By.xpath("//tbody/tr[3]/td[2]/input[1]"));
    	 Exmon = new Select(driver.findElement(By.xpath("//tbody/tr[4]/td[2]/select[1]")));
    	 Exyr = new Select(driver.findElement(By.xpath("//tbody/tr[4]/td[2]/select[2]")));
    	 paynow = driver.findElement(By.xpath("//body[1]/div[1]/form[1]/p[1]/input[1]"));
    	
     }
     
     public void setCardDetails() {
    	 CardType.click();
    	 Cardno.sendKeys("123 456 7890");
    	 Exmon.selectByVisibleText("10");
    	 Exyr.selectByVisibleText("2023");
    	 
    	 paynow.click();
     }
     
     public void CardDetails() {
    	 this.setCardDetails();
     }
     
}
