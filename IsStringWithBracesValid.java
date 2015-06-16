import java.io.*;
import java.util.*;

/*
 
 (), [], {},...

 * Valid
 * asdhgh2475$^$%!&$.,.,.
 * (the string)
 * ([the string])
 * ([the] string{})
 * (((the ([( words )]))))
 
 
 * Invalid
 * ([the string)]
 * (the string
 * )the string( 
 * (((the ([( words ])))))
 * ([{])}
 
 * ([) the string]
 */





class IsStringWithBracesValid {
  
  public static boolean isStringValid(String string) {
    Stack<Character> s = new Stack<Character>();
    for(int i=0;i<string.length();i++)
      {
      if(string.charAt(i) == '(' || string.charAt(i) == '{' || string.charAt(i) == '[')
        {
        s.push(string.charAt(i)); 
      }
      if(string.charAt(i) == ')')
        {
        if(s.isEmpty() || s.peek() != '(') return false;
        else s.pop();
      }
      if(string.charAt(i) == ']')
        {
        if(s.isEmpty() || s.peek() != '[') return false;
        else s.pop();
      }
      if(string.charAt(i) == '}')
        {
        if(s.isEmpty() || s.peek() != '{') return false;
        else s.pop();
      }
    }
    //System.out.println("Debug message");
    if(!s.isEmpty()) return false;
    else return true;
  }
  
  
  public static void main(String[] args) 
      {
      System.out.println(isStringValid("(((the ([( words )]))))"));
    }
}
