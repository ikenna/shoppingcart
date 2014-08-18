package net.ikenna

import org.scalatest.{Matchers, FreeSpec}

class CheckoutSystemTest extends FreeSpec with Matchers {

  "Checkout System" - {

    "with no offers" - {

      val noOffers = Nil

      "should have a total of zero when empty" in {
        CheckoutSystem.getTotal(noOffers)("") should be(0)
      }

      "should give a total of 60p for 1 apple" in {
        CheckoutSystem.getTotal(noOffers)("Apple") should be(60)
      }

      "should give a total of 25p for 1 orange" in {
        CheckoutSystem.getTotal(noOffers)("Orange") should be(25)
      }

      "should give a total of 180p for 3 apples" in {
        CheckoutSystem.getTotal(noOffers)("Apple Apple Apple") should be(180)
      }

      "should give a total of 205p for input 'Apple, Apple, Orange, Apple' " in {
        CheckoutSystem.getTotal(noOffers)("Apple Apple Orange Apple ") should be(205)
      }

    }

    "with offers" - {

      val offers = AllOffers()

      "should get one free Apple for one purchased Apple" in {
        CheckoutSystem.getTotal(offers)("Apple Apple") should be(60)
      }

      "should pay 50p for 3 oranges" in {
        CheckoutSystem.getTotal(offers)("Orange Orange Orange") should be(50)
      }
    }
  }

}