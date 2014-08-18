package net.ikenna

abstract class Item(val price: Int)

case class Orange() extends Item(25)
case class Apple() extends Item(60)


