package utimateqa_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class MultiBrowserTesting {

    static Scanner sc = new Scanner(System.in);

    static String baseUrl = "https://courses.ultimateqa.com/users/sign_in";

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Enter Browser name : " );
        String browser = sc.nextLine();

        if(browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        }else{
            System.out.println("Wrong browser name");
        }

//        2. Open URL

        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//        3. Print the title of the page

        System.out.println("Page title is: " +driver.getTitle());

//        4. Print the current url
        System.out.println("Current url is: " +driver.getCurrentUrl());

//        5. Print the page source

        System.out.println("Page Source is: " +driver.getPageSource());

//        6. Enter the email to email field

        WebElement email = driver.findElement(By.id("user[email]"));
        email.sendKeys("poonam123@gmail.com");

//        7. Enter the password to password field

        WebElement password = driver.findElement(By.id("user[password]"));
        password.sendKeys("Poonam5657");

        //hold screen

        Thread.sleep(2000);

//        8. Close the browser
        driver.close();

    }
}
