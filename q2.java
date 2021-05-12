import java.util.*;

public class q2 {

    public static int LastNumber(int target) {

        // convert the int to a string
        Integer val = target;
        String s = val.toString();

        // index is the location where we break out of the loop 
        int index = 0;

        int size = s.length();
        char[] chars = s.toCharArray();

        //looping to find whether the number is acceptable or we should find the correct number befor it
        for (int i = 0; i < size; i++) {
            if (i == 0)
                continue;
            if (s.charAt(i) >= s.charAt(i - 1))
                continue;
            index = i;
            break;
        }

        //if the number if acceptable we will just return it
        if (index == 0)
            return target;

        // the second half after where the number is not valid will be all set to 9
        for (int i = index; i < size; i++) {
            chars[i] = '9';
        }

        // for the firsthalf 
        int pointer2 = index - 2;
        for (int pointer1 = index - 1; pointer1 >= 0; pointer1--) {

            
            if (pointer2 >= 0) {

                // simple case example: 152
                // first half: 15 
                // we will just convert it to 14
                if (chars[pointer2] < chars[pointer1]) {
                    chars[pointer1] = (char) (chars[pointer1] - 1);
                    break;
                }

                /**
                 * more comlicated cases example: 3332
                first half: 333
                    1) will first do: 329
                    2) then will convert to : 33

                **/
                if (chars[pointer2] >= chars[pointer1]) {
                    if (chars[pointer1] > '1') {

                        chars[pointer2] = (char) (chars[pointer2] - 1);
                        chars[pointer1] = '9';
                        pointer2 -= 1;
                        if (pointer2 == -1) break;
                      }
                    else {  
                        for(int j = 0; j <= pointer1;j++) {
                            chars[j] = '9';
                           
                            }

                        s = new String(Arrays.copyOfRange(chars,1,size));
                        return Integer.parseInt(s);

                    }
              }
            }
            else {
                if (chars[pointer1] == '1') {    
                    s = new String(Arrays.copyOfRange(chars,pointer1+1,size));
                    return Integer.parseInt(s);
                }      
                chars[pointer1] -= 1;
                break;
                // System.out.println(s);
            }
        }
        s = new String(chars);
        return Integer.parseInt(s);

        // System.out.println(Integer.parseInt(s));

    }

    public static void main(String[] args) {
        System.out.println(LastNumber(11123));
        System.out.println(LastNumber(111110));
        System.out.println(LastNumber(33332));
        System.out.println(LastNumber(33425));

        
    }
}
