package kns.spb.mvo

import scala.collection.mutable

object Graham {

  def setLeftmostPointFirst(points : Array[Point]): Unit = {
    for (i <- points.indices) {
      if (points(i).x < points(0).x) {
        //если i-ая точка лежит левее 0-ой точки
        //меняем местами номера этих точек
        val prevFirst = points(0)
        points(0) = points(i)
        points(i) = prevFirst
      }
    }
  }

  def rotate(a : Point, b : Point, c : Point) =
    (b.x - a.x) * (c.y - b.y) - (b.y - a.y) * (c.x - b.x)

  def sortByRotation(centerPoint : Point, points : Array[Point]): Array[Point] = {
    points.sortWith((a, b) => rotate(centerPoint, a, b) > 0)
  }

  def findShellInSorted(pointFromShell : Point, points : Array[Point]): Seq[Point] = {
    val shell = mutable.ArrayBuffer(pointFromShell, points(0))
    System.err.println(shell)
    for (i <- 1 until points.length) {
      while (rotate(shell(shell.length - 2), shell.last, points(i)) < 0) {
        shell.remove(shell.length - 1)
      }
      shell += points(i)
    }

    shell
  }
}
