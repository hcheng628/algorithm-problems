package us.supercheng.algorithm.problems.leetcode.longpressedname;

public class App {
    public boolean isLongPressedName(String name, String typed) {
        if(name == null && typed == null)
            return true;

        if(name == null && typed.length() == 0)
            return true;
        else if (name == null)
            return false;

        if(typed == null && name.length() == 0)
            return true;
        else if(typed == null)
            return false;

        if(typed.length() == 0 && name.length() == 0)
            return true;

        int nameIndex = 0;
        char [] chars = typed.toCharArray();
        for(int i=0;i<chars.length && nameIndex < name.length();i++,nameIndex++)
            if(chars[i] != name.charAt(nameIndex)) {
                if(i==0)
                    return false;
                for(;chars[i-1] == chars[i] && i < chars.length-1;i++);
                if(chars[i] != name.charAt(nameIndex))
                    return false;
            }
        return nameIndex == name.length() ;
    }
}