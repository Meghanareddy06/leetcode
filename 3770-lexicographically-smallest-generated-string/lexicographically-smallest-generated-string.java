class Solution {
    public String generateString(String str1, String str2) {
    int n = str1.length();
        int m = str2.length();

        char[] word = new char[n + m - 1];

        // Step 1: initialize with '?'
        for (int i = 0; i < word.length; i++) {
            word[i] = '?';
        }

        // Step 2: Apply 'T' constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] == '?' || word[i + j] == str2.charAt(j)) {
                        word[i + j] = str2.charAt(j);
                    } else {
                        return "";
                    }
                }
            }
        }

        // Step 3: Fill remaining with 'a'
        for (int i = 0; i < word.length; i++) {
            if (word[i] == '?') {
                word[i] = 'a';
            }
        }

        // Step 4: Fix 'F' constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                if (matches(word, i, str2)) {
                    boolean changed = false;

                    // Try to break match from rightmost position
                    for (int j = m - 1; j >= 0 && !changed; j--) {
                        int pos = i + j;

                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == str2.charAt(j)) continue;

                            char original = word[pos];
                            word[pos] = c;

                            // Check all 'T' constraints still hold
                            if (validT(word, str1, str2)) {
                                changed = true;
                                break;
                            }

                            word[pos] = original; // revert
                        }
                    }

                    if (!changed) return "";
                }
            }
        }

        return new String(word);
    }

    // Check if substring equals str2
    private boolean matches(char[] word, int start, String str2) {
        for (int i = 0; i < str2.length(); i++) {
            if (word[start + i] != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    // Validate all 'T' constraints
    private boolean validT(char[] word, String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        return false;
                    }
                }
            }
        }
        return true;    
    }
}