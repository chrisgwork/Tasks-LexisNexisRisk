@API
Feature: GET Product

  Scenario: GET /productList - 200

    # Sending HTTP request
    * url automationPracticeUrlAPI
    * path "/productsList"
    * method GET
    * status 200

    #  Assert response body
    * match response.responseCode == 200

    * match response.products[0].id == 1
    * match response.products[0].name == "Blue Top"
    * match response.products[0].price == "Rs. 500"
    * match response.products[0].brand == "Polo"
    * match response.products[0].category.usertype.usertype == "Women"
    * match response.products[0].category.category == "Tops"

    * assert responseTime < 5000