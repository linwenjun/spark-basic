name := "data-engineering-workshop"

version := "0.1"

scalaVersion := "2.11.12"

val sparkVersion = "2.3.2"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-sql" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-streaming" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-sql-kafka-0-10" % "2.3.2",
  "com.typesafe" % "config" % "1.3.2",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)

test in assembly := {}

// https://stackoverflow.com/questions/42310821/deduplicate-different-file-contents-found-error-for-sbt-and-scala
// https://stackoverflow.com/questions/14791955/assembly-merge-strategy-issues-using-sbt-assembly
import sbtassembly.MergeStrategy
assemblyMergeStrategy in assembly := {
  case PathList("org", "apache", xs @ _*) => MergeStrategy.first
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}