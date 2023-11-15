import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> directoryLevel = new Stack<String>();
        for (String dir : path.split("/")) {
            if (dir.isEmpty() || dir.equals("."))
                continue;
            if (dir.equals("..")) {
                if (!directoryLevel.isEmpty())
                    directoryLevel.pop();
                continue;
            }
            directoryLevel.push(dir);
        }

        StringBuilder canonicalPath = new StringBuilder();
        for (String directory : directoryLevel) {
            canonicalPath.append("/");
            canonicalPath.append(directory);
        }

        return canonicalPath.isEmpty() ? "/" : canonicalPath.toString();
    }
}