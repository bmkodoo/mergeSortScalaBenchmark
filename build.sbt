name := "mergeSortBenchmark"

version := "1.0"

scalaVersion := "2.12.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

libraryDependencies += "junit" % "junit" % "4.10" % "test"

enablePlugins(JmhPlugin)