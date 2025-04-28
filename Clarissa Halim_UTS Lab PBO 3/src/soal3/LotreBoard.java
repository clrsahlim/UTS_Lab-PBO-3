package soal3;

import java.util.Random;

public class LotreBoard {
    private char[][] board;
    private boolean[][] revealed;
    private int [][] data;
    private final int barisBoard = 4;
    private final int kolomBoard = 5;
    private int safeBoxesRevealed = 0;
    private final int totalSafeBoxes = 18;

    public LotreBoard() {
        board = new char[barisBoard][kolomBoard];
        revealed = new boolean[barisBoard][kolomBoard];
        data = new int[barisBoard][kolomBoard];
        initializeBoard();
        generateBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < barisBoard; i++) {
            for (int j = 0; j < kolomBoard; j++) {
                board[i][j] = '*';
                revealed[i][j] = false;
                data[i][j] = 0; 
            }
        }
    }

    public void generateBoard(){
        Random random = new Random();
        int bomb = 0;
        
        while (bomb < 2) {
            int baris = random.nextInt(barisBoard);
            int kolom = random.nextInt(kolomBoard);
            
            if (data[baris][kolom] == 0) { 
                data[baris][kolom] = 1; 
                bomb++;
            }
        }
    }

    public void displayBoard() {
        for (int i = 0; i < barisBoard; i++) {
            for (int j = 0; j < kolomBoard; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean guess(int row, int col) {
        if (row < 0 || row >= barisBoard || col < 0 || col >= kolomBoard) {
            return true;
        }
        
        if (revealed[row][col]) {
            System.out.println("Kotak telah dibuka sebelumnya!");
            return true;
        }
        
        revealed[row][col] = true;
        
        if (data[row][col] == 1) { 
            board[row][col] = 'X';
            return false;
        } else { 
            board[row][col] = 'O';
            safeBoxesRevealed++;
            return true;
        }
    }

    public boolean isGameOver() {
        return safeBoxesRevealed == totalSafeBoxes;
    }
}

