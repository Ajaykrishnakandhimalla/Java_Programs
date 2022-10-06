import java.util.*;
public class Program9 {
    static int NO_OF_CHARS = 256;
      
    static int max (int a, int b) { return (a > b)? a: b; }

    static void checkBadCharacter( char []str, int size,int badchar[])
     {
      for (int i = 0; i < NO_OF_CHARS; i++)
           badchar[i] = -1;
      for (int i = 0; i < size; i++)
           badchar[(int) str[i]] = i;
     }

     static void search( char coreText[],  char pattern[])
     {
          boolean patternFound = false;
          int patternLength = pattern.length;
          int coreTextLength = coreText.length;

          int badchar[] = new int[NO_OF_CHARS];

          checkBadCharacter(pattern, patternLength, badchar);

          int s = 0;  
          while(s <= (coreTextLength - patternLength))
          {
              int j = patternLength-1;
              while(j >= 0 && pattern[j] == coreText[s+j])
                  j--;
              if (j < 0)
              {
                  patternFound = true;
                  System.out.println("Patterns occur at shift = " + s);
                  s += (s+patternLength < coreTextLength)? patternLength-badchar[coreText[s+patternLength]] : 1;
              }
              else
                  s += max(1, j - badchar[coreText[s+j]]);
          }
             if(!patternFound)
                 System.out.println("Unsuccessful search");
         }

    public static void main(String[] args) {
        char txt[] = "BARD LOVED BANANAS".toCharArray();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the pattern to search");
        String pattern = sc.nextLine();
        char pat[] = pattern.toCharArray();
        search(txt, pat);
    }
}
