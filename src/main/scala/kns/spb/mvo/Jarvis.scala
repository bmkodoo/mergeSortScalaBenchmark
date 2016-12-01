package kns.spb.mvo

import scala.collection.mutable

object Jarvis {

  def findShell(points_ : Array[Point]): Seq[Point] = {
    Graham.setLeftmostPointFirst(points_)

    val points = points_.toBuffer
    val shell = mutable.ArrayBuffer[Point](points.head)
    points.remove(0)
    points.append(shell(0))

    object AllDone extends Exception { }

    try {
      while (true) {
        var right = 0
        for (i <- 1 until points.length) {
          if (Graham.rotate(shell(shell.length - 1), points(right), points(i)) < 0) {
            right = i
          }
        }

        if (points(right) == shell(0)) {
          throw AllDone
        }

        shell.append(points(right))
        points.remove(right)
      }
    } catch {
      case AllDone =>
    }

    shell
  }
}
