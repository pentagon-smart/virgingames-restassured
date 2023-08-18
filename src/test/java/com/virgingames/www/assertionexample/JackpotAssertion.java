package com.virgingames.www.assertionexample;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasKey;


public class JackpotAssertion {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://www.virgingames.com/api/jackpots";
        RestAssured.basePath = "/bingo";
        response = given()
                .queryParams("currency", "GBP")
                .when()
                .get()
                .then().statusCode(200);
    }

    //  Verify the if the jackpotId is equal to Bingo
    @Test
    public void test01() {
        response.body("data.jackpotId", equalTo("Bingo"));
    }

    //  Check the single ‘Name’ in the Array list (5323)
    @Test
    public void test02() {
        response.body("data.pots[2].name", hasItem("CloudVGN"));
    }


    //  VCheck the Name 'virgingamessession' is available in List of pot's name
    @Test
    public void test03() {
        response.body("data.pots[0].name", hasItem("virgingamessession"));
    }

    //   Verify the amount = 6156.5 of first id
    @Test
    public void test04() {
        response.body("data.pots[0].amount", hasKey(6171.78));
    }

    //   Verify the id name = CloudVGN of currency is GBP
    @Test
    public void test05() {
        response.body("data.pots[2].currency", hasKey("GBP"));
    }


}
