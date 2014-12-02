package greedySDCH

object Model {
  type Frequency = Int
  type Id = Int

  case class StringStatisticSet(values: Seq[(String, Frequency, Id)]) {
    def getStringById(id : Id) : String = values.filter(x => x._3 == id).head._1

    def removeSubString(value : String) : StringStatisticSet = {
      StringStatisticSet(values.map(x =>
      {
        val split = x._1.split(value)
        split.map(z => (z, x._2, x._3))
      }).flatten)
    }
  }
}