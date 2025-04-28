package soal3;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LotreBoard lotreBoard = new LotreBoard();
        
        System.out.println("Welcome to E-Lottery Gosok");
        lotreBoard.displayBoard();
        
        boolean gameRunning = true;
        while (gameRunning) {
            System.out.print("Masukkan tebakan anda (baris dan kolom) : ");
            int baris = scanner.nextInt();
            int kolom = scanner.nextInt();
            
            boolean isSafe = lotreBoard.guess(baris, kolom);
            System.out.println("Kotak " + (isSafe ? "Aman" : "Berisi bom!"));
            
            lotreBoard.displayBoard();
            
            if (!isSafe) {
                System.out.println("Game Over! Anda mengenai bom!");
                gameRunning = false;
            } else if (lotreBoard.isGameOver()) {
                System.out.println("Selamat! Anda berhasil membuka semua kotak aman!");
                gameRunning = false;
            }
        }
        
        scanner.close();
    }
}
