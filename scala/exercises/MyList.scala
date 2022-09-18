package exercises

import scala.runtime.Nothing$

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](num: B): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: (A => B)): MyList[B]
  def filter(predicate: (A => Boolean)): MyList[A]
  def flatMap[B](transformer: (A => MyList[B])): MyList[B]

  // concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException()
  def tail: MyList[Nothing] = throw new NoSuchElementException()
  def isEmpty: Boolean = true
  def add[B >: Nothing] (num: B): MyList[B] = new Cons(num, Empty)
  override def toString: String = ""

  def printElements: String = ""
  
  // higher-order functions
  def map[B](transformer: (Nothing => B)): MyList[B] = Empty
  def filter(predicate: (Nothing => Boolean)): MyList[Nothing] = Empty
  def flatMap[B](transformer: (Nothing => MyList[B])): MyList[B] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A] (num: B): MyList[B] = new Cons(num, this)

  override def printElements: String =
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"
//  override def toString: String = ???

  def map[B](transformer: (A => B)): MyList[B] = {
    new Cons(transformer(h), t map transformer)
  }

  def filter(predicate: (A => Boolean)): MyList[A] = {
    if (predicate(h)) {
      new Cons(h, t.filter(predicate))
    } else {
      t.filter(predicate)
    }
  }
  def flatMap[B](transformer: (A => MyList[B])): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

  def ++[B >: A](list: MyList[B]): MyList[B] = {
    new Cons(h, t ++ list)
  }
}



object ListTest extends App {
  val list: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listStr: MyList[String] = new Cons("Hello", new Cons("Vijay", new Cons("Scala", Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.toString)
  println(listStr.toString)
  println(list.flatMap(new (Int => MyList[Int]) {
    override def apply(elem: Int): MyList[Int] = {
      new Cons(1, new Cons(elem * 10, Empty))
    }
  }).toString)
}