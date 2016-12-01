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
      new Point(-0.1, -1),
      new Point(2, 0),
      new Point(0, 0))

    val sorted = Graham.sortByRotation(new Point(-1, 1), points)
    assert(sorted(0).x == -0.1)
    assert(sorted(1).x == 0)
    assert(sorted(2).x == 2)
    assert(sorted(3).x == 1)

  }

  it should "find shell in ordered by rotation list of points" in {
    val points = Array(
      new Point(-0.1, -1),
      new Point(0, 0),
      new Point(2, 0),
      new Point(1, 0.5),
      new Point(0.1, 1))

    val shell = Graham.findShellInSorted(new Point(-1, 1), points)
    assert(shell.length == 4)
    assert(shell(0).x == -1)
    assert(shell(1).x == -0.1)
    assert(shell(2).x == 2)
    assert(shell(3).x == 0.1)
  }
}