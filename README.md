# Java TNetstrings Implementation

Patched version of Armando Singer's igh performance Java implementation of the "tagged netstrings" 
framed, whole message format.

* See [http://tnetstrings.org/](http://tnetstrings.org/) for spec details.
* See the [Java Mongrel2 Handler](https://github.com/asinger/mongrel2j) which uses this format.
* See the [original repository](https://github.com/asinger/tnetstringsj) 

## Dependencies
* JDK 1.6+
* No library dependecies (except JUnit for tests)

## Improvements
* Code reformated
* Maven project
* Ability to parse consecutive netstrings in a byte array, either pop-like (return parsed netstring 
plus remainder) or complete (return a List containing all parsed objects)

Since I didn't change the actual parsing there shouldn't be too much additional overhead.