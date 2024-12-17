public class BaseConversion {
    public static void main(String[] args) {
        // Số trong hệ cơ số 11
        String numberInBase11 = "7626585";
        int base11 = 11;
        int base6 = 6;

        // Bước 1: Chuyển số từ cơ số 11 sang hệ thập phân
        int decimalNumber = convertToDecimal(numberInBase11, base11);

        // Bước 2: Chuyển số từ hệ thập phân sang cơ số 6
        String numberInBase6 = convertFromDecimal(decimalNumber, base6);

        // In kết quả
        System.out.println("Số " + numberInBase11 + " trong cơ số 11 khi chuyển sang cơ số 6 là: " + numberInBase6);
    }

    // Hàm chuyển từ cơ số bất kỳ về hệ thập phân
    public static int convertToDecimal(String number, int base) {
        int decimal = 0;
        int length = number.length();

        for (int i = 0; i < length; i++) {
            char digit = number.charAt(i);
            int value;

            // Nếu ký tự là chữ cái (A-Z), chuyển thành giá trị số (10-35)
            if (Character.isDigit(digit)) {
                value = digit - '0';
            } else {
                value = digit - 'A' + 10;
            }

            // Tính giá trị trong hệ thập phân
            decimal = decimal * base + value;
        }

        return decimal;
    }

    // Hàm chuyển từ hệ thập phân sang cơ số bất kỳ
    public static String convertFromDecimal(int decimal, int base) {
        StringBuilder result = new StringBuilder();

        while (decimal > 0) {
            int remainder = decimal % base;

            // Chuyển số dư thành ký tự (0-9 hoặc A-Z)
            if (remainder < 10) {
                result.append((char) ('0' + remainder));
            } else {
                result.append((char) ('A' + (remainder - 10)));
            }

            decimal /= base;
        }

        // Đảo ngược chuỗi kết quả vì nó được tính từ dưới lên
        return result.reverse().toString();
    }
}
