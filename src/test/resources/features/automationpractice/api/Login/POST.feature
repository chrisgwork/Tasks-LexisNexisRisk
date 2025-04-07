@API
Feature: POST Login

  Background:
    * def random = Java.type('com.common.utils.core.data.helpers.MakeRandom');

  Scenario: JIRA-1036 - POST /verifyLogin - 200

    # Define replacement variables for those in the postTemplate
    * def newValueEmail = random.email()
    * def newValuePassword = random.word()

    * def postTemplate = read("classpath:data/templates/post/login.json")

    # Sending HTTP request
    * url automationPracticeUrlAPI
    * path "/verifyLogin"
    * header Content-Type = "application/json"
    * request postTemplate
    * method POST
    * status 200

    #  Assert response body
    * match response.responseCode = 200

    * assert responseTime < 5000