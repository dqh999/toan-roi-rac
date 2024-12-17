import java.util.Arrays;

public class NextPermutation{
    public static void main(String[] args) {
        // Hoán vị ban đầu
        char[] arr = {'1','2','8','A','7','B','6','5','9','3','4'};

        for (int i = 0; i < 24; i++) {
            if (nextPermutation(arr)) {
                System.out.println("Hoán vị " + (i + 1) + ": " + new String(arr));
            } else {
                System.out.println("Không còn hoán vị tiếp theo.");
                break;
            }
        }
    }

    public static boolean nextPermutation(char[] arr) {
        // Bước 1: Tìm chỉ số 'k' sao cho arr[k] < arr[k + 1]
        int k = arr.length - 2;
        while (k >= 0 && arr[k] >= arr[k + 1]) {
            k--;
        }
        // Nếu không tìm được k, nghĩa là hoán vị hiện tại là hoán vị cuối cùng
        if (k < 0) {
            return false;
        }

        // Bước 2: Tìm chỉ số 'l' sao cho arr[k] < arr[l]
        int l = arr.length - 1;
        while (arr[k] >= arr[l]) {
            l--;
        }

        // Bước 3: Hoán đổi arr[k] và arr[l]
        swap(arr, k, l);

        // Bước 4: Đảo ngược phần còn lại sau k
        reverse(arr, k + 1);
        System.out.println(Arrays.toString(arr));
        return true;
    }

    // Hàm hoán đổi hai phần tử trong mảng
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Hàm đảo ngược mảng từ chỉ số 'start' đến hết
    private static void reverse(char[] arr, int start) {
        int end = arr.length - 1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}
