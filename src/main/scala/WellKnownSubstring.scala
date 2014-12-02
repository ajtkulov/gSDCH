package greedySDCH

import greedySDCH.Model._

object WellKnownSubstring extends RabinKarpMatching {
  type Position = (Id, Int)
  type Input = (String, Frequency, Id)

  def wellKnownString(values : StringStatisticSet) : String = {
    var bestLength : Int = 0
    var bestPosition : Position = (0, 0)
    var maxEffect : Int = 0

    val maxLength: Int = values.values.maxBy(x => x._1.length)._1.length

    for (len <- 1 to maxLength) {
      val context = newContext()
      for (struct <- values.values) {
        hash(struct, len, context)
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

  def getString(input: Input): String = input._1

  def getProfit(input: Input): Int = input._2

  override def getPosition(input: Input, shift: Int): Position = (input._3, shift)
}
