package dataset

import java.util.Properties

import org.apache.spark.sql.{Dataset, Row, SparkSession}

/**
  * Created by limeng on 17-9-26.
  */
object JDBCDataSetSample {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder
      .appName("Java Spark SQL data sources example")
      .config("spark.some.config.option", "some-value")
      .master("local")
      .getOrCreate()
    // Note: JDBC loading and saving can be achieved via either the load/save or jdbc methods
    // Loading data from a JDBC source
    val jdbcDF = spark.read.format("jdbc")

      .option("url", "jdbc:mysql://10.0.15.41:3306/app_store?useUnicode=true&characterEncoding=UTF-8")
      .option("dbtable", "app_store.app")
      .option("user", "app")
      .option("password", "app").load()
      jdbcDF.printSchema()
      jdbcDF.show()
  }

}
