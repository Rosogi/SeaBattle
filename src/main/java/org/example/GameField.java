package org.example;

public class GameField {
    private char[][] gameField;
    private char[][] enemyFiled;
    private final char freeSpot = '@';
    private final char playerSpot = 'S';
    private final char hitSpot = 'X';
    private final char missSpot = '.';

    //gameField[y cord][x cord] - only like that!

    public GameField(){
        gameField = new char[10][10];
        enemyFiled = new char[10][10];
        fillTable(gameField);
        fillTable(enemyFiled);
    }

    public GameField(int size){
        gameField = new char[size][size];
        enemyFiled = new char[size][size];
        fillTable(gameField);
        fillTable(enemyFiled);
    }

    public void showTable(){
        for (int i = 0; i < gameField.length; i++){
            for (int x = 0; x < gameField.length; x++){
                System.out.print(gameField[i][x] + " ");
            }
            System.out.println();
        }
    }

    // orientation: 1 - горизонтальная (х---), 2 - вертикальная (|),
    // 3 - ортогоризонтальная (---x), 4 - ортовертикальная(|);
    public void placeShip(int size, int x1, int y1, int orientation){

        if (x1 < 0 || y1 < 0 || x1 > gameField.length || y1 > gameField.length || checkPlacement(size, x1, y1, orientation)){
            System.out.println("Введите кординаты головной палубы не выступающие за пределы игрового поля!");
        }
        else{
            switch (orientation){
                case 1:
                   for (int i = 0; i < size; i++){
                       gameField[y1][x1 + i] = playerSpot;
                   }
                   break;
                case 2:
                    for (int i = 0; i < size; i++){
                        gameField[y1 + i][x1] = playerSpot;
                    }
                    break;
                case 3:
                    for (int i = 0; i < size; i++){
                        gameField[y1][x1 - i] = playerSpot;
                    }
                    break;
                case 4:
                    for (int i = 0; i < size; i++){
                        gameField[y1 - i][x1] = playerSpot;
                    }
                    break;
            }
        }
    }

    private boolean checkPlacement(int size, int x1, int y1, int orientation){

        switch (orientation){
            case 1:
                return x1 + size > gameField.length;
            case 2:
                return y1 + size > gameField.length;
            case 3:
                return x1 - size < 0;
            case 4:
                return y1 - size < 0;
            default:
                return false;

        }
    }

    private void fillTable(char[][] gameField){
        for (int i = 0; i < gameField.length; i++){
            for (int x = 0; x < gameField.length; x++){
                gameField[x][i] = freeSpot;
            }
        }
    }
}
