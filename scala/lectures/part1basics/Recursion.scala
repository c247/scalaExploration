package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def Factorial(n: Int): Int =  {
    if (n <= 1) 1
    else {
      println("Computing factorial of  " + n + " - I first need factorial of " + (n-1))
      val result = n * Factorial(n-1)
      println("Computed factorial of " + n)

      result
    }
  }

  def anotherFactorial(n: Int): Int = {
    @tailrec
    def factHelper(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)
    }
    factHelper(n, 1)

  }
  println(anotherFactorial(10))

  def concatenateString(str: String, n: Int): Unit = {
    @tailrec
    def helper(aString: String, acc: Int): Unit = {
      if (acc == n) print(aString)
      else {
        print(aString)
        helper(aString, acc + 1)
      }
    }
    helper(str, 1)
  }

  concatenateString("Vijay", 4)

  def isPrime(n: Int): Boolean = {
    @tailrec
    def helper(num: Int, x: Int): Boolean = {
      if (x == 1) true
      else {
        if (num % x == 0)
          false
        else
          helper(num, x-1)
      }
    }
    helper(n, n-1)
  }
  println(isPrime(13))


  def fib(n: Int): Int = {
    @tailrec
    def helper(res: Int, prev: Int, acc: Int): Int = {
      if (acc == n) prev
      else {
        helper(res + prev, res, acc + 1)
      }
    }
    helper(1,1, 1)
  }

  println(fib(8))




}
