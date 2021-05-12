
Assumptions for questions1:<br/>

Input is valid because the solution doesn't check for invalid characters <br/>
there is no space in the input string example: "(5+8)*3/8+10"


Solution explanation for question1: <br/>

1) we break the given string input into an array of strings so then we have an array of the operans and the operators <br/>
2) we pass the array of string to a recurisve function
3) the function will loop through the elements in the given array 
4) if we have * or / the function doesnt recurse and calculates the value and set the result as the operand for the next operator and continue looping
5) if we have ( the function will loop operate recursively to calculate the values that are inside the ()
6) if we have + or - the function will keep the first operand and the operator and will recurse through the rest of the remaining arrays to calculate the other operations. once it returns it will add the calculated the result and the first operand that it had kept </br>

Solution explanation for question2: <br/>

1) The function will first translate the given integer to a string and then to an array of characters
2) the function will loop through the array and ,expect for the first element, it will check if the character is bigger than the character befor it
3) once it finds the index where the character is not bigger than the one that comes befor it it will break from the loop
4) it will break the character array into two parts: one part is the part after the index where we exited the loop and one part is the remaining first part of the loop
5) it will set all of the characters in the second half to 9
6) for the first one it will start looping backward 
7) while looping backward it will check if it is simply possilbe to decrease the value of that character by 1 to solve the issue for example for the case 152 the first part which is 15 can be simply changed to 14 and the second part which is 9 which would give use 149
8) else it will keep looping to fix the number






