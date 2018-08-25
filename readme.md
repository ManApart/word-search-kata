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
