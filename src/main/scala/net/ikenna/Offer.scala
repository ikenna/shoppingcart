package net.ikenna

abstract class Offer(val item: Item, val count: Int, val discount: Int)

case class AppleOffer() extends Offer(Apple(), count = 2, discount = 60)

case class OrangeOffer() extends Offer(Orange(), count = 3, discount = 25)

object AllOffers {
  def apply() = Seq(AppleOffer(), OrangeOffer())
}

