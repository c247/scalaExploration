package lectures.part1basics

import scala.annotation.tailrec

object Functions extends App {

  def aFunction(a: String, b: Int): String =
    a + " " + b

  println(aFunction("hello", 34))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())

  def aRepeatedFunction(s: String, x: Int): String = {
    if (x == 1) s
    else
      s + " " + aRepeatedFunction(s, x - 1)
  }

  println(aRepeatedFunction("Vijay", 5))

  // when u need loops, use recursion
  def aFunctionWithSideEffects(aString: String): Unit = {
    println("woohoo")
  }

  def aBigFunction(n : Int): Int =  {
    def add (a: Int, b:Int): Int = {
      a + b
    }
    add(n, n-1)
  }

  def Greeting(name: String, age: Int): Unit = {
    println("Hi my name is " + name + " and my age is " + age)
  }

  def Factorial(n: Int): Int =  {
    if (n == 0) 1
    else
      n * Factorial(n-1)
  }
  println(Factorial(3))

  def Fibonacci(n: Int) : Int = {
    if (n == 1) 1
    else
      if (n == 2) 1
      else
        Fibonacci(n-1) + Fibonacci(n-2)
  }

  println(Fibonacci(8))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def helper(num: Int, x: Int): Boolean = {
      if (x == 1) true else
      if (num % x == 0)
        false
      else
      helper(num, x-1)
    }
    helper(n, n-1)
  }

  println(isPrime(17))
  println(isPrime(2003))
  println(isPrime(37*17))


}
