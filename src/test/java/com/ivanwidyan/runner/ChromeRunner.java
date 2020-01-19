package com.ivanwidyan.runner;

import com.ivanwidyan.module.ui.SampleUI;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class ChromeRunner {

    // chrome, firefox, appium, remote
    @Managed(driver = "chrome")
    WebDriver driver;

    private SampleUI sampleUI;

    @Test
    public void searchGoogleChrome() {
        sampleUI.openHomePage();
        sampleUI.doSearch("Food");
    }
}
