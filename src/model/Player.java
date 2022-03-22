package model;

public class Player {

    private static Player instance;

    private String name;

    //private int playedGames;

    public static synchronized Player getInstance(String name){

        if(instance==null){

            instance = new Player(name);
        }
        return instance;

    }
    private Player(String name){

        this.name = name;

    }

}