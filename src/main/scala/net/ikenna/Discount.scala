package net.ikenna

object Discount {
  def getDiscount(items: Seq[Item], offers: Seq[Offer] = AllOffers()): Int = {
    val itemsGroupedByType = items.groupBy(i => i)
    offers.flatMap {
      offer => itemsGroupedByType.get(offer.item).map(getOfferDiscount(offer, _))
    }.sum
  }

  private def getOfferDiscount(offer: Offer, items: Seq[Item]): Int = {
    val numDiscountsToApply = math.floor(items.size / offer.count).toInt
    numDiscountsToApply * offer.discount
  }
}
