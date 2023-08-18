package com.virgingames.www.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://www.virgingames.com/api/jackpots";
        RestAssured.basePath = "/bingo";
    }
}
