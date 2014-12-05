package test

import greedySDCH.Model.{Frequency, Id, StringStatisticSet}
import org.scalatest.FunSuite

class ModelTests extends FunSuite {
  test("ModelTest - 1") {
    val res = StringStatisticSet(Seq[(String, Frequency, Id)](("123456", 1, 1))).removeSubString("3")

    assert(res.values.toSet == Set[(String, Frequency, Id)](("12", 1, 0), ("456", 1, 1)))
  }

  test("ModelTest - 2") {
    val res = StringStatisticSet(Seq[(String, Frequency, Id)](("123456", 1, 1))).removeSubString("34")

    assert(res.values.toSet == Set[(String, Frequency, Id)](("12", 1, 0), ("56", 1, 1)))
  }

  test("ModelTest - 3") {
    val res = StringStatisticSet(Seq[(String, Frequency, Id)](("587263491828370985912649817485691237916498127307561274930", 1, 1))).removeSubString("1")

    assert(res.values.toSet == Set[(String, Frequency, Id)](("58726349", 1, 0), ("8283709859", 1, 1), ("26498", 1, 2), ("748569", 1, 3), ("2379", 1, 4), ("6498", 1, 5), ("2730756", 1, 6), ("274930", 1, 7)))
  }
}
