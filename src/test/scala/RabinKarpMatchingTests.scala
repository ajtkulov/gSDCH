import greedySDCH.RabinKarpMatching
import greedySDCH.RabinKarpMatching._
import org.scalatest.FunSuite

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class RabinKarpMatchingTests extends FunSuite {

  test("RabinKarpMatchingTest - 1") {
    val context: Context = Context(mutable.Map[HashValue, Int](), mutable.Map[HashValue, ListBuffer[Position]]())
    RabinKarpMatching.hash("abab", 2, context)

    println(context.countTable.mkString(", "))
    println(context.positionTable.mkString(", "))
  }
}
