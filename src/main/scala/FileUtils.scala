package greedySDCH

import scala.io.Source

object FileUtils {
  def readFile(fileName : String) : String = {
    Source.fromFile(fileName).getLines().mkString("\n")
  }
}
