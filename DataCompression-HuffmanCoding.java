import java.util.*;
// "static void main" must be defined in a public class.
public class program7 {
    
    static class HuffManNode{
        int value ;
        char ch;
        
        HuffManNode left;
        HuffManNode right;
    }
    
    
    public static void printHuffManCode(HuffManNode root, String s){
        if(root.left==null && root.right==null && Character.isLetter(root.ch)){
            System.out.println(root.ch + ":" + s);
            return ;
        }
        
        printHuffManCode(root.left,s+"0");
        printHuffManCode(root.right,s+"1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of codes please ");
        String str = sc.next();
        int n = Integer.parseInt(str);
        char[] charArr = new char[n];
        int[] freqArr = new int[n];
        for(int i=0;i<n;i++){
            charArr[i]=(char)(i+65);
            freqArr[i]=(i+6);
        }
        
        PriorityQueue<HuffManNode> pq = new PriorityQueue<>((a,b)-> a.value-b.value);
        for(int i=0;i<n;i++){
            HuffManNode hmc = new HuffManNode();
            hmc.ch = charArr[i];
            hmc.value= freqArr[i];
            pq.add(hmc);
        }
        
        HuffManNode root = null;
        while(pq.size()>1){
            HuffManNode a = pq.poll();
            HuffManNode b = pq.poll();
            int sum = a.value+b.value;
            HuffManNode hmc = new HuffManNode();
            hmc.ch = '*';
            hmc.value = sum;
            hmc.left=a;
            hmc.right=b;
            root = hmc;
            pq.add(hmc);
        }
        printHuffManCode(root,"");
        
        
    }
}
