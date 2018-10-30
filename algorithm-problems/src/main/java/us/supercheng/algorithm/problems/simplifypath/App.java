package us.supercheng.algorithm.problems.simplifypath;

import java.util.Stack;

public class App {

    public String simplifyPath(String path) {
        if(path == null || path.length() == 0)
            return "/";

        if(path.charAt(path.length()-1) != '/')
            path += '/';
        Stack<String> stack = new Stack<>();
        char[] chars = path.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<chars.length;i++) {
            if(chars[i] == '/') {
                if(sb.length()>0) {
                    stack.push(sb.toString());
                    sb.setLength(0);
                }
                boolean dupBack = false;
                for(;i<chars.length && chars[i] == '/';i++)
                    if(!dupBack)
                        dupBack = true;
                if(dupBack)
                    i--;
            }
            if(this.isMovingUp(chars, i)) {
                if(!stack.isEmpty())
                    stack.pop();
                i+=2;
                continue;
            }
            if(this.isStaying(chars, i)) {
                i++;
                continue;
            }
            if(chars[i] != '/')
                sb.append(chars[i]);
        }

        if(stack.size() == 0)
            return "/";

        while(!stack.isEmpty())
            sb.insert(0, "/" + stack.pop());

        return sb.toString();
    }

    private boolean isInRange(char[] chars, int index) {
        return index < chars.length;
    }

    private boolean isMovingUp(char[] chars, int index) {
        if(this.isInRange(chars, index + 3) && chars[index] == '/' && chars[index+1] == '.' && chars[index+2] == '.' && chars[index+3] == '/')
            return true;
        return false;
    }

    private boolean isStaying(char[] chars, int index) {
        if(this.isInRange(chars, index+2) && chars[index]=='/' && chars[index+1] == '.' && chars[index+2] == '/')
            return true;
        return false;
    }
}
