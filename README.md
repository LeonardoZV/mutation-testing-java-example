# Mutation Testing

This guide has the objective to explain what is mutation testing, it's benefits and how to implement it.

## What is it?

Mutation testing is used to evaluate the quality of existing application tests, helping developers to design better tests.

## What problem it solves?

The traditional code coverage technique measures only how much of the application code is executed by it's tests. It does not verify if the tests are really capable of detecting bugs in the executed code. Therefore it only indentifies code not tested.

In the majority of the cases, the written tests are enough to generate 100% of code coverage, but the code can be modified in a way that it's functionality is changed and all the tests still pass.

Because it's capable of detecting if each assertion is tested in a meaningful way, Mutant Testing is essencial to measure the quality of a application test cases.

## How it works?

Bugs or modifications (called mutations) are automatically introduced in the application code and then the application tests are executed.

If the application tests fail, the mutation will be eliminated. If the application tests succed, the mutation survived.

The goal is to kill all mutations.

## Types of Mutations

Each library that implements mutation testing has it's own mutation types. Here are some popular ones:

### Arithmetic

```typescript
// original
const sum = (a: Number, b: Number): Boolean => a + b;

// mutated
const sum = (a: Number, b: Number): Boolean => a - b;
```

### Attribution

```typescript
// original
let a = 1;
let b = 2;

a += b;

// mutated
let a = 1;
let b = 2;

a -= b;
```

### Conditional

```typescript
// original
if (a > b) {
  // do something
}

// mutated
if (true) {
  // do something
}

if (false) {
  // do something
}
```

### Block

```typescript
// original
const someOddFunction = (a: Number, b: Number) Any => {
  if (a > b) {
    return 'not allowed';
  }
  
  if (a == b) {
    return true;
  }
  
  return 100;
);

// mutated
const someOddFunction = (a: Number, b: Number): Any => {
  // 
}
```

## How to implement it?

It's quite simple to implement it in Java.

You need to import the pitest plugin in the pom.xml:

```
<plugin>
  <groupId>org.pitest</groupId>
  <artifactId>pitest-maven</artifactId>
  <version>1.9.0</version>
</plugin>
```

If you're using JUnit 5, you will also need to import the JUnit 5 pitest plugin:

```
<plugin>
  <groupId>org.pitest</groupId>
  <artifactId>pitest-maven</artifactId>
  <version>1.9.0</version>
  <dependencies>
    <dependency>
      <groupId>org.pitest</groupId>
      <artifactId>pitest-junit5-plugin</artifactId>
      <version>1.0.0</version>
    </dependency>
  </dependencies>
</plugin>
```
Now all you have to do is execute the tests with mutation coverage:

```
mvn test-compile org.pitest:pitest-maven:mutationCoverage
```

The tests results can be found inside target/pit-reports/

## Popular Libraries

* Stryker (C#, Scala, NodeJS, etc).
* Pitest (Java).
* Cosmic Ray (Python).

## Example Application

[![Coverage](http://leozvasconcellos-sonarqube.eastus.azurecontainer.io:9000/api/project_badges/measure?project=LeonardoZV_mutation-testing-java-example&metric=coverage&token=90d6f22728d6337c1aa5fb7ce75109abe05cfa44)](http://leozvasconcellos-sonarqube.eastus.azurecontainer.io:9000/dashboard?id=LeonardoZV_mutation-testing-java-example)
![Mutation Coverage](https://img.shields.io/endpoint?url=https://gist.githubusercontent.com/LeonardoZV/e5a4b68734f8ee29d54ecfe7b78b1cfb/raw/mutation-testing-java-example-mutation-coverage-badge.json)
[![Quality Gate Status](http://leozvasconcellos-sonarqube.eastus.azurecontainer.io:9000/api/project_badges/measure?project=LeonardoZV_mutation-testing-java-example&metric=alert_status&token=90d6f22728d6337c1aa5fb7ce75109abe05cfa44)](http://leozvasconcellos-sonarqube.eastus.azurecontainer.io:9000/dashboard?id=LeonardoZV_mutation-testing-java-example)

This is a simplified example of a application responsible for updating the balance of a account given a debit or credit operation.

The account cannot have a negative balance.

### Hands on

It's common for new developers to test some blocks of code and forget about others.

In this example, the AccountUnitTest.mustCreditSpecifiedValue() and AccountUnitTest.mustDebitSpecifiedValue() tests are the only tests.

If we execute the code coverage analysis, it will show that the Account.debit() method isn't fully covered because of this snippet:

```java
if (newBalance < 0)
    throw new BalanceCannotBecomeNegativeException();
```

Then, the developer will introduce the AccountUnitTest.mustThrowExceptionWhenDebitMakesBalanceNegative() test to validate that condition.

Voilà! Code coverage now shows that 100% of your application code is covered by tests! But is that enough?

Let's change the application functionality and introduce a bug in this snippet of code by changing the condition:

```java
if (newBalance >= 0)
    throw new BalanceCannotBecomeNegativeException();
```
For your surprise, if you reexecute your unit tests and code coverage, you will see that everything will pass with flying colors!

You now realized why mutation testing is so important: To measure if you have enough tests and if your tests have quality!

If you executed the mutation coverage analysis before the introduction of the bug, you would be warned of this problem of quality!

Now, all you have to do is write the AccountUnitTest.mustNotThrowExceptionWhenDebitMakesBalanceZero() test and voilà!

Tests passed, code coverage and mutation coverage are all 100% and your code has the most important thing: quality.
