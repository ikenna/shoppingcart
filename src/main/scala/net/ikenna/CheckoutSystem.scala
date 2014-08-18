package net.ikenna

object CheckoutSystem {
  def getTotal(items: String = ""): Int = InputParser(items).map(_.price).sum
}

