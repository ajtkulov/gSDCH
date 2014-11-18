import greedySDCH.Model.StringStatisticSet


object RabinKarpMatching {
  type RollingHash = scala.collection.mutable.Map[Int, List[(String, Int)]]

  def wellKnownString(values : StringStatisticSet) : String = {
    ???
  }

  def hash(str : String, len : Int, cache : RollingHash) : RollingHash = {
    if (str.length < len) {
      cache
    } else {
      ???
    }
  }
}
