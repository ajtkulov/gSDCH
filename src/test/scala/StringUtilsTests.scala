package test

import greedySDCH.StringUtils
import org.scalatest.FunSuite

class StringUtilsTests extends FunSuite {
  test("StringUtilsTest - 1") {
    assert(StringUtils.split("1 2 3 4 5 6", " ").deep == Array("1", "2", "3", "4", "5", "6").deep)
  }

  test("StringUtilsTest - 2") {
    assert(StringUtils.split(" 1 2 3 4 5 6 ", " ").deep == Array("1", "2", "3", "4", "5", "6").deep)
  }

  test("StringUtilsTest - 3") {
    assert(StringUtils.split("123456", "34").deep == Array("12", "56").deep)
  }
}
