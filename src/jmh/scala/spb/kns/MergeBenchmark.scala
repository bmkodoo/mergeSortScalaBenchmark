package spb.kns

import java.util.concurrent.TimeUnit

import kns.spb.Merge
import org.openjdk.jmh.annotations.{State, _}

/* Default settings for benchmarks in this class */
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Array(Mode.AverageTime))
@State(Scope.Thread)
@Warmup(iterations = 8)
@Fork(value = 1)
@Measurement(iterations = 10, time = -1)
class MergeBenchmark {

  @Param(Array("100", "1000", "10000", "100000", "1000000", "10000000"))
  var length : Int = _

  var randomData : Array[Byte] = _

  @Setup(Level.Trial)
  def generateData() = {
    randomData = randomArray
  }

  @Benchmark
  def sorting() = {
    Merge.msort[Byte](randomData.slice(0, length).toList)
  }

  def randomArray: Array[Byte] = {
    val a = Array.fill(200000000)(0.toByte)
    scala.util.Random.nextBytes(a)
    a
  }

}