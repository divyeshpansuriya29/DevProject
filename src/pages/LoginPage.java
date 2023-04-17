package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	/*
	WebElement email = driver.findElement(By.name("usernameInput"));
	WebElement password = driver.findElement(By.name("password"));
	WebElement globalErr = driver.findElement(By.xpath("//span[text()='Please enter a username or card number without special characters.']"));
	WebElement empatyEmailErr = driver.findElement(By.xpath("//span[text()='Please enter your username or card number.']"));
	WebElement emptyPasswordErr = driver.findElement(By.xpath("//span[text()='Please enter your password.']"));
	*/
	
	@FindBy(name = "usernameInput")
	public WebElement email ;
	
	@FindBy(name = "password")
	public WebElement password;
	
	@FindBy(xpath= "//span[text()='Please enter a username or card number without special characters.']")
	public WebElement globalErr;
	
	@FindBy(xpath = "//span[text()='Please enter your username or card number.']")
	public WebElement empatyEmailErr;
	
	@FindBy(xpath = "//span[text()='Please enter your password.']")
	public WebElement emptyPasswordErr;
	
	public void openBrowser() {
		System.setProperty("webdriver.gecko.driver", "/Users/divyeshpansuriya/Desktop/Divyesh QA Practice/Selenium Jars/geckodriver");
		  driver = new FirefoxDriver();
	}
	
	public void openLogin() {
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=fzjKqbYe-84&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiZnpqS3FiWWUtODQiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY3NzM2MTkxMywiaWF0IjoxNjc3MzYwNzEzLCJqdGkiOiI1MjM4ZDNkZi1kNzZjLTQ2Y2YtOWI4Ny0wMjBiOTMxMWFjZTYiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.kuSNp8Hi4X2Urparqklj6rPoUzl5uXXaXkMCPCJehwEkeG_nDXyU38dQifJ5lO_Zi5AwF-Cjonbb05h_R82W23IO36E_PrEP6OySZk0kRQBfTKKVnktGiju5kn8KgiN7S3zLLB8tzo70RcBLvY86TdIAp0rCsP9qelIbfbYjw4uYWnyxvt6x9Wc6g2txZPNQNYSwOFSfSV_YEJ5VQl0mQtzBAoKVI_3I6MEYqjz-5c-NPVY2IdbLbwTUyRSJqrzl8ddKaQXkg4PyhEi9GWl1EBj-rVeUHBpCD6f4WMIqR3UsDTsmJaDcUJz0xmVo3Jct8TmeyFiYoVZ5j4VNkbUEPQ&preferred_environment=");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  
		  PageFactory.initElements(driver, this);
		  
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void login(String a, String b) throws InterruptedException {
		  email.sendKeys(a);
		  password.sendKeys(b, Keys.ENTER);
		  Thread.sleep(2000);
	}
	
	public String globalErr() {
		String ErrMsg = globalErr.getText();
		System.out.println(ErrMsg);
		return ErrMsg;
		
	}
	
	public String EmpatyEmailErr() {
		String ErrMsg = empatyEmailErr.getText();
		System.out.println(ErrMsg);
		return ErrMsg;
	}
	
	public String EmptyPasswordErr() {
		String ErrMsg = emptyPasswordErr.getText();
		System.out.println(ErrMsg);
		return ErrMsg; 
	}
	
	public String SpecialCharErr() {
		String ErrMsg = driver.findElement(By.xpath("//span[text()='Please enter a username or card number without special characters.']")).getText();
		System.out.println(ErrMsg);
		return ErrMsg; 
	}

}
