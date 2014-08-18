package net.ikenna


object CheckoutSystem {
  def getTotal(offers: Seq[Offer] = AllOffers())(itemsInput: String = ""): Int = {
    val items = InputParser(itemsInput)
    val total = items.map(_.price).sum
    val discount = Discount.getDiscount(items, offers)
    total - discount
  }
}


