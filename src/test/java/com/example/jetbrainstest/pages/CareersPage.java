package com.example.jetbrainstest.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CareersPage {
    WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "header button[data-test='language-picker']")
    private WebElement languageList;
    @FindBy(xpath = "//span[contains(text(), 'Русский')]")
    private WebElement russianLanguageButton;
    @FindBy(css = "h1.rs-h1")
    private WebElement header;
    @FindBy(css = "a[data-test='button']._main_18aw4si_56")
    private WebElement internshipButton;

    public boolean isButtonClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(internshipButton));
        return true;
    }

    public void clickInternshipButton(String expectedUrl) {
        internshipButton.click();
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Открыта страница: " + actualUrl);
        Assertions.assertEquals(actualUrl, expectedUrl, "Страницы не существует");
    }

    public void switchToRussianLanguage() {
        languageList.click();
        russianLanguageButton.click();
    }

    public String getHeaderText() {
        return header.getText();
    }

    public CareersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }
}
