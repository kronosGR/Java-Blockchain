package blockchain;

import java.util.Scanner;

public class Main {

    static final int MINERS = 4;
    static final int BLOCKS =5;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many zeros the hash must start with:");
        int number = Integer.parseInt(sc.nextLine());

        Blockchain blockchain = new Blockchain(number);
        for (int i=0; i<5; i++){
            blockchain.createNewBlock();
        }

        System.out.println(blockchain);

    }
}
