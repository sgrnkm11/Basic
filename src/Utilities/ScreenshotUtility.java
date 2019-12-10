package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.apache.commons.io.FileUtils;

public class ScreenshotUtility {

	public void captureScreenShot(WebDriver ldriver) throws Exception {

		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) ldriver).getScreenshotAs(OutputType.FILE);
		Thread.sleep(6000);
		try {
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy");
			DateFormat dateFormat1 = new SimpleDateFormat("MM");
			Date date =new Date();
			
			String Year=dateFormat.format(date);
			String month=dateFormat1.format(date);
			
			// now copy the screenshot to desired location using copyFile method
			FileUtils.copyFile(src, new File(
					".\\src\\screenshot\\Date_"+Year +"_"+month+"\\error" + System.currentTimeMillis() + ".png"));
		} catch (IOException e)

		{
			System.out.println(e.getMessage());
		}
	}

	public static void main(String args[]) throws Exception {

		ConfigRead config = new ConfigRead();

		System.setProperty("webdriver.gecko.driver", config.getFirefox());

		WebDriver dirver = new FirefoxDriver();

		dirver.get(config.getApplicatonUrl());

		ScreenshotUtility screesnshots = new ScreenshotUtility();
		screesnshots.captureScreenShot(dirver);

		dirver.quit();

	}

}
