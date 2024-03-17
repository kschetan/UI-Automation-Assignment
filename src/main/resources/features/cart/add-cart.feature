@functional
Feature: Adding items to cart

  Background:
    Given I am on amazon home page

  @sanity
  Scenario Outline: Adding a "<item-name>" into Cart and verifying the sub total 
    Given I Search for an item "<item-name>" and press enter
    When I Select the "<item-order>" item from the result page
    And I navigate to the product page and capture the "<item-name>" product price 
    And I add the item to the cart by clicking on Add to Cart button
    And I open the Cart by clicking the top-right cart icon
    Then I validate the sub total amount from cart with "<item-name>" product page price
    
    Examples: 
      | item-name |item-order|
      | Monitor   |1    |
      | Laptop    |2    |

  #@smoke
  #Scenario Outline: Adding two items into Cart and verifying the sub total
  #  Given I Search for item "<item-name-1>" and press enter
  #  When I Select the "<item1-order>" item from the result page
 #   And I navigate to the product page and capture the product price
  #  And I add the item to cart by clicking on Add to Cart
 #   And I Search for item "<item-name-2>" and press enter
 #   And I Select the "<item2-order>" in the List Product Page
 #   And I add the item to cart by clicking on Add to Cart
 #   And I open Cart from the top-left
 #   Then I validate the price on "<item-name-1>" is identical to the product page
 #   And I validate the price on "<item-name-2>" is identical to the product page
  #  And Validate that the sub total is identical to the product page

 #   Examples: 
 #     | item-name-1 | item-name-2 |item1-order|item1-order|
  #    | Headphone   | Keyboard    |1     |1  |