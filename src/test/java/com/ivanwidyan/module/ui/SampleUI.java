package com.ivanwidyan.module.ui;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

public class SampleUI extends PageObject {

  @FindBy(xpath = "//input[@name='q']")
  WebElementFacade searchBox;

  @FindBy(xpath = "//input[@value='Google Search']")
  WebElementFacade searchButton;

  public void openHomePage() {
    openUrl("https://www.google.com/");
  }

  public void doSearch(String value){
    searchBox.click();
    searchBox.typeAndEnter(value);
//    searchBox.sendKeys(Keys.ENTER);
  }
}