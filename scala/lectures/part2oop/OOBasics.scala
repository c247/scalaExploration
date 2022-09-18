
package lectures.part2oop

object OOBasics extends App{
  var person = new Person("vijay", 20)
  println(person.x)
  person.greet("john")


  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))

  val counter = new Counter
  counter.inc.inc.inc.print
  counter.inc(10).print

}

class Person(name: String, val age: Int) {
  // body

  val x = 2

  println(1 + 3)

  // method
  def greet(name: String) : Unit = println(s"${this.name} says: Hi, $name")
  // overloading
  def greet(): Unit = println(s"Hi, i sm $name")

  // multiple constructor
  def this(name: String) = this(name, 0)
  def this() = this("Vijay")
}

class Writer(firstName: String, surname: String, val year: Int) {
  def fullname: String = firstName + " " + surname
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge: Int = {
    yearOfRelease - author.year
  }
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy (newYear: Int): Novel = new Novel(name, newYear, author)

}

class Counter(val count: Int = 0) {
  def inc = {
    println("Incrementing")
    new Counter(count + 1)
  } // immutability
  def dec = new Counter(count - 1)

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
  }
  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n-1)
  }

  def print = println(count)
}