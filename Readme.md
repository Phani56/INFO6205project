# INFO6205project


### Problem Statement
To implement MSD radix sort for a natural language which uses Unicode characters.

### Main requirements
* JDK 1.8
* Maven
* Pinyin4j
* log4j
* Junit 4

### Implementation

**Modules**

* Counting -  **MSDStringSort**, **LSDStringSort** and InsertionSortMSD(used as cutoff in the counting sorts)
* HuskySort - Modified the implementation of **PureHuskySort** from https://github.com/rchillyard/The-repository-formerly-known-as
* simple - **DualPivot QuickSort** and **TimSort**
* util - Becnhmarking classes from Assignments repo. Added file utility to read the words list and config properties.


All the sorting algorithms above are configured to  run for both CHINESE and TELUGU languages.

Configuration values are as follows

_CHINESE_ : unicode_offset 0, radix_range 256

_TELUGU_ : unicode_offset 3072, radix_range 128

****Execute the [Sort benchmark file](https://github.com/Phani56/INFO6205project/blob/master/src/main/java/util/SortBenchmark.java) run becnmarkings for all the Sorting algorithms mentioned above. Update the language variable in config.properties to change the language****
