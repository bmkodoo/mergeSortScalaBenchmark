package kns.spb

import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MergeSuite extends FlatSpec {
  behavior of "a Merge"

  it should "sort strings" in {
    val toBeSorted = List(5, 3, 2, 6, 7, 8, 1, 0, -1, 100)
    val sorted = Merge.msort[Int](toBeSorted)
    assert(sorted == List(-1, 0, 1, 2, 3, 5, 6, 7, 8, 100))
  }
}