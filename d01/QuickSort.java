package d01;

import java.util.ArrayList;

public class QuickSort {
    private ArrayList<Integer> list;

    QuickSort(ArrayList<Integer> list1) {
        this.list = list1;
    }

    public ArrayList<Integer> sort() {
        return quickSort(0, this.list.size() - 1);
    }

    private ArrayList<Integer> quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);

            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
        return this.list;
    }

    private int partition(int low, int high) {
        int pivot = this.list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (this.list.get(j) <= pivot) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        int temp = this.list.get(i);
        this.list.set(i, this.list.get(j));
        this.list.set(j, temp);
    }
}
