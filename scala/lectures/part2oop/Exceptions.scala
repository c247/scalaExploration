package lectures.part2oop

object Exceptions extends App {
  val x: String = null
//  println( x.length)

// 1. throwing exceptions
//  val aWeirdValue: String = throw new NullPointerException

  // throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes

  // 2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int =  {
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42
  }

 val potentialFail = try {
    getInt(true)
  } catch {
    case e: RuntimeException => 42
  } finally {
   // optional
   // does not influence the return type of this expression
   // use finally only for side effects
    println("finally")
  }

 print(potentialFail)

 // 3. how to define your own exceptions
 class MyException extends Exception
 val exception = new MyException

  // throw exception

  /*
  1. crash your program with an outofmemoryerror
  2. crash with SOError
  3. PocketCalculator
      - add(x, y)
      - subtract(x, y)
      - multiply(x, y)
      - divide (x, y)
  Throw appropriate exception

  */
  // OOM
  //  val array = Array.ofDim(Int.MaxValue)

  // SO
  //  def infinite(n: Int): Int = 1 + infinite(n+1)
  //  val hi = infinite(0)

  class OverflowException extends Exception
  class UnderflowException extends Exception

  object PocketCalculator {
    def add(x:Int, y:Int) = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }
    // the rest ...
  }

}
