@Verivox
Feature: To Select best Internet tariff for Verivox user
  
  AS A Verivox user
  I WANT TO use the DSL calculator and tariff search pages
  SO THAT I can select the best available internet tariff for my needs

  Scenario: Verify the DSL calculator
    Given that I can open "https://www.verivox.de/" in "Chrome"
    When I navigate to the DSL calculator page
    And I enter "030" for my area code
    And I select the "100" Mbit/s bandwidth option
    And I click the Jetzt vergleichen button
    Then I should see a page that lists the available tariffs for my selection

  Scenario: Load multiple tariff result pages
    Given I should see the total number of available tariffs listed in the Ermittelte Tarife section
    When I scroll to the end of the Result List page
    Then I should see only the first 20 tariffs displayed
    When I click on the button labeled 20 weitere Tarife laden
    Then I should see the next 20 tariffs displayed
    And I can continue to load any additional tariffs until all tariffs have been displayed

  Scenario: Verify offer details for a selected tariff
    Given I click on any Zum Angebot button to select a tariff offer
    Then I should see the corresponding offer page for the selected tariff
    And Close the browser