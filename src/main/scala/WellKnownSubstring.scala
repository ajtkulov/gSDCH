package greedySDCH

import greedySDCH.Model.{Id, Frequency, StringStatisticSet}

object WellKnownSubstring extends RabinKarpMatching {
  type Position = (Id, Int)

  def wellKnownString(values : StringStatisticSet) : String = {
    var bestLength : Int = 0
    var bestPosition : Position = (0, 0)
    var maxEffect : Int = 0

    val maxLength: Int = values.values.maxBy(x => x._1.length)._1.length

    for (len <- 1 to maxLength) {
      val context = newContext()
      for (struct: (String, Frequency, Id) <- values.values) {
        hash1(struct, len, context)
      }

      val max: (HashValue, Int) = context.countTable.maxBy(x => x._2)

      if (max._2 * len > maxEffect) {
        maxEffect = max._2 * len
        bestLength = len
        bestPosition = context.getBestPositions(0)
      }
    }

    values.getStringById(bestPosition._1).substring(bestPosition._2, bestPosition._2 + bestLength)
  }

  def hash1(struct : (String, Frequency, Id), len : Int, context : Context) : Context = {
    val str = struct._1
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

      context.add(curHash, (struct._3, 0), struct._2)

      for (i <- len to str.length - 1) {
        curHash = (curHash - str.charAt(i - len) * curPower) * base + str.charAt(i)
        context.add(curHash, (struct._3, i - len + 1), struct._2)
      }

      context
    }
  }
}
