package rdd.options

import org.apache.spark.{SparkConf, SparkContext}
import Array._

/**
  * Created by limeng on 17-9-8.
  */
object MapOption {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("learn map option")
    val sc = new SparkContext(conf)
    val rdd = sc.parallelize(range(1, 100))
    val result = rdd.map(_ * 5).reduce(_ + _)
    val result1 = rdd.reduce(_ + _)
    val result2 = rdd.reduce(sum(_, _))
    //sum
    val result3 = rdd.reduce(MapOption.sum)
    //sum
    val result4 = rdd.reduce(sum) //sum
    println(result == result1 * 5)
    println(result2)
    println(result3)
    println(result4)
    val rdd2 = sc.parallelize(Array((1, 2), (1, 3), (1, 3), (1, 3), (1, 3), (1, 3), (1, 3), (2, 3)))
    rdd2.map(identity(_)).reduceByKey(_ + _).collect().foreach(println)
  }

  def sum(a: Int, b: Int): Int = a + b
}
