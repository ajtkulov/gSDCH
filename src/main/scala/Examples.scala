package greedySDCH

import greedySDCH.Model._

object Examples {
  def wellKnownSubstring() = {
    var input = readInput()

    for (i <- 1 to 30) {
      val res = WellKnownSubstring.wellKnownSubstring(input, 5, 150)
      input = input.removeSubString(res)._1
      println(res)
    }
  }

  def longestSubstring(minFrequency : Int = 1) = {
    var input = readInput()

    var flag = true
    var rightBorder = Int.MaxValue
    var totalEconomy: Long = 0
    while (flag) {
      val res: Option[String] = LongestCommonSubstring.longestCommonSubstring(input, minFrequency, 4, rightBorder)
      res match {
        case Some(str) => {
          rightBorder = str.length;
          val r = input.removeSubString(str);
          input = r._1
          totalEconomy = totalEconomy + r._2

          println();
          println(str);
          println(s"length of pattern = ${str.length}");
          println(s"Set size = ${input.values.length}; Total length = ${input.values.map(x => x._1.length).sum}")
          println(s"Economy = ${r._2}; Total economy = ${totalEconomy}")
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
