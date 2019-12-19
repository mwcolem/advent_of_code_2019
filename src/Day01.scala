import scala.io.Source

object Day01 extends App {
  trait Part {
    def calculateFuel(mass: Int) : Int
  }

  object Part1 extends Part {
    override def calculateFuel(mass: Int): Int = mass / 3 - 2
  }

  object Part2 extends Part {
    override def calculateFuel(mass: Int): Int = {
      Part1.calculateFuel(mass) match {
        case fuel if fuel <= 0 => 0
        case fuel if fuel > 0 => fuel + calculateFuel(fuel)
      }
    }
  }

  val masses = Source.fromFile("inputs/day01.txt")
    .getLines()
      .map(_.toInt)
      .toList

  println(
    masses
      .map(Part1.calculateFuel)
      .sum
  )

  println(
    masses
      .map(Part2.calculateFuel)
      .sum
  )
}
