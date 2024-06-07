#!/bin/bash
for i in {01..40}; do
    echo "Running test ${i}:"
    javac testcases/Test${i}.java
    java testcases.Test${i}
done
