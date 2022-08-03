# Mutant Testing

This guide has the objective to explain what is mutant testing, it's benefits and how to implement it.

## What is it?

Mutation testing is used to evaluate the quality of existing application tests, helping developers to design newer and better tests.

## What problem it solves?

The traditional Code Coverage technique measures only how much of your code is executed by your tests. It does not verify if your tests are really capable of detecting bugs in the executed code. Therefore it only indentifies code not tested.

In the majority of the cases, the written tests are enough to generate 100% of code coverage, but the code can be modified in a way that it's functionality is changed and all the tests still pass.

Because it's capable of detecting if each assertion is tested in a meaningful way, Mutant Testing is essencial to measure the quality of the application test cases.

## How it works?

Bugs or modifications (called mutations) are automatically introduced in the application code and then the application tests are executed.

If the application tests fail, the mutation will be eliminated. If the application tests succed, the mutation survived.

The goal is to kill all mutations.

## Types of Mutation Testing

Each library that implements mutation testing has it's own mutation types. Here are some popular mutation types:

### Arithmetic:

### Attribution:

### Conditional

### Block

## Popular Libraries

* Stryker (C#, Scala, NodeJS, etc).
* Pitest (Java).
* Cosmic Ray (Python).
