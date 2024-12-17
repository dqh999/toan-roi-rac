import java.util.*;

public class NextCombination {

    public static void main(String[] args) {
        // Tập hợp các phần tử
        char[] set = {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        // Tổ hợp ban đầu
        String currentCombination = "136789ADF";
        // Số lượng phần tử trong tổ hợp
        int r = 9;
        // Số tổ hợp cần tìm
        int k = 24;

        // Tìm vị trí các tổ hợp liền sau
        List<String> nextCombinations = findNextCombinations(set, currentCombination, r, k);

        // In kết quả
        System.out.println("24 tổ hợp liền sau của " + currentCombination + ":");
        for (String combination : nextCombinations) {
            System.out.println(combination);
        }
    }

    // Hàm tìm các tổ hợp liền sau
    public static List<String> findNextCombinations(char[] set, String currentCombination, int r, int k) {
        List<String> result = new ArrayList<>();

        // Tạo danh sách từ tập hợp ban đầu để tìm thứ tự từ điển
        List<Character> elements = new ArrayList<>();
        for (char c : set) {
            elements.add(c);
        }

        // Chuyển tổ hợp ban đầu thành mảng số nguyên đại diện cho chỉ số trong tập hợp
        int[] indices = new int[r];
        for (int i = 0; i < r; i++) {
            indices[i] = elements.indexOf(currentCombination.charAt(i));
        }

        // Sinh các tổ hợp liền sau
        for (int i = 0; i < k; i++) {
            if (!getNextCombination(indices, set.length, r)) {
                break; // Nếu không còn tổ hợp liền sau, dừng
            }
            // Tạo tổ hợp mới từ chỉ số
            StringBuilder combination = new StringBuilder();
            for (int index : indices) {
                combination.append(set[index]);
            }
            result.add(combination.toString());
        }

        return result;
    }

    // Hàm sinh tổ hợp liền sau
    private static boolean getNextCombination(int[] indices, int n, int r) {
        // Tìm vị trí từ cuối lên đầu mà có thể tăng chỉ số
        int i = r - 1;
        while (i >= 0 && indices[i] == n - r + i) {
            i--;
        }

        // Nếu không tìm thấy vị trí có thể tăng, tổ hợp cuối cùng đã đạt
        if (i < 0) {
            return false;
        }

        // Tăng chỉ số tại vị trí tìm được
        indices[i]++;

        // Đặt lại các chỉ số sau đó
        for (int j = i + 1; j < r; j++) {
            indices[j] = indices[j - 1] + 1;
        }

        return true;
    }
}
