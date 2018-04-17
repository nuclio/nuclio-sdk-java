# nuclio Java SDK

Java SDK for [nuclio][nuclio].

This SDK is for building nuclio Java handlers.

### Building a Handler

To implement a handler you need to write a class the implements
`io.nuclio.EventHandler`.

`nuctl build` does the following logic, depends on the value of `-p`:
- If it's a jar, use it
- If it's a directory and there's `handler.jar` there, use it
- If it's a directory with only single jar (including sub directories), use it
- If there's a `build.gradle` file there - run `nuclioJar` task and use jar from `build` directory
- If there's no `build.gradle`, generate one, build and use jar from `build` directory

Build will work also if the path passed is a single Java file.

You can specify dependencies using (inline in Java file or Jar) build configuration

``` java
// @nuclio.configure
//
// function.yaml:
//   spec:
//     build:
//       dependencies:
//         - group: com.google.code.gson"
//           name: gson"
//           version: 2.8.2"
//         - group: com.google.guava"
//           name: guava"
//           version: 23.6-jre"
```


The default image is using OpenJDK 9

If you have dependencies in other packages, create a fat/uber Jar with all the
dependencies. We currently do not support maven/sbt/ant/... builds

### Building the SDK
    
    gradle jar

[nuclio]: http://nuclio.io/
[nuctl]: https://nuclio.io/docs/latest/reference/nuctl/nuctl_build/
