package greedySDCH

object Model {
  type Frequency = Int
  type Id = Int

  case class StringStatisticSet(values: Seq[(String, Frequency, Id)]) {
    def getStringById(id : Id) : String = values.filter(x => x._3 == id).head._1
  }
}