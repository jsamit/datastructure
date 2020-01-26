import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        while(testcase-- > 0) {
    
            int op = sc.nextInt();
            
            switch(op) {
                case 1:
                    st1.push(sc.nextInt());
                    break;

                case 2:
                    if(!st2.isEmpty())
                        st2.pop();
                    else
                    {
                        while(!st1.isEmpty())
                            st2.push(st1.pop());
                        
                        st2.pop();
                    }
                    break;
                case 3:
                    if(!st2.isEmpty())
                        System.out.println(st2.peek());
                    else
                    {
                        while(!st1.isEmpty())
                            st2.push(st1.pop());
                        
                        System.out.println(st2.peek());
                    }
                    break;
                default:
                    break;
            }
        }

    }
}

