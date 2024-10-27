package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.RiderPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RiderPageTest extends BaseTest {
    private RiderPage rp;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/rider/");
        rp = new RiderPage(getDriver());
    }

    @Test
    @DisplayName("Проверка кликабельности кнопки перехода на главную страницу")
    public void mainPageButtonIsClickable() {
        Assertions.assertTrue(rp.checkIfMainPageButtonIsClickable(), "Кнопка перехода на главную страницу не активна");
    }

    @Test
    @DisplayName("Проверка нажатия на кнопку Download")
    public void secondDownloadButtonIsClickable() {
        rp.downloadSecondButtonClick();
        String currentUrl = getDriver().getCurrentUrl();
        Assertions.assertEquals("https://www.jetbrains.com/rider/download/#section=windows", currentUrl,
                "После клика на Download открывает не ту страницу");
    }

    @Test
    @DisplayName("Проверка нажатия на кнопку Docker")
    public void dockerButtonIsClickable() {
        rp.dockerButtonClick();
        String currentUrl = getDriver().getCurrentUrl();
        Assertions.assertEquals("https://www.jetbrains.com/guide/dotnet/tutorials/docker-dotnet/", currentUrl,
                "После клика на Docker открывает не ту страницу");
    }

    @Test
    @DisplayName("Проверка нажатия на кнопку Pricing")
    public void pricingButtonIsClickable() {
        rp.pricingButtonClick();
        String currentUrl = getDriver().getCurrentUrl();
        Assertions.assertEquals("https://www.jetbrains.com/rider/buy/?section=personal&billing=yearly", currentUrl,
                "После клика на Pricing открывает не ту страницу");
    }
}
