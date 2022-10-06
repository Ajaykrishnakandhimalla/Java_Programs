class Solution {
    public String evaluatePostFixExprr(String expression) {
        String[] exprrArray = expression.split("\\s+");
        Set<String> set = new HashSet(Arrays.asList("+","-","*","/"));
        
        if(exprrArray.length==0) return "Error";
        if(exprrArray.length==1){
            if(set.contains(exprrArray[0])) return "Error";
            else return exprrArray[0];
        } 
        Stack<String> stack = new Stack<>();
        int i=0;
        
        while(i<exprrArray.length){
            if(set.contains(exprrArray[i])){
                if(stack.size()<2) return "Error";
                int num2= Integer.parseInt(stack.pop());
                int num1= Integer.parseInt(stack.pop());
                switch(exprrArray[i]){
                    case "+":
                        stack.push(String.valueOf(num1+num2));
                        break;
                    case "*":
                        stack.push(String.valueOf(num1*num2));
                        break;
                    case "/":
                        stack.push(String.valueOf(num1/num2));
                        break;
                    case "-":
                        stack.push(String.valueOf(num1-num2));
                        break;
                }
            }else{
                stack.push(exprrArray[i]);
            }
            i++;
        }
        return stack.size()==1?stack.peek():"Error";
    }
    
    public static void main(String[] args){
        Solution sol = new Solution();
        String input1 = "78";
        String input2 = "78 6 +";
        String input3 = "78 6 + 9 2 - /";
        String input4 = "78 +";
        String input5 = "2 + 3";
        String input6 = "2 3 + 4";
        System.out.println("Input:"+input1+"   output:"+sol.evaluatePostFixExprr(input1));
        System.out.println("Input:"+input2+"   output:"+sol.evaluatePostFixExprr(input2));
        System.out.println("Input:"+input3+"   output:"+sol.evaluatePostFixExprr(input3));
        System.out.println("Input:"+input4+"   output:"+sol.evaluatePostFixExprr(input4));
        System.out.println("Input:"+input5+"   output:"+sol.evaluatePostFixExprr(input5));
        System.out.println("Input:"+input6+"   output:"+sol.evaluatePostFixExprr(input6));       
    }
}