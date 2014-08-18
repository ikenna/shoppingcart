package net.ikenna

import org.scalatest.{FreeSpec, Matchers}

class InputParserTest extends FreeSpec with Matchers {

  "InputParser" - {

    "should return no Items for empty input " in {
      InputParser("") should be(Seq())
    }

    "should convert input string 'apple' to item Apple " in {
      InputParser("Apple") should be(Seq(Apple()))
    }

    "should convert input string 'orange' to item Orange " in {
      InputParser("orange") should be(Seq(Orange()))
    }

    "should return 3 Items for input 'apple apple orange' " in {
      InputParser("apple apple orange") should be(Seq(Apple(), Apple(), Orange()))
    }

    "should throw exception if input is unknown " in {
      intercept[UnknownItemException] {
        InputParser("unknown-item")
      }
    }

    "should handle extra spaces in input" in {
      InputParser("  Apple  ") should be(Seq(Apple()))
    }
  }

}
