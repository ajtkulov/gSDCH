package greedySDCH

object Model {
  type Frequency = Int
  type Id = Int

  case class StringStatisticSet(values: Seq[(String, Frequency, Id)]) {
    def getStringById(id : Id) : String = values.filter(x => x._3 == id).head._1

    def removeSubString(value : String) : (StringStatisticSet, Long) = {
      val size = values.size
      val flatten: Seq[((String, Frequency), Int)] = values.map(x => {
        val split: Array[String] = StringUtils.split(x._1, value)
        split.map(z => (z, x._2))
      }).flatten.zipWithIndex
      val set: StringStatisticSet = StringStatisticSet(flatten.map(x => (x._1._1, x._1._2, x._2)))
      (set, value.length * (set.values.size - size))
    }

    def toOneString : StringStatisticSet = {
      StringStatisticSet(Seq[(String, Frequency, Id)]((values.map(x => x._1).mkString("\n"), 1, 1)))
    }
  }
}