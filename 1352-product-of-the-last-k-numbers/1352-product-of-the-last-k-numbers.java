import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    private final List<Number> list;

    public ProductOfNumbers() {
        this.list = new ArrayList<>();
        list.add(new Number(1, 0));
    }

    public void add(int num) {
        if (num == 0) {
            list.add(new Number(1, list.get(list.size() - 1).zeroCount + 1));
        } else {
            Number prev = list.get(list.size() - 1);
            list.add(new Number(prev.value * num, prev.zeroCount));
        }
    }

    public int getProduct(int k) {
        int i = list.size() - k;

        Number curr = list.get(list.size() - 1);
        Number prev = list.get(i - 1);

        if (curr.zeroCount > prev.zeroCount) {
            return 0;
        }

        return (int) (curr.value / prev.value);
    }

    static class Number {
        long value;
        int zeroCount;

        public Number(long value, int zeroCount) {
            this.value = value;
            this.zeroCount = zeroCount;
        }
    }
}