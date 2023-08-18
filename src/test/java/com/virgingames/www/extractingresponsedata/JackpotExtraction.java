package com.virgingames.www.extractingresponsedata;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;


public class JackpotExtraction {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://www.virgingames.com/api/jackpots";
        RestAssured.basePath = "/bingo";
        response = given()
                .queryParams("currency","GBP")
                .when()
                .get()
                .then().statusCode(200);

    }

    //   Extract the jackpotId
    @Test
    public void test01(){
        String jackpot = response.extract().path("data.jackpotId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of  : " + jackpot );
        System.out.println("------------------End of Test---------------------------");
    }

    //   Extract the name of 2nd Id
    @Test
    public void test02(){
        String nameOfId = response.extract().path("data.pots[1].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 2nd id is : " + nameOfId );
        System.out.println("------------------End of Test---------------------------");

    }

    //    Extract the amount of all the Id
    @Test
    public void test03(){
        List<String> amountOfId = response.extract().path("data.pots.amount");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The amount of all id are : " + amountOfId );
        System.out.println("------------------End of Test---------------------------");
    }

    //    Extract the currency of all the Id
    @Test
    public void test04(){
        List<String> currencyOfId = response.extract().path("data.pots.currency");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The currency of all Id are : " + currencyOfId );
        System.out.println("------------------End of Test---------------------------");
    }



    //    Get amount where id = 5323
    @Test
    public void test05(){
        Float amountOfId = response.extract().path("data.pots[3].amount");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Amount of id = 5323 : " + amountOfId );
        System.out.println("------------------End of Test---------------------------");
    }


    //    Find the currency of 3rd Id
    @Test
    public void test06(){
        List<String>currency = response.extract().path("data.pots[2].currency");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The currency of all 3rd Id is: " + currency);
        System.out.println("------------------End of Test---------------------------");
    }


}
