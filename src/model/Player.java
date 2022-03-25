package model;

public class Player {

    //private static Player instance;

    private String type;

    private String name;

    //private int playedGames;

    /*
    public static synchronized Player getInstance(String name){

        if(instance==null){

            instance = new Player(name);
        }
        return instance;

    }
    *
     */
    public Player(String name){

        this.name = name;

        type = "Player";
    }

    public String getName() {
        return name;
    }
}
