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

  def longestSubstring(minFrequency : Int = 1) = {
    var input = readInput()

    var flag = true
    var rightBorder = Int.MaxValue
    while (flag) {
      val res = LongestCommonSubstring.longestCommonSubstring(input, minFrequency, 4, rightBorder)
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
    val files: Array[(String, Int)] = FileUtils.filesInDirectory("data")
      .filter(x => x.isFile && (x.getName.contains(".css") || x.getName.contains(".js")))
      .map(x => x.getAbsolutePath)
      .zipWithIndex

    StringStatisticSet(files.map((x : (String, Int)) => (FileUtils.readFile(x._1), 1, x._2)))
  }
}
