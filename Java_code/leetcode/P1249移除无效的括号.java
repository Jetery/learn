class Solution {
    public String minRemoveToMakeValid(String s) {
        
        int n = s.length();
        
        Stack<Character> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
                index.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    index.pop();
                } else {
                    index.push(i);
                }
            }
        }
        
        int m = index.size();
        if (m == 0) return s;
        
        int[] arr = new int[m];
        for (int i = m - 1; i >= 0; i--) {
            arr[i] = index.pop();
        }
        
        StringBuffer newString = new StringBuffer();
        int flag = 0;
        for (int i = 0; i < n; i++) {
            
            if (i == arr[flag]) {
                if (flag != m - 1) {
                    flag++;
                }
                continue;
            }
            
            newString.append(s.charAt(i));
        }
        return newString.toString();
    }
}