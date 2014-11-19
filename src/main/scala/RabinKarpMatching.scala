package greedySDCH

import greedySDCH.Model.StringStatisticSet

object RabinKarpMatching {
  type HashValue = Int
  type Position = Int
  type PositionTable = scala.collection.mutable.Map[HashValue, scala.collection.mutable.ListBuffer[Position]]
  type CountTable = scala.collection.mutable.Map[HashValue, Int]
  lazy val base : Int = 2

  case class Context(countTable : CountTable, positionTable : PositionTable) {
    def add(hashValue : HashValue, position : Position) : Unit = {
      if (countTable.contains(hashValue)) {
        countTable(hashValue) += 1
        positionTable(hashValue).append(position)
      } else {
        countTable(hashValue) = 1
        positionTable(hashValue) = scala.collection.mutable.ListBuffer[Position](position)
      }
    }
  }

  def wellKnownString(values : StringStatisticSet) : String = {
    ???
  }

  def hash(str : String, len : Int, context : Context) : Context = {
    if (str.length < len) {
      context
    } else {
      var curHash : Int = 0
      var curPower = 1
      for (i <- len - 1 to 0 by -1) {
        curHash += str.charAt(i) * curPower
        if (i > 0) {
          curPower *= base
        }
      }

      context.add(curHash, 0)

      for (i <- len to str.length - 1) {
        curHash = (curHash - str.charAt(i - len) * curPower) * base + str.charAt(i)
        context.add(curHash, i - len + 1)
      }

      context
    }
  }
}
