package com.example.jetbrainstest.tests;

import com.example.jetbrainstest.pages.JuniePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;


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
    @DisplayName("Нажатие кнопки Download и переход на страницу скачивания")
    public void junieDownloadButton() {
        juniePage.junieDownloadButton();
        ArrayList<String> tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));

        juniePage.acceptCookiesOnNewPage();

        assertTrue(getDriver().getCurrentUrl().contains("26104-junie-the-ai-coding-agent-by-jetbrains"),
                "Ссылка не содержит ожидаемую часть");

        juniePage.getJunieButton();
        assertTrue(juniePage.isPluginVersionsTableDisplayed(),
                "Таблица с версиями плагина не отобразилась после нажатия кнопки GET");
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