https://www.careercup.com/question?id=13717672
http://homes.sice.indiana.edu/yye/lab/teaching/spring2014-C343/datatoobig.php

An example of disk-based application: External mergesort algorithm (wikipedia)
A merge sort divides the unsorted list into n sublists, each containing 1 element, and then repeatedly merges sublists to produce new sorted sublists until there is only 1 sublist remaining.
The external mergesort algorithm sorts chunks that each fit in RAM, then merges the sorted chunks together.For example, for sorting 900 megabytes of data using only 100 megabytes of RAM:
1. Read 100 MB of the data in main memory and sort by some conventional sorting method, like quicksort.
2. Write the sorted data to disk.
3. Repeat steps 1 and 2 until all of the data is in sorted 100 MB chunks (there are 900MB / 100MB = 9 chunks), which now need to be merged into one single output file.
4. Read the first 10 MB of each sorted chunk (of 100 MB) into input buffers in main memory and allocate the remaining 10 MB for an output buffer. (In practice, it might provide better performance to make the output buffer larger and the input buffers slightly smaller.)
5. Perform a 9-way merge and store the result in the output buffer. Whenever the output buffer fills, write it to the final sorted file and empty it. Whenever any of the 9 input buffers empties, fill it with the next 10 MB of its associated 100 MB sorted chunk until no more data from the chunk is available. This is the key step that makes external merge sort work externally -- because the merge algorithm only makes one pass sequentially through each of the chunks, each chunk does not have to be loaded completely; rather, sequential parts of the chunk can be loaded as needed.


Let's say we divide file in three chunk A,B,C and after sorting individually, content of these parts is like:

A{12,18,20,25,33,35,37},
B{8,13,14,40,41,45,47},
C{2,15,50,70,72,75,78}.

Now suppose in memory, we have
{12,18,20,25}
{8,13,14,40}
{2,15,50,70} respectively from A,B,C.

Now we'll select 2 from C's part as its minimum, so put this in remaining 1GB and replace 2 in memory by an element of chunk C. i.e. insert 72 in C's part in memory..

Next replace 8 by 41 and so on.. we are maintaining a min heap.