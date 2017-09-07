import org.apache.spark.{SparkConf, SparkContext}

/**
  * The first thing a Spark program must do is to create a SparkContext object, which tells Spark how to access a cluster.
  * To create a SparkContext you first need to build a SparkConf object that contains information about your application.
  * Only one SparkContext may be active per JVM.
  * You must stop() the active SparkContext before creating a new one.
  * Created by limeng on 17-9-7.
  */
object InitializingSpark {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("app test").setMaster("local")
    val sc = new SparkContext(conf)
  }
}
