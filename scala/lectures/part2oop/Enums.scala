package lectures.part2oop

object Enums {

  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    // add fields/methods

    def openDocument(): Unit = {
      if (this == READ) println("opening document...")
      else println("reading not allowed.")
    }
  }

  val somePermissions: Permissions = Permissions.READ

//   constructor args
  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4)
    case WRITE extends PermissionsWithBits(2)
    case EXECUTE extends PermissionsWithBits(1)
    case NONE extends PermissionsWithBits(0)
  }

val g: PermissionsWithBits = PermissionsWithBits.READ

//  object PermissionsWithBits {
//    def fromBits(bits: Int): PermissionsWithBits = new PermissionsWithBits(bits) // whatever
//  }

  // standard API
  val somePermissionsOrdinal = somePermissions.ordinal
  val allPermissions = PermissionsWithBits.values
  val readPermission: Permissions = Permissions.valueOf("READ")

  def main(args: Array[String]): Unit = {
    somePermissions.openDocument()
    println(somePermissionsOrdinal)
  }
}
