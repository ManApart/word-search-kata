# Word Search Kata

## Building / Testing 

Run `gradle clean build test` to clean, build and test the project.

To build the jar run `gradle build jar`

## Running

To run the jar with the example input run
`java -jar build\libs\word-search-kata-1.0-SNAPSHOT.jar "B:\Coding\Workspace\Katas\word-search-kata\input.txt"`

Make sure to replace `"B:\Coding\Workspace\Katas\word-search-kata\input.txt"` with your path to the desired input file.


## TODO

* Error handling for no file in / invalid file
* Error handling for word not found
* Should I move tests for searches to test just that class or keep them at the higher level?
* Code Warnings
  * InputParser manual array copy

## TODO per helpful feedback
* Clearer tests and classes names. 
  * ForwardSearchTest.reverse() > ForwardSearchTest probably should have been renamed to HorizontalSearchTest
* Check unhappy path scenarios in tests. 
  * improperly formatted input file; the program crashed: java -jar build/libs/word-search-kata-1.0-SNAPSHOT.jar ~/code/kata-reviews/word-search-kata/st.txt
* The cyclomatic complexity of PuzzleSolver.find(). Reduce the nested loops
