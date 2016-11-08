How to create a Maven multiple module project? steps: 1. create a maven project in eclipse, choose maven-archetype-site-simple 2. delete src folder 3. then create a maven-module in eclipse, choose correct parent-module.

Design Patterns: In software engineering, a design pattern is a general repeatable solution to a commonly occurring problem in software design. A design pattern isn't a finished design that can be transformed directly into code. it is a description or template for how to solve a problme that can be used in many different situations.

Uses of Design Patterns. Design patterns can speed up the development process by providing tested, proven development paradigms. effective software design requires considering issues that may not become visible until later in the implementation. Reusing design patterns helps to prevent subtle issues that can cause major problems and improves code readability for coders and architects familiar with the patterns.

Often, people only understand how to apply certain software design techniques to certain problems. these techniques are difficult to apply a broader range of problems. Design patterns provide general solutions, documented in a format that doesn't require specifics tied to a particular problem.

In addition, patterns allow developers to communicate using well-known, well understood names for software interactions. Common design patterns can be improved over time, making them more robust than ad-hoc designs.

Creational design patterns These design patterns are all about class instantiation. This pattern can be further divided into class-creation patterns and object-creational patterns. While class-creation patterns use inheritance effectively in the instantiation process, object-creation patterns use delegation effectively to get the job done.

Abstract Factory Creates an instance of several families of classes

Builder Separates object construction from its representation

Factory method creates an instance of several derived classes

Object pool avoid expensive acquisition and releases of resources by recycling objects that are no longer in use

Prototype a fully initialized instance to be copied or cloned

Singleton a class of which only a single instance can exist

Structural design patterns these design patterns are all about Class and Object composition. Structural class-creation patterns use inheritance to compose interfaces. Structural object-patterns define ways to compose objects to obtain new functionality.

Adapter Match interfaces of different classes

Bridge Separates an object's interface from its implementation

composite A tree structure of simple and composite objects

Decorator add responsiblities to objects dynamically

facade a single class that represents an entire subsystem

Private class Data restricts accessor/mutator access

Proxy an object representing another object.

Behavioral design patterns These design patterns are all about class's objects communication. Behavioral patterns are those patterns that are most specifically concerned with communication between objects.

Chain of responsiblity a way of passing a request between a chain of objects

Command Encapsulate a command request as an object

Interpreter a way to include language elements in a program

Iterator sequentially access the elements of a collection

Mediator defines simplified communication between classes

Memento Capture and restore an object's internal state

Null object Designed to act as a default value of an object

Observer a way of notifying change to a number of classes

State alter an object's behavior when its state changes

strategy encapsulates an algorithm inside a class

template method defer the exact steps of an algorithm to a subclass

visitor defines a new operation to a class without change