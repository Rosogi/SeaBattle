package org.example;

public class App 
{
    public static void main( String[] args )
    {
        GameField enemyGameField = new GameField(5);
        GameField playerGameField = new GameField(5);
        System.out.println("Стол компьютера: ");
        enemyGameField.showTable();
        System.out.println("Стол игрока: ");
        //playerGameField.showTable();
        playerGameField.placeShip(3,2,2,4);
        playerGameField.showTable();
    }


}
