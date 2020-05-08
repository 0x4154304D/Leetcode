//1
class Solution {
    public String defangIPaddr(String address) {
        String tmp = "[.]";
        String[] arr = address.split("\\.");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            res.append(arr[i]);
            if (i != arr.length - 1) {
                res.append(tmp);
            }
        }
        return res.toString();
    }
}

// 2
class Solution {
    public String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < address.length(); ++i) {
            if (address.charAt(i) == '.') {
                res.append("[.]");
            } else {
                res.append(address.charAt(i));
            }
        }
        return res.toString();
    }
}