package com.ivanwidyan.module.ui;

import com.ivanwidyan.module.ui.data.GooglePageData;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://www.google.com")
public class GooglePage extends PageObject {

  @FindBy(xpath = "//input[@name='q']")
  WebElementFacade searchBox;

  @FindBy(xpath = "//input[@value='Google Search']")
  WebElementFacade searchButton;

  @FindBy(xpath = "//div[@class='srg']//h3")
  List<WebElementFacade> searchData;

  public void doSearch(){
    searchBox.click();
    searchBox.typeAndEnter(GooglePageData.getKeyword());
  }

  public List<String> getSearchData() {
    List<String> list = new ArrayList<>();
    for (int i = 0; i < searchData.size(); i++) {
      list.add(searchData.get(i).getText());
    }
    return list;
  }

  public void openHomePage() {
    openUrl("https://www.google.com/");
  }
}