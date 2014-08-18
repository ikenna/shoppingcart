package net.ikenna

object InputParser {

  def apply(input: String): Seq[Item] = {
    if (input == "") Nil else input.trim.split(" ").map(toItem)
  }

  private def toItem(input: String): Item = input.trim.toLowerCase match {
    case "apple" => Apple()
    case "orange" => Orange()
    case x => throw UnknownItemException(x)
  }
}

case class UnknownItemException(input: String) extends IllegalArgumentException( s"""Can't parse input: '${input}' """)
