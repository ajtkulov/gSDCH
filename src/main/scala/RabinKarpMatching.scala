package greedySDCH

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

trait RabinKarpMatching {
  type HashValue = Int
  type Position
  type PositionTable = scala.collection.mutable.Map[HashValue, scala.collection.mutable.ListBuffer[Position]]
  type CountTable = scala.collection.mutable.Map[HashValue, Int]
  lazy val base : Int = 10

  case class Context(countTable : CountTable, positionTable : PositionTable) {
    def add(hashValue : HashValue, position : Position, profit : Int = 1) : Unit = {
      if (countTable.contains(hashValue)) {
        countTable(hashValue) += profit
        positionTable(hashValue).append(position)
      } else {
        countTable(hashValue) = profit
        positionTable(hashValue) = scala.collection.mutable.ListBuffer[Position](position)
      }
    }

    def getBestPositions : ListBuffer[Position] = {
      val pair: (HashValue, Int) = countTable.maxBy(x => x._2)
      positionTable(pair._1)
    }
  }

  def newContext() : Context = Context(mutable.Map[HashValue, Int](), mutable.Map[HashValue, ListBuffer[Position]]())
}

object RabinKarpMatching extends RabinKarpMatching {
  type Position = Int

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

  def commonSubstring(str : String) : String = {
    var bestLength : Int = 0
    var bestShift : Int = 0
    var maxEffect : Int = 0

    for (len <- 1 to str.length) {
      val context = newContext()
      hash(str, len, context)
      val max: (HashValue, Int) = context.countTable.maxBy(x => x._2)

      if (max._2 * len > maxEffect) {
        maxEffect = max._2 * len
        bestLength = len
        bestShift = context.getBestPositions(0)
      }
    }

    str.substring(bestShift, bestShift + bestLength)
  }
}