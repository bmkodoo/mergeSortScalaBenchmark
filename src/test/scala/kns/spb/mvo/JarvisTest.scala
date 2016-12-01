package kns.spb.mvo

import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class JarvisTest extends FlatSpec {
  behavior of "Jarvis algorithm "

  it should "find shell!" in {
    val points = Array(
      new Point(0.1, 1),
      new Point(1, 0.5),
      new Point(-0.1, -1),
      new Point(2, 0),
      new Point(-1, 1),
      new Point(0, 0))

    val shell = Jarvis.findShell(points)

    assert(shell.length == 4)
    assert(shell(0).x == -1)
    assert(shell(1).x == -0.1)
    assert(shell(2).x == 2)
    assert(shell(3).x == 0.1)
  }
}