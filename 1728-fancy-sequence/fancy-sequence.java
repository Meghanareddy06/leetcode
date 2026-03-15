import java.util.*;

class Fancy {

    static final long MOD = 1000000007;
    List<Long> seq;
    long mul = 1;
    long add = 0;

    public Fancy() {
        seq = new ArrayList<>();
    }

    public void append(int val) {
        long inv = modInverse(mul);
        long stored = ((val - add + MOD) % MOD * inv) % MOD;
        seq.add(stored);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= seq.size()) return -1;
        long val = seq.get(idx);
        return (int)((val * mul + add) % MOD);
    }

    private long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    private long pow(long x, long n) {
        long res = 1;
        x %= MOD;
        while (n > 0) {
            if ((n & 1) == 1) res = (res * x) % MOD;
            x = (x * x) % MOD;
            n >>= 1;
        }
        return res;
    }
}