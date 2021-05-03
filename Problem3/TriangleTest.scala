package Problem3

import scala.io.{BufferedSource, Source}

object TriangleTest  extends  App {

  val directory = "/Users/goreddy/WS/Assignment1/src/main/resources/"
  val filename = directory + "triangle.txt"
  var res = 0
  try {
    val source: BufferedSource = Source.fromFile(filename)
    val getSumOfAdjacentNumbers = source.getLines().map(s => sumAdjacentNumbers(s.split("\\s+"))).toList.last
    println("In triangle sumOfAdjacentNumbers is:" + getSumOfAdjacentNumbers)
  }catch {
    case ex: Exception => println(s"Exception occurred due to :${ex.getMessage}")
  }

  /**
   *
   * @param lineOfString
   * @return res
   */
  def sumAdjacentNumbers(lineOfString:Array[String]):Int ={
    if(lineOfString.size == 1) res = res + lineOfString.head.toInt
    else res = res + lineOfString.takeRight(2).head.toInt
    res
  }




}
