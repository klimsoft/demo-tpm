package com.example.demotpm;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.Duration;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SystemTestWithSelenium {

    private WebDriver driver;

    private static ConfigurableApplicationContext applicationContext;

    @BeforeAll
    public static void setupClass() throws Exception {
        SpringApplication app = new SpringApplication(DemoTpmApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8080"));
        applicationContext = app.run();
    }

    @AfterAll
    public static void tearDownClass() {
        applicationContext.stop();
    }

    @BeforeEach
    public void setUp() {
        //You can find chrome webdriver here: https://sites.google.com/chromium.org/driver/?pli=1
//        System.setProperty("webdriver.chrome.driver", "/Users/kamil/Downloads/chromedriver_mac64_113/chromedriver113");
//        driver = new ChromeDriver();
        //https://github.com/mozilla/geckodriver/releases
        System.setProperty("webdriver.gecko.driver", "/Users/kamil/Downloads/geckodriver2");
        driver = new FirefoxDriver();

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testHelloPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get("http://localhost:8080/");

        WebElement input = driver.findElement(By.id("name"));
        input.sendKeys("Peter");

        WebElement submit = driver.findElement(By.id("submitButton"));
        submit.click();

        WebElement message = driver.findElement(By.id("response"));
        String actualMessage = message.getText();

        //TODO for better presentation
//        try {
//            Thread.sleep(8000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        assertEquals("Hello Peter!", actualMessage);
    }
}
