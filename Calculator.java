import java.util.*;
public class q1 {
    
    public static double calculator (String operations) {
        //converting the input to an array of strings where each index
        //is either a param or an operand
        
        ArrayList<String> input = new ArrayList<String>(); 
        String integer = "";
        String add="";
        for (int i = 0; i < operations.length();i++) {
            char c =operations.charAt(i);
            
            if (!Character.isDigit(c)) {
                add+=c;
                input.add(add);
                add = "";
            }
            else {
                integer+= c;
                
                //adding the para to the list 
                //reseting the integer string to hold the next param
                if (i == operations.length() -1 || !Character.isDigit(operations.charAt(i+1))) {
                    input.add(integer);
                    integer = "";
                }
            }
            
        }
    
       // for (String i: input) System.out.println(i);
        return helper(input);
        
        
    }
    public static double helper(List<String> op_list) {
       // for (String i: op_list) System.out.println(i);
        if (op_list.size() == 0) return 0;
        if (op_list.size() == 1) return Double.parseDouble(op_list.get(0));
        int start,end;
        start = end = 0;
        int size = op_list.size();
        double res = 0;
        double operand1 = 1;
        int i  = 0;
        while (i < size) {
        //for (int i = 0; i < size; i++) {
            String val = op_list.get(i);
                       


            if(val.equals("(")) {
                start = i+1;
                while (!val.equals(")")) {
                    i++;
                    val = op_list.get(i);

                }
                end = i;
                        

                res = helper(op_list.subList(start,end));
                operand1 = res;
                    //op_list.set(end,String.valueOf(res)) ;
                i++;
                
            }
            else if(val.equals("*") || val.equals("/")) {
                double operand2 = Double.parseDouble(op_list.get(i+1));
                
                if (val.equals("*")) {
                    res = operand1*operand2;
                    operand1 = res;

                }
                else {
                    res = (double)(operand1 / operand2);
                   
                    operand1 = res;

                }
                i+=2;
                //op_list.set(i+1,String.valueOf(res)) ;
            } 

            else if (val.equals("+") || val.equals("-")) {
                //System.out.println("here"+operand1+" ");

                if (val.equals("+") ) { 
                    operand1 += helper(op_list.subList(i+1,size));
                    return operand1;
                }
                if (val.equals("-")) {
                    operand1 -= helper(op_list.subList(i+1,size));
                    return operand1;
                }
                i++;
            }
            else {
                //System.out.println("error"+val);
                operand1 = Double.parseDouble(val);
                i++;
            }
            
        }
        return res;
    }
    
    
    public static void main(String[] args) {
        System.out.println(calculator("1+2"));
        System.out.println(calculator("2*3"));
        System.out.println(calculator("1+2*3"));
        System.out.println(calculator("(1+2)*3"));
        System.out.println(calculator("(1+2+3)*3"));
        System.out.println(calculator("(5+8)*3/8+10"));

        


        

    }
}
