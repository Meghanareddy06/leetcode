class Solution {
    public int bitwiseComplement(int n) {
        String binary = Integer.toBinaryString(n);
        String f = "";

        for(int i = 0; i < binary.length(); i++){
            if(binary.charAt(i) == '0')
                f += '1';
            else
                f += '0';
        }

        return Integer.parseInt(f, 2);
    }
}