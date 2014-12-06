package greedySDCH

import greedySDCH.Model._

object Examples {
  def wellKnownSubstring() = {
    var input = readInput()

    for (i <- 1 to 30) {
      val res = WellKnownSubstring.wellKnownSubstring(input, 5, 150)
      input = input.removeSubString(res)
      println(res)
    }
  }

  def longestSubstring() = {
    var input = readInput()

    var flag = true
    var rightBorder = Int.MaxValue
    while (flag) {
      val res = LongestCommonSubstring.longestCommonSubstring(input, 4, rightBorder)
      res match {
        case Some(str) => {
          rightBorder = str.length;
          input = input.removeSubString(str);

          println();
          println(str);
          println(str.length);
          println(s"Size = ${input.values.length}; Total lenght = ${input.values.map(x => x._1.length).sum}")
        }
        case None => flag = false
      }
    }
  }

  def readInput(): StringStatisticSet = {
    StringStatisticSet(
      Seq[(String, Frequency, Id)](
        (FileUtils.readFile("data/css/1.css"), 1, 1),
        (FileUtils.readFile("data/css/2.css"), 1, 2)
      ))
  }
}
