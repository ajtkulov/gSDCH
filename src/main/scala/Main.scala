package greedySDCH

object Main extends App {

  override def main(args : Array[String]) {
    var input = Examples.readInput()
    input = Examples.longestSubstring(input)(350)
    input = Examples.longestSubstring(input)(75)
    input = Examples.longestSubstring(input)(10)
//    Examples.longestSubstring(10)
//    Examples.longestSubstring(1)
//    Examples.wellKnownSubstring()
  }
}
