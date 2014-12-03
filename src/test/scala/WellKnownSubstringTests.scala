package test

import greedySDCH.{FileUtils, WellKnownSubstring}
import greedySDCH.Model._
import org.scalatest.FunSuite

class WellKnownSubstringTests extends FunSuite {
  test("WellKnownSubstring") {
    val res = WellKnownSubstring.wellKnownString(StringStatisticSet(
      Seq[(String, Frequency, Id)](("ababab", 1, 1),
        ("cdcdcdcd", 1, 2),
        ("efef", 4, 4)
      )
    ))

    assert(res == "ef")
  }

  test("css") {
    var input = StringStatisticSet(
      Seq[(String, Frequency, Id)]((FileUtils.readFile("data/css/1.css"), 1, 1),
        (FileUtils.readFile("data/css/2.css"), 1, 2)
      ))

    for (i <- 1 to 10) {
      val res = WellKnownSubstring.wellKnownString(input, 5, 100)
      input = input.removeSubString(res)
      println(res)
    }
  }
}
