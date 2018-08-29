# Word Search Kata

## Building / Testing 

Run `gradle clean build test` to clean, build and test the project.

To build the jar run `gradle build jar`

## Running

To run the jar with the example input run
`java -jar build\libs\word-search-kata-1.0-SNAPSHOT.jar "B:\Coding\Workspace\Katas\word-search-kata\input.txt"`

Make sure to replace `"B:\Coding\Workspace\Katas\word-search-kata\input.txt"` with your path to the desired input file.

If you run the included file, the expected output is:

```
BONES: (0,6),(0,7),(0,8),(0,9),(0,10)
KHAN: (5,9),(5,8),(5,7),(5,6)
KIRK: (4,7),(3,7),(2,7),(1,7)
SCOTTY: (0,5),(1,5),(2,5),(3,5),(4,5),(5,5)
SPOCK: (2,1),(3,2),(4,3),(5,4),(6,5)
SULU: (3,3),(2,2),(1,1),(0,0)
UHURA: (4,0),(3,1),(2,2),(1,3),(0,4)
```

## TODO

* WordPositionFinder.examine is ugly, can it be broken out to more methods?
* Should I move tests for searches to test just that class or keep them at the higher level?

## TODO per helpful feedback
* The cyclomatic complexity of PuzzleSolver.find(). Reduce the nested loops
