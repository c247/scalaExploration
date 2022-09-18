package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def trFact(n: Int, acc: Int = 1): Int = {
    if (n <= 1) {
      return acc
    }
    trFact(n-1, acc * n)
  }

  println(trFact(4))

}
