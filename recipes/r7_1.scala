package com {

package wong {
  class Foo { override def toString = "I am com.acme.store.Foo" }
}

}

object PackageTests extends App {
  println(new com.wong.Foo)
}

