package lectures.part3fp

object WhatsAFunction extends App {

  // Dream: use functions as first class elements
  // problem: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(element:  Int): Int = element * 2
  }

  println(doubler(2))

  // functioin types = Function1[A,B]
  val stringToIntConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)


  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // Function types Function2[A, B, R] === (A, B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS

  /*
   1. 2 strings and concatenates them
   2. transform the MyPredicate into function types
   3. define a function which takes an int and returns another function which takes an int and returns an int
        - whats the function type
        - how to do it
  */

  val concat = new ((String, String) => String) {
    override def apply(v1: String, v2: String): String = v1 + v2
  }

  val t3 = new ((Int) => ((Int) => Int)) {
    override def apply(v3: Int): (Int => Int) = new (Int => Int) {
      override def apply(v1: Int): Int = v1 * v1 + v3
    }
  }

  println(t3(3)(2)) // curried function


}



trait MyFunction[A, B] {
  def apply(element: A): B
}