
Assumptions for questions1:<br/>

Input is valid because the solution doesn't check for invalid characters <br/>
there is no space in the input string example: "(5+8)*3/8+10"


Solution explanation for question1 <br/>:

1) we break the given string input into an array of strings so then we have an array of the operans and the operators <br/>
2) we pass the array of string to a recurisve function
3) the function will loop through the elements in the given array 
4) if we have * or / the function doesnt recurse and calculates the value and set the result as the operand for the next operator and continue looping
5) if we have ( the function will loop operate recursively to calculate the values that are inside the ()
6) if we have + or - the function will keep the first operand and the operator and will recurse through the rest of the remaining arrays to calculate the other operations. once it returns it will add the calculated the result and the first operand that it had kept






