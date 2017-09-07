/**
  * Created by limeng on 17-9-1.
  */

import org.apache.spark.sql.SparkSession

object SparkCSV {

  def main(args: Array[String]) {
    val sqlContext = SparkSession.builder().master("local").appName("my first app").getOrCreate()
    val df = sqlContext.read
      .format("com.databricks.spark.csv")
      .option("header", "true") // Use first line of all files as header
      .option("inferSchema", "true") // Automatically infer data types
      .load("/home/limeng/player_season.csv")
  //  df.show()
    df.printSchema()
    //df.select("球员", "球队").show()
    //sqlContext.sql("select ")
  }
}