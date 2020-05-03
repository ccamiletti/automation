package com.automation;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Event {

	public static void main(String[] args) throws InterruptedException {
		
		String chromeDriverURL = System.getenv("CHROME_DRIVER");
		System.setProperty("webdriver.chrome.driver", chromeDriverURL);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://web.microsoftstream.com/");
		driver.manage().window().maximize();
		System.out.println("Connecting to microsoftstream");
		Thread.sleep(2000);
		//email
		driver.findElement(By.id("i0116")).sendKeys("generico@azurtech.cl");		
		//continue
		Thread.sleep(1000);
		driver.findElement(By.id("idSIButton9")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("i0118")).sendKeys("Qaf45021");
		System.out.println("Loggin...");
		//continue
		Thread.sleep(1000);
		driver.findElement(By.id("idSIButton9")).click();
		//continue
		Thread.sleep(1000);
		driver.findElement(By.id("KmsiCheckboxField")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("idBtn_Back")).click();
		Thread.sleep(2000);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date()); 
		System.out.println("Ceating Event named: " + "Event-".concat(date));
		driver.get("https://web.microsoftstream.com/create");
		Thread.sleep(2000);
		driver.findElement(By.name("uploadtitle")).sendKeys("Event-".concat(date));
		Thread.sleep(1000);
		driver.findElement(By.name("uploaddescription")).sendKeys("event description");
		
		Thread.sleep(1000);
		Select lenguage = new Select(driver.findElement(By.id("videolanguage")));
		lenguage.selectByVisibleText("Español");
		System.out.println("Lenguage Selected: Espanol");

		WebElement admin = driver.findElement(By.name("eventstartoptionsdropdown"));
		Thread.sleep(1000);
		
		WebElement admin2 = admin.findElement(By.className("selector"));
		Thread.sleep(1000);
		admin2.click();
		WebElement textDemo = driver.findElement(By.xpath("//span[text()='Tan pronto como el codificador esté conectado (ahora)']"));
		textDemo.click();
		Thread.sleep(1000);
		WebElement permissions = driver.findElement(By.id("preCreationVideoId-permissions-header"));
		permissions.click();

		try {
			Thread.sleep(1000);
			WebElement dropdown = driver.findElement(By.xpath("//div[text()='Mis grupos']"));
			dropdown.click();

			Thread.sleep(1000);
			dropdown = driver.findElement(By.xpath("//span[text()='Canales']"));
			dropdown.click();

			Thread.sleep(1000);
			dropdown = driver.findElement(By.className("search-row"));
			dropdown.click();

			Thread.sleep(1000);
			dropdown = driver.findElement(By.xpath("//input[@placeholder='Buscar canales']"));
			dropdown.sendKeys("unicornio");
			System.out.println("Selecting channel...: Unicornio");
			Thread.sleep(1000);
			dropdown = driver.findElement(By.xpath("//span[text()='Necropsia']"));
			dropdown.click();

			Thread.sleep(1000);
			WebElement saveButton = driver.findElement(By.xpath("//button[@aria-label='Guardar']")); //driver.find_element_by_xpath(//button[@label='Guardar'])
			saveButton.click();			
			System.out.println("Saving Event...");
			Thread.sleep(2000);
			WebElement config = driver.findElement(By.xpath("//div[text()='Configurar manualmente']"));			
			config.click();

			Thread.sleep(1000);
			dropdown = driver.findElement(By.xpath("//span[text()='Wirecast S']"));
			dropdown.click();

			Thread.sleep(2000);
			dropdown = driver.findElement(By.linkText("Inicie"));
			
			String href = dropdown.getAttribute("href");
			
			Thread.sleep(1000);
			
			Runtime runTime = Runtime.getRuntime();
            String executablePath = System.getenv("WIRECAST"); //"C:/Program Files/Telestream/Wirecast S/WirecastS.exe";  
            Process process = runTime.exec(executablePath);
			System.out.println("Openning Wirecast S...");
            driver.close();
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
