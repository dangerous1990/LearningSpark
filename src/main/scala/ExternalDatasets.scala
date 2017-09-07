import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by limeng on 17-9-7.
  */
object ExternalDatasets {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("app test").setMaster("local")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("README.md")
    //reduce函数会根据map的返回值进行变化
    //map返回Pair<K,V> reduceByKey function(V,V) 对value进行操作,并且返回值必须是V类型,否则编译不通过
    val result = rdd.map(line => (line, 1)).reduceByKey((v1, v2) => {
      println("do something")
      println("v1:" + v1)
      println("v2:" + v2)
      v1 + v2
    })
    print(result.count())
    result.foreach((pairx) => {
      println(pairx._1)
      println(pairx._2)
    })

    //word count _
    //flatMap
    //flatMap函数则是两个操作的集合——正是“先映射后扁平化”：
    //操作1：同map函数一样：对每一条输入进行指定的操作，然后为每一条输入返回一个对象
    //操作2：最后将所有对象合并为一个对象
    // _占位符 代表函数的参数
    rdd.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_ + _).collect().foreach(println(_))

  }

}
