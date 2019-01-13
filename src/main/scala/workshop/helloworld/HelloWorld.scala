package workshop.helloworld
import java.time.Clock


import com.typesafe.config.ConfigFactory
import org.apache.log4j.{Level, LogManager, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object HelloWorld {
  val log: Logger = LogManager.getRootLogger
  implicit val clock: Clock = Clock.systemDefaultZone()

  def main(args: Array[String]): Unit = {
    val conf = ConfigFactory.load
    log.setLevel(Level.INFO)

    val spark = SparkSession.builder.appName("Spark Word Count").getOrCreate()
    log.info("Application Initialized: " + spark.sparkContext.appName)


    run(spark)

    spark.stop()
  }

  def run(spark: SparkSession): Unit = {
    log.info("Reading data: ")
    log.info("Writing data: ")

    import spark.implicits._
    log.info("Application Done: " + spark.sparkContext.appName)
  }
}