class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int count = 0;
        int start = 0;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            count += words[i].length();
            if (count > maxWidth) {
                ans.add(helper(start, i - 1, words, maxWidth));
                start = i;
                count = words[i].length();
            }
            count++;
        }

        ans.add(helper(start, n - 1, words, maxWidth));
        return ans;
    }

    private String helper(int start, int end, String[] words, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        if (start == end) {
            one(start, words, maxWidth, sb);
        } else if (end == words.length - 1) {
            last(start, end, words, maxWidth, sb);
        } else {
            normal(start, end, words, maxWidth, sb);
        }
        return sb.toString();
    }

    private void last(int start, int end, String[] words, int maxWidth, StringBuilder sb){
        int count = 0;
        for (int i = start; i <= end; i++){
            count += words[i].length();
            if (i != end)count++;
        }
        int space = maxWidth - count;
        for (int i = start; i <= end; i++){
            sb.append(words[i]);
            if (i != end) sb.append(" ");
        }

        for (int i = 0; i < space; i++) {
            sb.append(" ");
        }
    }

    private void one(int start, String[] words, int maxWidth, StringBuilder sb){
        int space = maxWidth - words[start].length();
        sb.append(words[start]);
        while(space-- > 0){
            sb.append(" ");
        }
    }

    private void normal(int start, int end, String[] words, int maxWidth, StringBuilder sb){
        int numOfGap = end - start;
        int count = 0;
        for (int i = start; i <= end; i++) {
            count += words[i].length();
        }
        int space = (maxWidth - count) / numOfGap;
        int remain = (maxWidth - count) % numOfGap;
        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            if (i != end){
                for (int j = 0; j < space; j++){
                    sb.append(" ");
                }
            }
            if (remain > 0){
                sb.append(" ");
                remain--;
            }
        }
    }
}