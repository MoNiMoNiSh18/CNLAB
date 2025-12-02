import java.util.*;

public class LeakyBucket {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter bucket size: ");
        int bucketSize = sc.nextInt();

        System.out.print("\nEnter number of groups: ");
        int n = sc.nextInt();

        int totalPackets = 0, requiredBandwidth = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("\nEnter number of packets for group " + i + ": ");
            int packets = sc.nextInt();

            System.out.print("Enter input bandwidth for group " + i + ": ");
            int inBW = sc.nextInt();

            totalPackets += packets;

            if (totalPackets > bucketSize) {
                int drop = totalPackets - bucketSize;
                System.out.println("\nBucket Overflow!");
                System.out.println(drop + " packets are dropped.");

                totalPackets = bucketSize;
                packets -= drop;
            }

            requiredBandwidth += packets * inBW;
        }

        System.out.println("\nTotal Required Bandwidth = " + requiredBandwidth);

        System.out.print("Enter output bandwidth: ");
        int outBW = sc.nextInt();

        int remainingPackets = totalPackets;
        int remainingBW = requiredBandwidth;

        while (remainingPackets > 0 && remainingBW >= outBW) {
            remainingPackets--;
            remainingBW -= outBW;

            System.out.println("\nData Sent");
            System.out.println(remainingPackets + " packets remaining");
            System.out.println("Remaining Bandwidth: " + remainingBW);

            if (remainingBW < outBW && remainingPackets > 0) {
                System.out.println("\n" + remainingPackets + 
                    " packet(s) are not confirmed due to insufficient bandwidth.");
            }
        }

        sc.close();
    }
}
