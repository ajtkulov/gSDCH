package greedySDCH

object Model {
  type Frequency = Int
  type Id = String

  case class StringStatisticSet(values: Seq[(String, Frequency, Id)]) {}
}