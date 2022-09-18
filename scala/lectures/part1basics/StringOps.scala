package lectures.part1basics

object StringOps extends App {
  val str: String = "Hello, my name is vijay"

  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace("", "_"))
  println(str.toLowerCase())
  println(str.length())

  val aNumStr : String = "45"
  val aNum = aNumStr.toInt
  println('a' +: aNumStr :+ 'z')
  println(str.reverse)
  println(str.take(2))


  // Scala specific
  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello"
}
