package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.JuniePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JuniePageTest extends BaseTest {
    private JuniePage JuniePage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/junie/#");
        JuniePage juniePage = new JuniePage(getDriver());
    }

    @Test
    @DisplayName("Проверка нажатия кнопки Download")
    public void junieDownloadButton() {
        JuniePage.junieDownloadButton();
        assertEquals("https://www.jetbrains.com/junie/#", getDriver().getCurrentUrl(), "не верная ссылка");
    }

    @Test
    @DisplayName("Проверка нажатия кнопки 'загрузка'")
    public void installJunieButton() {
        JuniePage.installJunieButton();
        assertEquals("https://plugins.jetbrains.com/plugin/26104-jetbrains-junie", getDriver().getCurrentUrl(), "не верная ссылка");
    }
}


