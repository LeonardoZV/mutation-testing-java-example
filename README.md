# Mutant Testing

This guide has the objective to explain what is mutant testing, it's benefits and how to implement it.

## What problem is solved by Mutant Testing?

The traditional Code Coverage technique measures only how much of your code is executed by your tests. It does not verify if your tests are really capable of detecting bugs in the executed code. Therefore it only indentifies code not tested.

In the majority of the cases, the written tests are enough to generate 100% of code coverage, but the code can be modified in a way that it's functionality is changed and all the tests still pass.

Because it's capable of detecting if each assertion is tested in a meaningful way, Mutant Testing is essencial to measure the quality of the application test cases.

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.1/maven-plugin/reference/html/#build-image)

