import java.util.*;

public class CRC_CCITT {
    static final String POLY = "10001000000100001";

    public static String divide(String input) {
        char[] data = input.toCharArray();
        int polylen = POLY.length();

        for (int i = 0; i <= data.length - polylen; i++) {
            if (data[i] == '1') {
                for (int j = 0; j < polylen; j++) {
                    data[i + j] = (data[i + j] == POLY.charAt(j)) ? '0' : '1';
                }
            }
        }
        return new String(data).substring(data.length - 16);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the data to be encrypted:");
        String data = sc.nextLine();

        String appendData = data + "0000000000000000";
        String remainder = divide(appendData);

        System.out.println("Checksum = " + remainder);
        String transmitted = data + remainder;
        System.out.println("Data transmitted: " + transmitted);

        System.out.println("Enter received codeword:");
        String received = sc.nextLine();

        String check = divide(received);

        if (check.equals("0000000000000000")) {
            System.out.println("No Error");
        } else {
            System.out.println("Error in Transmission");
        }
        sc.close();
    }
}
