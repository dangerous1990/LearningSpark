
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext


/**
  * Created by Jan on 2016/12/19.
  */
object Helloworld {

  def main(args: Array[String]) {
//    val logFile = "/home/limeng/dev/apache-tomcat-8.0.21/logs/catalina.out"  // Should be some file on your server.
//    val conf = new SparkConf().setAppName("test").setMaster("local")
//    val sc = new SparkContext(conf)
//    //val spark = SparkSession.builder.appName("Simple Application").master("local").getOrCreate()
//    val logData = sc.textFile(logFile).cache()
//    val wordCount = logData.map(line => line.split(" ")).groupBy(identity).mapValues(_).count()
//    println(wordCount)
//    val numAs = logData.filter(line => line.contains("ERROR")).count()
//    val numBs = logData.filter(line => line.contains("INFO")).count()
//    println(s"Lines with a: $numAs, Lines with b: $numBs")
//    sc.stop()
  }

}