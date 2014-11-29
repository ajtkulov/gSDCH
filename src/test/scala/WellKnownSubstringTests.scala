package test

import greedySDCH.WellKnownSubstring
import greedySDCH.Model._
import org.scalatest.FunSuite

class WellKnownSubstringTests extends FunSuite {
  test("WellKnownSubstring") {
    val res = WellKnownSubstring.wellKnownString(StringStatisticSet(
      Seq[(String, Frequency, Id)](("ababab", 1, 1),
        ("cdcdcdcd", 1, 2),
//        ("qwrt", 100, 3),
        ("efef", 4, 4)
      )
    ))

    println(res)

    assert(res == "ef")
  }
}
