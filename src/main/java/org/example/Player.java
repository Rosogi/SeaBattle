package org.example;

public class Player extends GameField{
    private String name;

    public Player(){
        this.name = "Компьютер";
    }

    public Player(String name){
        this.name = name;
    }

    public void placeShip(){
        placeShip(1, 2,3,4);
    }

    public String getName(){
        return name;
    }
}
