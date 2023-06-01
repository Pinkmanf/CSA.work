public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 12, 1, 6, 3};
        bubbleSort(arr);
        System.out.println("冒泡排序排序结果：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        arr = new int[]{5, 2, 8, 12, 1, 6, 3};
        insertionSort(arr);
        System.out.println("插入排序排序结果：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        arr = new int[]{5, 2, 8, 12, 1, 6, 3};
        quickSort(arr,0,arr.length-1);
        System.out.println("快速排序排序结果：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        arr = new int[]{5, 2, 8, 12, 1, 6, 3};
        mergeSort(arr,0,arr.length-1);
        System.out.println("合并排序排序结果：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        arr = new int[]{5, 2, 8, 12, 1, 6, 3};
        heapSort(arr);
        System.out.println("堆排序排序结果：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

//    冒泡排序
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换arr[j]和arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

//    插入排序
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
//            将比当前元素大的元素后移，直到找到合适的位置，然后将当前元素插入。
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

//    快速排序
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
//            递归
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
//        基准点
        int pivot = arr[high];
        int i = low - 1;
//        将小于基准点的数放在最右边
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

//    合并排序
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

//    合并两个有序子数组
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

//        拆分为两个数组
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; ++i) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArr[j] = arr[mid + 1 + j];
        }

//        将较小的元素依次放入原数组arr中
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

//        将剩余的元素依次放入原数组arr中
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

//    堆排序
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 构建最大堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 依次取出堆顶元素并调整堆
        for (int i = n - 1; i > 0; i--) {
            // 将当前堆顶元素与末尾元素交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 调整堆
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // 假设当前父节点是最大的
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        // 如果左子节点大于父节点，更新最大值的索引
        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        // 如果右子节点大于父节点，更新最大值的索引
        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // 如果最大值不是当前父节点，则交换父节点和最大值
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // 递归调整被交换的子树
            heapify(arr, n, largest);
        }
    }
}
