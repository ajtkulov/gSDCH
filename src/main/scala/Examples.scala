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

  def longestSubstring(values : StringStatisticSet)(minFrequency : Int = 1): StringStatisticSet = {
    var input = values

    var totalEconomy: Long = 0
    var idx: Int = 0

    for (length <- 50 to 5 by -1) {
      var res = LongestCommonSubstring.find(input, length, minFrequency)
      while (res.isDefined) {
        val str = res.get
        val r = input.removeSubString(str);
        input = r._1
        totalEconomy = totalEconomy + r._2

        println(s"Pattern id=${idx}")
        idx = idx + 1
        println(str)
        println(s"length of pattern = ${str.length}")
        println(s"Set size = ${input.values.length}; Total length = ${input.values.map(x => x._1.length).sum}")
        println(s"Economy = ${r._2}; Total economy = ${totalEconomy}")
        res = LongestCommonSubstring.find(input, length, minFrequency)
      }
    }

    input
  }

  def readInput(): StringStatisticSet = {
    val files: Array[(String, Int)] = FileUtils.filesInDirectory("data")
      .filter(x => x.isFile && (x.getName.contains(".css") || x.getName.contains(".js")))
      .map(x => x.getAbsolutePath)
      .zipWithIndex

    StringStatisticSet(files.map((x : (String, Int)) => (FileUtils.readFile(x._1), 1, x._2)))
  }
}
