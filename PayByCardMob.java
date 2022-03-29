import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PayByCardMob extends Parent {
	public void cardMobile() throws Exception {
		try {

			// Clicking on pay now by card
			driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[1]")).click();
			Thread.sleep(500);

			// Scrolling down
			js.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(500);

			// Entering card details
			driver.switchTo().frame(driver.findElement(
					By.xpath("//*[@id=\"cardContainer\"]/div/div/div[2]/div[1]/div[1]/label/div/span/iframe")));
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"encryptedCardNumber\"]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"encryptedCardNumber\"]")).sendKeys("3700 000000 00002");
			Thread.sleep(500);
			driver.switchTo().defaultContent();

			// Add expire date
			Thread.sleep(1500);

			// Converting iFrame to frame
			driver.switchTo().frame(driver.findElement(
					By.xpath("//*[@id=\"cardContainer\"]/div/div/div[2]/div[1]/div[2]/div[1]/label/div/span/iframe")));
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"encryptedExpiryDate\"]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"encryptedExpiryDate\"]")).sendKeys("0330");
			Thread.sleep(500);
			driver.switchTo().defaultContent();

			// Add CVV
			Thread.sleep(1500);

			// Converting iFrame to frame
			driver.switchTo().frame(driver.findElement(
					By.xpath("//*[@id=\"cardContainer\"]/div/div/div[2]/div[1]/div[2]/div[2]/label/div/span/iframe")));
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"encryptedSecurityCode\"]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"encryptedSecurityCode\"]")).sendKeys("7373");
			Thread.sleep(500);
			driver.switchTo().defaultContent();

			// Add name
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@classnamemodifiers='large']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@classnamemodifiers='large']")).sendKeys("T");
			driver.findElement(By.xpath("//input[@classnamemodifiers='large']")).sendKeys("e");
			driver.findElement(By.xpath("//input[@classnamemodifiers='large']")).sendKeys("s");
			driver.findElement(By.xpath("//input[@classnamemodifiers='large']")).sendKeys("t");
			Thread.sleep(1000);

			js.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(500);

			// Click on place order button
			Thread.sleep(1500);
			driver.findElement(By.xpath("//*[@id=\"adyen-cc-form\"]/div[3]/div/button")).click();
			Thread.sleep(4500);

			System.out.println("Pay by card for mob,Pass");
			// Write Report
			wr.writeReport("Pay by card ,Passed");

			// Printing order id
			Thread.sleep(1500);
			Thread.sleep(500);
			System.out.println("Mobile functions,Pass ");


			String x = driver
					.findElement(By
							.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div/div[2]/div[1]/div[1]/div[2]/span[1]"))
					.getText();
			Thread.sleep(500);
			System.out.println("Order id,Pass");
			System.out.println(x);
			wr.writeReport(x);
			
//			// Closing the browser
//			driver.close();

			// ScreenRecoder
			ScreenRecorderUtil.stopRecord();

		} catch (Exception e) {
			System.out.println("Unsucessful Pay-by-card");
			driver.quit();
			Thread.sleep(1000);

			// ScreenRecoder
			ScreenRecorderUtil.stopRecord();

			// Write Report
			wr.writeReport("Pay by card ,Failed");
			wr.writeReport("******");
		}
	}
}
