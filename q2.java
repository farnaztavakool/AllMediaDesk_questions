import java.util.*;
public class q2 {
    
    public static int LastNumber(int target) {
        //convert the int to a string

        Integer val = target;
        String s = val.toString();
        int index = 0;
        int size = s.length();
        char[] chars = s.toCharArray();

        for(int i = 0; i < size;i++) {
            if (i == 0) continue;
            if (s.charAt(i) >= s.charAt(i-1)) continue;
            index = i;
            break;
        }
        // the second half after where the number is not valid will be all set to 9
       if (index == 0) return target;
        for (int i = index; i<size;i++) {
            chars[i] = '9';
        }

        //for the firsthalf
        int pointer2 = index-2;
        for (int pointer1 = index-1;pointer1 >= 0; pointer1--) {
            // if pointer2 > 0
            if(pointer2 >= 0) {
                if (chars[pointer2] < chars[pointer1]) {
                    chars[pointer1] = (char)(chars[pointer1] -1);
                    //s.charAt(pointer1) = s.charAt(pointer1)-1;
                    break;
                }
                if (chars[pointer2] >= chars[pointer1]) {
                    if (chars[pointer2] > 1) {

                        chars[pointer2] = (char)(chars[pointer2]-1);
                        chars[pointer1] = '9';
                        pointer2-=1;
                    }
                    else {
                        for(int j = 0; j <= pointer2;j++) {
                            chars[j] = '9';
                        }
                        break;
                    }
                }
            }
            else {
                if (chars[pointer1] == '1') {
                    s = new String(Arrays.copyOfRange(chars,pointer1+1,size));
                    return Integer.parseInt(s);
                }
                
                chars[pointer1] -=1;
                // System.out.println(s);
            }
        }
        s  = new String(chars);
        return Integer.parseInt(s);

        //System.out.println(Integer.parseInt(s));
     
        
    }




    public static void main(String[] args){
        System.out.println(LastNumber(2));
    }
}
