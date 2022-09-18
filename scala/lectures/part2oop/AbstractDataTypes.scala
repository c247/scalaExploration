package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType: String = "Wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")
  }

  // traits

  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal:String = "fresh meat"
  }

  trait ColdBlodded
  class Crocodile extends Animal with Carnivore with ColdBlodded {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomcrocnom")
    def eat(animal: Animal): Unit = println(s"I am a croc and im eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile

  croc.eat(dog)

  // traits vs abstract classes
  // 1- traits do not have constructor parameters
  // 2- multiple traits may be inherited by the same class
  // 3- traits = behaviour, abstract class = "thing"

}
