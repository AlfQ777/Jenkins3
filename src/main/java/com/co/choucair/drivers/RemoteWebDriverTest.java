package com.co.choucair.drivers;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import java.net.URL;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.grid.Main;
import org.openqa.selenium.net.PortProber;
import org.openqa.selenium.remote.RemoteWebDriver;


public class RemoteWebDriverTest {
    static URL gridUrl;
    public static WebDriver driver;

    @BeforeEach
    public void startGrid() {
        gridUrl = startStandaloneGrid();
    }

    @Test
    public void uploads() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(gridUrl, options);
        driver.get("https://the-internet.herokuapp.com/upload");
        Thread.sleep(40000);
    }

    protected URL startStandaloneGrid() {
        int port = PortProber.findFreePort();
        System.out.println(port);
        try {
            Main.main(
                    new String[]{
                            "standalone",
                            "--port",
                            String.valueOf(port),
                            "--selenium-manager",
                            "true",
                            "--enable-managed-downloads",
                            "true",
                            "--log-level",
                            "WARNING"
                    });
            return new URL("http://localhost:" + port);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

}

