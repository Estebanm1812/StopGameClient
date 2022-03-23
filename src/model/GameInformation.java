package model;

public class GameInformation {

    private Player rival;

    private Answer ownAnswer;

    private Answer rivalAnswer;

    private Player self;

    private String letter;

    public GameInformation(Player rival,String letter,Player self){
        this.rival = rival;
        this.letter = letter;
        this.self = self;
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

    public Player getSelf() {
        return self;
    }

    public void setRival(Player rival) {
        this.rival = rival;
    }

    public void setOwnAnswer(Answer ownAnswer) {
        this.ownAnswer = ownAnswer;
    }

    public void setRivalAnswer(Answer rivalAnswer) {
        this.rivalAnswer = rivalAnswer;
    }

    public void setSelf(Player self) {
        this.self = self;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
}
