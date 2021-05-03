package Problem1

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month

object DaysFinder extends App{


  private val getSundaysCounter: Int = findMonthFirstDay(1901,2000,DayOfWeek.SUNDAY)
  /**
   *
   * @param fromYear
   * @param toYear
   * @param dayOfWeek
   * @return
   */
  private def findMonthFirstDay(fromYear:Int,toYear:Int,dayOfWeek:DayOfWeek):Int = {
    var date1 = LocalDate.of(fromYear, Month.JANUARY, 1)
    val endDate = LocalDate.of(toYear, Month.JANUARY, 1)
    var count = 0
    while (date1.isBefore(endDate)) {
      date1 = date1.plusMonths(1)
      if (date1.getDayOfWeek eq dayOfWeek) count += 1
    }
    count
  }

  println(s"Total sundays count:$getSundaysCounter")

}

