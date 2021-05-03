package Problem2

import scala.io.{BufferedSource, Source}

object PokerGameTest extends App {

  val directory = "/Users/goreddy/WS/Assignment1/src/main/resources/"
  val filename = directory + "poker.txt"
  var winCounter = 0
  try {
    val source: BufferedSource = Source.fromFile(filename)
    val getPlayer1WinCount = source.getLines().map(s => findWinner(s.split("\\s+"), "player1")).toList.last
    println(s"Player1 winning count is:$getPlayer1WinCount")
  } catch {
    case ex: Exception => println(s"Exception occurred due to :${ex.getMessage}")
  }

  /**
   *
   * @param cards
   * @param player
   * @return
   */
  def findWinner(cards: Array[String], player: String): Int = {
    val play1 = Hand(cards.take(5).toList)
    val play2 = Hand(cards.takeRight(5).toList)
    val res = play1.compareTo(play2)
    player match {
      case "player1" =>
        if (res._1.isDefined && (res._1.get eq play1)) {
          winCounter = winCounter + 1
        }
        winCounter
      case "player2" =>
        if (res._1.isDefined && (res._1.get eq play2)) {
          winCounter = winCounter + 1
        }
        winCounter
      case _ => 0
    }
  }
}
