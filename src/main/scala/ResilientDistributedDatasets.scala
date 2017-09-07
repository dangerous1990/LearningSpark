import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by limeng on 17-9-7.
  */
object ResilientDistributedDatasets {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Resilient Distributed Datasets").setMaster("local")
    val sc = new SparkContext(conf)
    val data = Array(1, 2, 3, 4, 5)
    val distData = sc.parallelize(data)
    //first (1,2) second (3,3) third (6,4)
    //第一次reduce 遍历元素的第一个和第二个值
    //第二次及以后 第一个参数是上一次reduce返回值,第二个参数是遍历的元素值
    val result = distData.reduce((a, b) => {
      println("a:" + a)
      println("b:" + b)
      a + b
    })
    println(result)
  }
}
