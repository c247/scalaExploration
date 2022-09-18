package lectures.part2oop

import scala.annotation.targetName
import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {
    infix def likes(movie: String): Boolean = movie == favouriteMovie
    infix def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive : Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
    def apply(n: Int): String = s"$name watched $favouriteMovie $n times"
    infix def +(s: String): Person = new Person(name + " " + s, favouriteMovie, age)
    def unary_+ : Person = new Person(name, favouriteMovie, age+1)
    def learns(s: String): String = name + " learns " + s
    def learnsScala = learns("Scala")
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")

  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS

  // prefix notation
  val x = -1
  val y = 1.unary_-
  // unary_prefix only works with - + ~ !
  println(!mary)
  println(mary.unary_!)

  // postfix
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary())

  println(mary learnsScala)
  println((mary + "The rockstar")())
  println((+mary).age)
  println(mary(10))
}
