package kns.spb.mvo

import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GrahamTest extends FlatSpec {
  behavior of "Graham algorithm "

  it should "find leftmost point" in {
    val points = Array(
      new Point(1, 4),
      new Point(3, 1),
      new Point(-2, 5))
    val pointsOrder = Graham.setLeftmostPointFirst(points)
    println(pointsOrder)
    assert(pointsOrder(0) == 2)
  }
}