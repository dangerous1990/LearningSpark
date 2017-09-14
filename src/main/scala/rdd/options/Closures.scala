package rdd.options

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by limeng on 17-9-11.
  */
object Closures {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("learn map option")
    val sc = new SparkContext(conf)
    var counter = 0
    var data = Array.range(1,10)
    var rdd = sc.parallelize(data)

    // Wrong: Don't do this!!
    // counter 值在函数内部值在变换 外部在访问该值没有变化 闭包
    rdd.foreach(x => {
      counter += x
      println(counter)
    })

    println("Counter value: " + counter)
  }
}
