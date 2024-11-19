package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.CareersPage;
import org.junit.jupiter.api.*;


public class CareersTest extends BaseTest {


    private CareersPage careersPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/careers/internships/");
        careersPage = new CareersPage(getDriver());
    }

    @Test
    @DisplayName("Проверка что кнопка кликабельна")
    public void buttonClickableCheck() {
        Assertions.assertTrue(careersPage.checkIfButtonIsClickable(), "Кнопка не кликабельна");
    }

    @RepeatedTest(5)
    @DisplayName("Проверка кнопки Find your internship")
    public void clickInternshipButtonTest() {
        careersPage.clickInternshipButton("https://internship.jetbrains.com/");
    }

    @Test
    @DisplayName("Проверка смены языка на русский")
    public void LanguageChangeToRussianTest() {
        String initialHeader = careersPage.getHeaderText();
        careersPage.switchToRussianLanguage();
        String russianHeader = careersPage.getHeaderText();
        Assertions.assertNotEquals(initialHeader, russianHeader, "Язык заголовка не сменился");

    }
}
