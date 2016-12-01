package spb.kns.mvo

import java.util.concurrent.TimeUnit

import kns.spb.mvo.{Graham, Jarvis, Point}
import org.openjdk.jmh.annotations.{State, _}

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Array(Mode.AverageTime))
@State(Scope.Thread)
@Warmup(iterations = 8)
@Fork(value = 1)
@Measurement(iterations = 10, time = -1)
class MVOBenchmark {

  val MAX_POINTS = 10000
  val SEED = 1304

  @Param(Array("10", "100", "1000", "5000", "10000"))
  var pointsCount : Int = _

  var points = new Array[Point](MAX_POINTS)

  @Setup(Level.Trial)
  def generateData() = {
    val r = new scala.util.Random(SEED)
    for (i <- 0 until MAX_POINTS) {
      points(i) = new Point(r.nextInt(MAX_POINTS), r.nextInt(MAX_POINTS))
    }
  }

  @Benchmark
  def graham() = {
    val shell = Graham.findShell(points.slice(0, pointsCount))
//    System.err.println("Graham: shell size = ", shell.length)
  }

  @Benchmark
  def jarvis() = {
    val shell = Jarvis.findShell(points.slice(0, pointsCount))
//    System.err.println("Jarvis: shell size = ", shell.length)
  }

}