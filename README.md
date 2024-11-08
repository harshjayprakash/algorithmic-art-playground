# Algorithmic Art Playground

> ![NOTE]
> This project is still in development, despite finishing the dissertation.

![Banner (Decorative)](./doc/banner.png)

## Overview

The "Algorithmic Art Playground" is an application designed for users to experiment with
generating art through the power of programming. As a part of my dissertation project, I
developed this tool as both an educational resource for those learning about algmorithmic
approaches to creativity and a personal cavas where you can experiment with code-based
visuals on your local desktop machine.

## Compilation and Execution

The Maven build tool was utilised for handling dependencies, development and deployment.
Most IDEs, such as IntelliJ IDEA, VSCode and NetBeans support Maven. This project requires
Java 17 or newer.

## Usage

### Editor Window

### Output Window

### Help Window

## Known Issues and Limitations

* The program supports only unsigned integers as variables, and does not support calling
functions inside of functions, conditional statements, iterative statements, or using more
advanced features such as mathematical expressions or control flow construction.
* The current only supports three basic functions: `Position`, `Move` and `Rect`. These
functions allow you to manipulate a virtual canvas (the "generative art"). However, there
are currently not advanced features in the program that would allow for more complex
generative art creation.
* Some known issues with the current version of AAP:

  * Error messages are not informative enough, making it difficult to debug any iddues
  that may arise during the execution of the program.
  * The program sometimes output an error painting the output when running the input.

## References

* Flatlaf (under Apache 2.0): <https://www.formdev.com/flatlaf/>
* JUnit (under EPL 2.0): <https://junit.org/junit5/>
* JetBrains Java Annotations (under Apache 2.0): <https://github.com/JetBrains/java-annotations>
