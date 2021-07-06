class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}


public int strStr(String haystack, String needle) {
  for (int i = 0; ; i++) { // The length of haystack
    for (int j = 0; ; j++) { // The length of needle
      if (j == needle.length()) return i; // If at this point we have navigated through the entire length of needle, we have found a solution, haystack[i].
      if (i + j == haystack.length()) return -1; // This happens when we run out of elements in haystack, but there are still elements in needle. 
      if (needle.charAt(j) != haystack.charAt(i + j)) break; // We stop comparing after needle[j], so i will be incremented and cycle repeats itself. 
    }
  }
}




public int strStr(String haystack, String needle) {
    // empty needle appears everywhere, first appears at 0 index
    if (needle.length() == 0)
        return 0;
    if (haystack.length() == 0)
        return -1;    
      
    for (int i = 0; i < haystack.length(); i++) {
         // no enough places for needle after i
        if (i + needle.length() > haystack.length()) break;
            
         for (int j = 0; j < needle.length(); j++) {
             if (haystack.charAt(i+j) != needle.charAt(j))
                 break;
             if (j == needle.length()-1)
                return i;
        }
    }
      
    return -1;
}