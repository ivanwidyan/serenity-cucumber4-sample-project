package com.ivanwidyan.module.ui.data;

import io.restassured.response.Response;
import org.openqa.selenium.JavascriptExecutor;

public class GooglePageData {

    private static String keyword;

    public static String getKeyword() {


        return keyword;
    }

    public static void setKeyword(String keyword) {
        GooglePageData.keyword = keyword;
    }
}
