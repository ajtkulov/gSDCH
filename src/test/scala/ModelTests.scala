package test

import greedySDCH.Model.{Frequency, Id, StringStatisticSet}
import org.scalatest.FunSuite

class ModelTests extends FunSuite {
  test("ModelTest - 1") {
    val res = StringStatisticSet(Seq[(String, Frequency, Id)](("123456", 1, 1))).removeSubString("3")

    assert(res.values.toSet == Set[(String, Frequency, Id)](("12", 1, 1), ("456", 1, 1)))
  }

  test("ModelTest - 2") {
    val res = StringStatisticSet(Seq[(String, Frequency, Id)](("123456", 1, 1))).removeSubString("34")

    assert(res.values.toSet == Set[(String, Frequency, Id)](("12", 1, 1), ("56", 1, 1)))
  }

}
