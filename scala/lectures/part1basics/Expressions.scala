package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2
  println(x)
  println(2 + 3 * 4)
  println(1 == x)
  println(!(1 == x))

  var aVariable = 2
  aVariable += 3
  println(aVariable)

  val aCondition = true

  val aConditionValue = if(aCondition) 5 else 3
  println(aConditionValue)
  println(if(aCondition) 5 else 3)
  println(1 + 3)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  // never write this again lol

  // Everything in scala is an expression!
  val aWeirdValue = (aVariable = 3)
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning

  // code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }

  // 
}
