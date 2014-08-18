package net.ikenna

import org.scalatest.{Matchers, FreeSpec}

class CheckoutSystemTest extends FreeSpec with Matchers {

  "Checkout System" - {

    "should have a total of zero when empty" in {
      CheckoutSystem.getTotal() should be(0)
    }

    "should give a total of 60p for 1 apple" in {
      CheckoutSystem.getTotal("Apple") should be(60)
    }

    "should give a total of 25p for 1 orange" in {
      CheckoutSystem.getTotal("Orange") should be(25)
    }

    "should give a total of 120p for 2 apples" in {
      CheckoutSystem.getTotal("Apple Apple") should be(120)
    }

    "should give a total of 205p for input 'Apple, Apple, Orange, Apple' " in {
      CheckoutSystem.getTotal("Apple Apple Orange Apple ") should be(205)
    }
  }
}