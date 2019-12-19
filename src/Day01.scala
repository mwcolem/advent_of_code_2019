import scala.io.Source

object Day01 extends App {
  trait Part {
    def calculateFuel(mass: Int) : Int

    def calculateTotalFuel(masses: Seq[Int]): Int = masses.map(calculateFuel).sum
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
      .map(Part2.calculateFuel)
      .sum
  )

//  mass.foreach( singleMass =>
//    println(Part2.calculateFuel(singleMass))
//  )
}
