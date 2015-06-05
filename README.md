SDCH dictionary generator
==========

Dictionary creating based on Rabin-Karp algorithm (http://en.wikipedia.org/wiki/Rabin%E2%80%93Karp_algorithm) and binary search for common substring.

Length of common substring is monotonic function. For instance, if there is no common substring with length N, than there is common substring with length > N.
Also otherwise, if there is common substring with length N, than there is common subtring with length < N. That allow us to use binary search.

On each iteration we have set of files/strings. Calculate most common substring ($mcs$), output this $mcs$ to result dictionary, and remove all occuriances $mcs$ from current files/strings, provide input data for next iteration.




How to run
==========

Al least, we need:
  - Java 7 or Java 8
  - sbt (http://www.scala-sbt.org/release/tutorial/Installing-sbt-on-Linux.html)

Put all input files in /data (pathToProject/data). Only *.css and *.js files are allowed.

Change directory to the root of project. 

- sbt run (run Main object)
- sbt test 
- sbt gen-idea (generate Intellij Idea project)

Or just run sbt, and type commands (run/test/gen-idea)

About code
==========

```scala
    input = Examples.longestSubstring(input)(350)
    input = Examples.longestSubstring(input)(75)
    input = Examples.longestSubstring(input)(10)
```

At first, we are looking for the longest common substring (length is not more than 50), that entry more than 350 times. 
After that we are looking the second (!) (decrease length till 5) longest common substring, that entry than 350 times. 

After that we start again, but count of ocurances is 75 now. And so on.

