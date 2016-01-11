class Person {
  protected var fname = ""
  protected var lname = ""
  def setFirstName(firstName: String): this.type = { // specify this.type as the return type because Person can be extended
    fname = firstName
    this
  }
  def setLastName(lastName: String): this.type = {
    lname = lastName
    this
  }
}

class Employee extends Person {
  protected var role = ""
  def setRole(role: String): this.type = {
    this.role = role
    this
  }
  override def toString = {
    "%s, %s, %s".format(fname, lname, role)
  }
}

val employee = new Employee
employee.setFirstName("Al")
        .setLastName("Alexander")
        .setRole("Developer")
println(employee)

