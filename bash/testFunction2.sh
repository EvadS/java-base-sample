#!/bin/bash


# define a function
# testfunction(){
#    echo "---> test function"
#    echo $1
#    echo $2
# }
#
##  and then call defined function
#  testfunction "Hello" "World"




function print_param_value(){
    value1="${1}" # $1 represent first argument
    value2="${2}" # $2 represent second argument
    echo "param 1 is  ${value1}" # As string
    echo "param 2 is ${value2}"
    sum=$(($value1+$value2)) # Process them as number
    echo "The sum of two value is ${sum}"
}


print_param_value "$1" "$2" # Parameter $1 and $2 during execution
