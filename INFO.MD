## Java Interview Questions and Hints

### OOP Concepts:
- Encapsulation: Bundling data and methods together, restricting direct access to them.
  - Use case: In Entity and DTO classes.
- Inheritance: Creating new classes by inheriting attributes and behaviors from existing ones.
  - Use case: In Service or DAO classes.
- Polymorphism: Allowing different classes to be treated through the same interface, with varied behaviors.
  - Use case: When Overloading or Overriding methods, with Interfaces in general.
- Abstraction: Simplifying complex systems by exposing only essential features, hiding unnecessary details.
  - Use case: widely used in method overriding, interface implementations, working with collections, dependency injection.

### Order of exceptions:
- Exception over others(Arithmetics)
- Exception Hierarchy: Java exceptions are organized hierarchically, with more specific exceptions (like FileNotFoundException) being subclasses of more general ones (like IOException and Exception).

### Final, Finally and Finalize:
- Final is a keyword, used for fields and methods in a class
- Finally is a code block, used for cleanup purposes(streams) replaced by try with resource approach
- Finalize is a method used by JVM for cleanup of unused objects

### Equals and Hashcode
- Hashcode: used to generate unique or reference number of an object through which we can easily identify uniqueness of an object.
- Equals: used to compare objects based on its content.

### Miscellaneous
- private and static methods cannot be overridden.
- interfaces in java7 and java8: 
  - Java 7:
    - Interfaces can only have abstract methods.
    - Cannot have any method implementations.
    - Can only contain public, static, and final variables.
  - Java 8:
    - Introduced default methods with implementations.
    - Allowed static methods in interfaces.
    - Enabled the use of lambda expressions for functional interfaces. 


