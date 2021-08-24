    public boolean judge (int x) {
        // write code here
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        if(chars[0] == chars[chars.length-1]){
            return true;
        }else{
            return false;
        }
    }
}
