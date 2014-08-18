package net.ikenna

import org.scalatest.{FreeSpec, Matchers}

class DiscountTest extends FreeSpec with Matchers {

  "Discounts" - {

    "should get discount of 60p for 2 apples" in {
      Discount.getDiscount(Seq(Apple(), Apple())) should be(60)
    }

    "should get discount of 60p for 3 apples" in {
      Discount.getDiscount(Seq(Apple(), Apple(), Apple())) should be(60)
    }

    "should get discount of 120p when buying 4 apples" in {
      Discount.getDiscount(Seq(Apple(), Apple(), Apple(), Apple())) should be(120)
    }

    "should get discount of 0p for 2 oranges" in {
      Discount.getDiscount(Seq(Orange(), Orange())) should be(0)
    }

    "should get discount of 25p for 3 oranges" in {
      Discount.getDiscount(Seq(Orange(), Orange(), Orange())) should be(25)
    }

    "should get discount of 85p for 3 Oranges and 2 Apples" in {
      Discount.getDiscount(Seq(Orange(), Orange(), Orange(), Apple(), Apple())) should be(85)
    }

    "should get discount when input is not in order" in {
      Discount.getDiscount(Seq(Apple(), Orange(), Apple(), Orange(), Orange())) should be(85)
    }
  }

}
