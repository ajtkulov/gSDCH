package greedySDCH

object Model {
  type Frequency = Int
  type Id = Int

  case class StringStatisticSet(values: Seq[(String, Frequency, Id)]) {
    def getStringById(id : Id) : String = values.filter(x => x._3 == id).head._1

    def removeSubString(value : String) : StringStatisticSet = {
      StringStatisticSet(values.map(x => {
        val split = StringUtils.split(x._1, value)
        split.map(z => (z, x._2, x._3))
      }).flatten)
    }

    def toOneString : StringStatisticSet = {
      StringStatisticSet(Seq[(String, Frequency, Id)]((values.map(x => x._1).mkString("\n"), 1, 1)))
    }

    override def toString : String = {
      s"size = ${values.length.toString}"
//      values.map(x =>
//        s"""Part: freq = ${x._2}; id = ${x._3}; length = ${x._1.length}
//           |${x._1.take(128)}""".stripMargin).mkString("\n")
    }
  }
}