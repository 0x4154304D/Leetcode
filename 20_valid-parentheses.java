// 字符数组处理
class Solution {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        char[] stack = new char[chars.length];
        int index = 0;
        for (char aChar : chars) {
            switch (aChar) {
                case '{':
                    stack[index++] = '}';
                    break;
                case '[':
                    stack[index++] = ']';
                    break;
                case '(':
                    stack[index++] = ')';
                    break;
                default:
                    if (index == 0 || stack[index - 1] != aChar) {
                        return false;
                    } else {
                        index--;
                    }
            }
        }
        return index == 0;
    }
}

// 内置栈处理
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '[')
                stack.push(']');
            else if (c == '{')
                stack.push('}');
            else if (stack.isEmpty() || c != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }
}

// List模拟栈
class Solution {
    public boolean isValid(String s) {
        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            if (!stack.isEmpty() && (stack.get(stack.size() - 1) + 1 == s.charAt(i)
                    || stack.get(stack.size() - 1) + 2 == s.charAt(i))) {
                stack.remove(stack.size() - 1);
                continue;
            }
            stack.add(s.charAt(i));
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}