package BonusExercises;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

interface Comparator {
    int compare(int a, int b);
}

class Larger implements Comparator {
    public int compare(int a, int b) {
        return a > b ? -1 : a < b ? 1 : 0;
    }
}

class Smaller implements Comparator {
    public int compare(int a, int b) {
        return a < b ? -1 : a > b ? 1 : 0;
    }
}

class Heap {
    private Comparator cmp;
    private int[] data;
    private int size;

    public Heap(int size, Comparator cmp) {
        this.cmp = cmp;
        this.data = new int[size];
        this.size = 0;
    }

    private void swap(int i1, int i2) {
        int temp = data[i1];
        data[i1] = data[i2];
        data[i2] = temp;
    }

    private int max(int lChild, int rChild) {
        if(rChild >= size) {
            return lChild;
        }

        return cmp.compare(data[lChild], data[rChild]) == -1 ? lChild : rChild;
    }

    private void sift_up(int i) {
        int parent = (i - 1) / 2;

        while(parent >= 0) {
            if(cmp.compare(data[i], data[parent]) == -1) {
                swap(i, parent);
                i = parent;
                parent = (i - 1) / 2;
            }
            else {
                break;
            }
        }
    }

    private void sift_down(int i) {
        int lChild = 2 * i + 1;
        int rChild = lChild + 1;

        while(lChild < size) {
            int largerChild = max(lChild, rChild);

            if(cmp.compare(data[largerChild], data[i]) == -1) {
                swap(largerChild, i);
                i = largerChild;
                lChild = 2 * i + 1;
                rChild = lChild + 1;
            }
            else {
                break;
            }
        }
    }

    public void add(int elem) {
        if(size < data.length) {
            data[size++] = elem;

            sift_up(size - 1);
        }
        else {
            throw new RuntimeException("max heap capacity reached: " + data.length);
        }
    }

    public int pop() {
        if(size > 0) {
            int elem = data[0];
            swap(0, --size);

            sift_down(0);

            return elem;
        }
        else {
            throw new RuntimeException("cannot pop from empty heap");
        }
    }

    public int peek() {
        if(size > 0) {
            return data[0];
        }
        else {
            throw new RuntimeException("cannot peek from empty heap");
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}

public class DynamicOS {
    static int alpha;

    static Heap maxHeap;
    static Heap minHeap;

    public static void rebalance() {
        int k = (int)Math.ceil((double)(maxHeap.size() + minHeap.size()) / (double)alpha);

        while(maxHeap.size() > k) {
            minHeap.add(maxHeap.pop());
        }

        while(maxHeap.size() < k) {
            maxHeap.add(minHeap.pop());
        }
    }

    public static void reset(int n)
    {
        maxHeap = new Heap(n, new Larger());
        minHeap = new Heap(n, new Smaller());
    }

    public static void add(int x)
    {
        if(!maxHeap.isEmpty() && x < maxHeap.peek()) {
            maxHeap.add(x);
        }
        else {
            minHeap.add(x);
        }

        rebalance();
    }

    public static int query()
    {
        return maxHeap.peek();
    }

    public static void read_and_solve(InputStream in, PrintStream out) {
        Scanner scanner = new Scanner(in);
        alpha = scanner.nextInt();

        int noperations = scanner.nextInt();
        for(int i=0; i<noperations; i++)
        {
            String operation = scanner.next();
            if(operation.equals("R"))
            {
                int n = scanner.nextInt();
                reset(n);
            }
            else if(operation.equals("A"))
            {
                int x = scanner.nextInt();
                add(x);
            }
            else if(operation.equals("Q"))
                out.println(query());
            else
                throw new RuntimeException("Unknown operation");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        read_and_solve(System.in, System.out);
    }
}
