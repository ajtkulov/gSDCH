package greedySDCH

import greedySDCH.Model._

object Examples {
  def test() = {
    var input = StringStatisticSet(
      Seq[(String, Frequency, Id)](
        (FileUtils.readFile("data/css/1.css"), 1, 1),
        (FileUtils.readFile("data/css/2.css"), 1, 2)
      ))

    for (i <- 1 to 10) {
      val res = WellKnownSubstring.wellKnownString(input, 5, 150)
      input = input.removeSubString(res)
      println(res)
    }
  }
}
