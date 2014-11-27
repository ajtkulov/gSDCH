import greedySDCH.RabinKarpMatching
import greedySDCH.RabinKarpMatching._
import org.scalatest.FunSuite

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class RabinKarpMatchingTests extends FunSuite {

  test("RabinKarpMatchingTest - 1") {
    val context: Context = Context(mutable.Map[HashValue, Int](), mutable.Map[HashValue, ListBuffer[Position]]())
    RabinKarpMatching.hash("abab", 2, context)

    assert(context.countTable.keySet.size == 2)
  }

  test("RabinKarpMatchingTest - 2") {
    val context: Context = Context(mutable.Map[HashValue, Int](), mutable.Map[HashValue, ListBuffer[Position]]())
    RabinKarpMatching.hash("abcabc", 3, context)

    assert(context.countTable.keySet.size == 3)
  }

  test("RabinKarpMatchingTest - 3") {
    val res = RabinKarpMatching.commonSubstring("abcabc")

    assert(res == "abc")
  }
}
