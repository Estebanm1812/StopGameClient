package model;

public class GameInformation {

    private Player rival;

    private Answer ownAnswer;

    private Answer rivalAnswer;

    private String letter;

    public GameInformation(Player rival,String letter){
        this.rival = rival;
        this.letter = letter;
    }

    public Player getRival() {
        return rival;
    }

    public Answer getOwnAnswer() {
        return ownAnswer;
    }

    public Answer getRivalAnswer() {
        return rivalAnswer;
    }

    public String getLetter() {
        return letter;
    }
}
