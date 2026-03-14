class Solution {

    List<String> list = new ArrayList<>();

    public String getHappyString(int n, int k) {
        backtrack("", n);

        if (k > list.size()) return "";
        return list.get(k - 1);
    }

    private void backtrack(String curr, int n) {
        if (curr.length() == n) {
            list.add(curr);
            return;
        }

        for (char ch : new char[]{'a','b','c'}) {
            if (curr.length() > 0 && curr.charAt(curr.length()-1) == ch)
                continue;

            backtrack(curr + ch, n);
        }
    }
}