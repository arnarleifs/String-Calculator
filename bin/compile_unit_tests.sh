#!/bin/bash

javac -cp '../classes:../lib/junit-4.12.jar:../lib/hamcrest-core-1.3.jar' ../src/test/java/is/ru/stringcalculator/StringCalculatorJUnit.java -d ../classes
