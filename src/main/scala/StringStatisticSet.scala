package greedySDCH

object Model {
  type Frequency = Int

  case class StringStatisticSet(values: Seq[(String, Int)]) {}
}