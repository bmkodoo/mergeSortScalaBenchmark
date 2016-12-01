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
    Graham.setLeftmostPointFirst(points)
    assert(points(0).x == -2)
    assert(points(0).y == 5)
  }

  it should "sort by rotation" in {
    val points = Array(
      new Point(0.1, 1),
      new Point(1, 0.5),
      new Point(0, -1),
      new Point(2, 0))

    val sorted = Graham.sortByRotation(new Point(-1, 1), points)
    assert(sorted(0).x == 0)
    assert(sorted(1).x == 2)
    assert(sorted(2).x == 1)

  }
}