package com.example.jetbrainstest.pages;
//URL https://www.jetbrains.com/junie/#

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class JuniePage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(JuniePage.class));
    WebDriver driver;

    @FindBy(xpath = "//a[contains(@href, '26104-jetbrains-junie-eap')]")
    public static WebElement junieDownloadButton;

    @FindBy(xpath = "//button[contains(@class, 'test_download_plugin_button')]")
    public static WebElement installJunieButton;

    public void junieDownloadButton() {
        LOG.info("Проверка кликабельности кнопки Download");
        junieDownloadButton.click();
    }

    public void installJunieButton() {
        LOG.info("Проверка кликабельности кнопки Install to IDE");
        installJunieButton.click();
    }

    public JuniePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
