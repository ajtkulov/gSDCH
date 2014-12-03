package test

import greedySDCH.RabinKarpMatching
import greedySDCH.RabinKarpMatching._
import org.scalatest.FunSuite

class RabinKarpMatchingTests extends FunSuite {

  test("RabinKarpMatchingTest - 1") {
    val context: Context = RabinKarpMatching.newContext()
    RabinKarpMatching.hash("abab", 2, context)

    assert(context.countTable.keySet.size == 2)
  }

  test("RabinKarpMatchingTest - 2") {
    val context: Context = RabinKarpMatching.newContext()
    RabinKarpMatching.hash("abcabc", 3, context)

    assert(context.countTable.keySet.size == 3)
  }

  test("RabinKarpMatchingTest - 3") {
    val res = RabinKarpMatching.longestCommonSubstring("abcabc")

    assert(res == "abc")
  }

  test("RabinKarpMatchingTest - 4") {
    val res = RabinKarpMatching.longestCommonSubstring("webkit-transitionsdnflksd hjoiewrj oir woeihwehroi wehorhjweo rjowewebkit-transition")

    assert(res == "webkit-transition")
  }
}
