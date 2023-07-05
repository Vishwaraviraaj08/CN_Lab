import java.util.Arrays;
import java.util.stream.IntStream;

public class sample {
    static int[] data = {1,1, 0,1, 0, 1,1,0,1,1};
    static int[] divisor = {1,0, 0, 1,1};

    static int dataBits = data.length;
    static int divisorBits = divisor.length;
    static int totalLength = dataBits + divisorBits - 1;
    static int[] dividend = new int[totalLength];


    public static void main(String[] args) {
        int[] crc = calculateCRC();
        boolean check = checkCRC(crc);

        System.out.println("Dividend: ");
        printArray(data);

        System.out.println("\nCRC code: ");
        printArray(crc);

        System.out.println(check ? "CRC check passed" : "CRC check failed");
    }

    public static int[] calculateCRC() {
        for (int i = 0; i < dataBits; i++) dividend[i] = data[i];

        int[] copyOfDividend = dividend.clone();

        for (int i = 0; i < dataBits; i++) {
            if (copyOfDividend[i] != 0) {
                for (int j = 0; j < divisorBits; j++)
                    copyOfDividend[i + j] ^= divisor[j];
            }
        }
        return Arrays.copyOfRange(copyOfDividend, dataBits, totalLength);

    }


    public static boolean checkCRC(int[] crc) {
        for(int i = 0;i<divisorBits-1;i++)  dividend[dataBits+i] = crc[i];

        for (int i = 0; i < dataBits-1; i++) {
            if (dividend[i] != 0) {
                for (int j = 0; j < divisorBits; j++)
                    dividend[i + j] ^= divisor[j];
            }
        }
        return IntStream.range(dataBits, crc.length).allMatch(i -> i == 0);
    }



    static void printArray(int[] array) {
        for (int value : array)
            System.out.print(value);
        System.out.println();
    }
}
