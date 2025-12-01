package com.example.jetbrainstest.pages;
//URL https://www.jetbrains.com/junie/#

import com.example.jetbrainstest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;

import static com.example.jetbrainstest.tests.BaseTest.getDriver;

public class JuniePage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(JuniePage.class));
    WebDriver driver;

    @FindBy(xpath = "//a[contains(@href, '/idea/download/')]")
    public WebElement clickDownloadButton;

    @FindBy(xpath = "//div[@id='download-block']//button[@data-test='dropdown-trigger']")
    public WebElement clickGetJunieButton;

    @FindBy(xpath = "//button[contains(text(), 'Accept') or contains(text(), 'Принять')]")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//ul[@data-test='dropdown-menu']")
    private WebElement downloadDropdownList;

    @FindBy(xpath = "//a[contains(@href, 'junie-github')]")
    private WebElement junieGit;

    @FindBy(xpath = "//a[contains(@href, 'join-waitlist')]")
    private WebElement signUp;

    public void clickDownloadButton() {
        LOG.infoWithScreenshot("Нажатие кнопки Download");
        clickDownloadButton.click();
    }

    public void clickGetJunieButton() {
        LOG.info("Нажатие кнопки GET");
        clickGetJunieButton.click();
    }

    public JuniePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void acceptCookiesOnNewPage() {
        LOG.info("Проверка модального окна с куки");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
        acceptCookiesButton.click();
    }

    public boolean isDownloadDropdownListDisplayed() {
        LOG.infoWithScreenshot("Проверка отображения выпадающего списка загрузки");
        return downloadDropdownList.isDisplayed();
    }

    public void junieGit() {
        LOG.infoWithScreenshot("Нажатие кнопки Junie in GitHub");
        junieGit.click();
    }

    public boolean signUp() {
        LOG.info("Проверка переключения на GitHub");
        return signUp.isDisplayed();
    }

    public void goNewTab() {
        LOG.info("Открытие следующей вкладки");
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
    }
}