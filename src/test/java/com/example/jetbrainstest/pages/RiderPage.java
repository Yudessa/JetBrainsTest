package com.example.jetbrainstest.pages;

// https://www.jetbrains.com/rider/

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class RiderPage {
    private final Logger LOG = LoggerFactory.getLogger(RiderPage.class);
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='rider-download-button__wrapper']//a[@href='/rider/download/']")
    public WebElement secondButtonDownloadRider;

    @FindBy(xpath = "//div//a[@href='/']")
    public WebElement mainPageButton;

    @FindBy(xpath = "//div//a[contains(@href, '/docker-dotnet/')]")
    public WebElement dockerButton;

    @FindBy(xpath = "//a[contains(@class, 'menu-item')]//span[contains(text(), 'Pricing')]")
    public WebElement pricingButton;

    public Boolean checkIfMainPageButtonIsClickable(){
        LOG.info("Кнопка перехода на главную страницу активна");
        return mainPageButton.isEnabled();
    }
    @Step("Средняя кнопка Download кликабельна")
    public void downloadSecondButtonClick(){
        LOG.info("Средняя кнопка Download кликабельна");
        secondButtonDownloadRider.click();
    }
    @Step("Кнопка Docker кликабельна")
    public void dockerButtonClick(){
        LOG.info("Кнопка Docker кликабельна");
        dockerButton.click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
        LOG.info("Переключились на новую вкладку с Docker");
    }
    @Step("Кнопка Pricing кликабельна")
    public void pricingButtonClick(){
        LOG.info("Кнопка Pricing кликабельна");
        pricingButton.click();
    }

    public RiderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
