package MassiveSorting.util;

public class MathSet<Nums extends Number & Comparable<Nums>> {
    private int size;
    private int capacity;
    private Nums[] mathSet;

    public MathSet() {
        capacity = 10;
        mathSet = (Nums[]) new Number[capacity];
        size = 0;
    }

    public MathSet(int capacity) {
        this.mathSet = (Nums[]) new Number[capacity];
    }

    public MathSet(Nums[] numbers) {
        mathSet = removeDuplicates(numbers);
        size = numbers.length;
    }

    public MathSet(Nums[]... numbers) {
        capacity = 10;
        mathSet = (Nums[]) new Number[capacity];
        for (Nums[] x : numbers) {
            add(x);
        }
    }

    public void add(Nums n) {
        if (!contains(n)) {
            if (size == capacity) {
                Nums[] temp = (Nums[]) new Number[capacity * 2];
                System.arraycopy(mathSet, 0, temp, 0, capacity);
                capacity = capacity * 2;
                mathSet = temp;
            }
        }
        mathSet[size++] = n;
    }


    public void add(Nums... n) {
        for (Nums number : n) {
            add(number);
        }
    }


    public MathSet(MathSet numbers) {
        capacity = numbers.capacity;
        mathSet = (Nums[]) new Number[capacity];
        for (int i = 0; i < numbers.size; i++) {
            add((Nums) numbers.mathSet[i]);
        }
        size = numbers.size;
    }

    public MathSet(MathSet... numbers) {
        capacity = 10;
        mathSet = (Nums[]) new Number[capacity];
        for (MathSet<Nums> number : numbers) {
            for (int i = 0; i < number.size; i++) {
                add(number.mathSet[i]);
            }
        }
    }

    public void sortAsc() {
        sortAsc(0, size);
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        if ((lastIndex - firstIndex) > 0) {
            for (int i = firstIndex; i < lastIndex - 1; i++) {
                for (int k = i + 1; k < lastIndex; k++) {
                    if (mathSet[i].compareTo(mathSet[k]) > 0) {
                        Nums temp = mathSet[i];
                        mathSet[i] = mathSet[k];
                        mathSet[k] = temp;
                    }
                }
            }
        }
    }


    public Nums[] removeDuplicates(Nums[] numbers) {
        int end = numbers.length;
        for (int i = 0; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (numbers[i] == numbers[j]) {
                    int shiftLeft = j;
                    for (int k = j + 1; k < end; k++, shiftLeft++) {
                        numbers[shiftLeft] = numbers[k];
                    }
                    end--;
                    j--;
                }
            }
        }
        if (end != numbers.length) {
            Nums[] b = (Nums[]) new Number[end];
            System.arraycopy(numbers, 0, b, 0, end);
            numbers = b;
        }
        return numbers;
    }

    private boolean contains(Nums n) {
        boolean contained = false;
        for (int i = 0; i < capacity; i++) {
            if (n.equals(mathSet[i])) {
                contained = true;
                break;
            }
        }
        return contained;
    }

    int getIndex(Nums value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (mathSet[i].equals(value)) {
                index = i;
            }
        }
        return index;
    }

    public int size() {
        return size;
    }

    public Nums get(int index) {
        if (index < 0 || index > size) throw new IllegalArgumentException("Incorrect index");
        return mathSet[index];
    }
}
