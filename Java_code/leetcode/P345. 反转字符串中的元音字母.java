class Solution {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if (vowels(c[i]) && vowels(c[j])) {
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                i++;
                j--;
            } else {
                if (!vowels(c[i])) {
                    i++;
                }
                if (!vowels(c[j])) {
                    j--;
                }
            }
        }
        return new String(c);
    }

    static String mod = "aAeEiIoOUu";
    private boolean vowels(char ch) {
        return mod.contains(ch + "");
    }
}


//优化
class Solution {


    //模拟hash
    static boolean[] hash = new boolean[128];
    static char[] vowels = new char[] {'a','e','i','o','u'};
    static {
        for(char c : vowels) {
            hash[c] = hash[Character.toUpperCase(c)]  = true;
        }
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if(hash[chars[i]] && hash[chars[j]]) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            } else {
                if (!hash[chars[i]]) i++;
                if (!hash[chars[j]]) j--;
            }
        }
        return String.valueOf(chars);
    }
}


//直接使用set
class Solution {
    static HashSet<Character> hash = new HashSet<>();
    static char[] vowels = new char[] {'a','e','i','o','u'};
    static {
        for(char c : vowels) {
            hash.add(c);
            hash.add(Character.toUpperCase(c));
        }
    }
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if(hash.contains(chars[i]) && hash.contains(chars[j])) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            } else {
                if (!hash.contains(chars[i])) i++;
                if (!hash.contains(chars[j])) j--;
            }
        }
        return String.valueOf(chars);
    }
}