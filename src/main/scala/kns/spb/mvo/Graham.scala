package kns.spb.mvo

object Graham {

  def setLeftmostPointFirst(points : Array[Point]) : Array[Int] = {
    val pointsOrder = points.indices.toArray
    for (i <- points.indices) {
      if (points(pointsOrder(i)).x < points(pointsOrder(0)).x) {
        //если P[i]-ая точка лежит левее P[0]-ой точки
        //меняем местами номера этих точек
        val prevFirst = pointsOrder(0)
        pointsOrder(0) = pointsOrder(i)
        pointsOrder(i) = prevFirst
      }
    }
    pointsOrder
  }
}
