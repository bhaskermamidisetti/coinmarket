@coinMarketApiTest
Feature: Ensure user register to Coin Markert and select the Filter

  As a customer
  I want to access the Coin Market
  So I can Register free account and  convert GBP to DogeCoins


  @coinMarketApiTest
  Scenario: Converting the prices using API calls in coinMarketCap
    Given Convert Guatemalan Quetzal to British pounds
    Then convert the amount received in GBP to doge coin