package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.MyExtension;
import com.example.jetbrainstest.pages.JuniePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyExtension.class)
public class JuniePageTest extends BaseTest {
    private JuniePage juniePage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/junie/#");
        juniePage = new JuniePage(getDriver());
    }

    @Test
    @DisplayName("Нажатие кнопки Download и переход на страницу скачивания, проверка выпадающего списка загрузки")
    public void clickDownloadButton() {
        juniePage.clickDownloadButton();
        assertTrue(getDriver().getCurrentUrl().contains("/idea/download/"),
                "Ссылка не содержит ожидаемую часть");
        juniePage.acceptCookiesOnNewPage();
        juniePage.clickGetJunieButton();
        assertTrue(juniePage.isDownloadDropdownListDisplayed(),
                "Выпадающий список с вариантами загрузки не отобразился после нажатия кнопки");
    }

    @Test
    @DisplayName("Нажатие кнопки Juine in Github")
    public void JunieGit() {
        juniePage.junieGit();
        juniePage.acceptCookiesOnNewPage();
        assertTrue(juniePage.signUp(),
                "переключение на junie-github не произошло");
    }
}