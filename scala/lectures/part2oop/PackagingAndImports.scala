package lectures.part2oop

import playground.{PrinceCharming, Cinderella as Princess}

import java.sql
import java.util.Date
import java.sql.{Date => Mani}

object PackagingAndImports extends App{
  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  val princess = new Princess // playground.Cinderella = fully qualified name

  // packages are in hierarchy
  // matching folder structure

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  // 1. Use FQ name
  val date = new Date
//  val sqlDate = new Mani()

  // 2. use aliasing

    // default imports
    // java.lang - String, Object, Exception
    // scala - Int, Nothing, Function
    // scala.Predef - println, ???

}
