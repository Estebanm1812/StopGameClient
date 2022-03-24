package model;

public class GameInformation {

    private Player rival;

    private Answer ownAnswer;

    private Answer rivalAnswer;

    private Player self;

    private String letter;

    private int ownPoints;

    private int rivalPoints;

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

    public void calculatePoints(){

        String ownName = ownAnswer.getName_lastName();

        String rivalName = rivalAnswer.getName_lastName();

        if(ownName.isEmpty() || rivalName.isEmpty()){

            if(ownName.isEmpty() && rivalName.isEmpty()==false){

                rivalPoints +=100;

            }else if(ownName.isEmpty()==false && rivalName.isEmpty()){

                ownPoints += 100;
            }else{

            }


        }else if(ownName.equals(rivalName)){

            rivalPoints += 50;
            ownPoints += 50;
        }else{

            rivalPoints += 100;
            ownPoints += 100;

        }
        String ownAnimal = ownAnswer.getAnimal();

        String rivalAnimal = rivalAnswer.getAnimal();

        if(ownAnimal.isEmpty() || rivalAnimal.isEmpty()){

            if(ownAnimal.isEmpty() && rivalAnimal.isEmpty()==false){

                rivalPoints +=100;

            }else if(ownAnimal.isEmpty()==false && rivalAnimal.isEmpty()){

                ownPoints += 100;
            }else{

            }


        }else if(ownAnimal.equals(rivalAnimal)){

            rivalPoints += 50;
            ownPoints += 50;
        }else{

            rivalPoints += 100;
            ownPoints += 100;

        }
        String ownCity = ownAnswer.getCity_country();

        String rivalCity = rivalAnswer.getCity_country();

        if(ownCity.isEmpty() || rivalCity.isEmpty()){

            if(ownCity.isEmpty() && rivalCity.isEmpty()==false){

                rivalPoints +=100;

            }else if(ownCity.isEmpty()==false && rivalCity.isEmpty()){

                ownPoints += 100;
            }else{

            }


        }else if(ownCity.equals(rivalCity)){

            rivalPoints += 50;
            ownPoints += 50;
        }else{

            rivalPoints += 100;
            ownPoints += 100;

        }
        String ownThing = ownAnswer.getThing();

        String rivalThing = rivalAnswer.getThing();

        if(ownThing.isEmpty() || rivalThing.isEmpty()){

            if(ownThing.isEmpty() && rivalThing.isEmpty()==false){

                rivalPoints +=100;

            }else if(ownThing.isEmpty()==false && rivalThing.isEmpty()){

                ownPoints += 100;
            }else{

            }


        }else if(ownThing.equals(rivalThing)){

            rivalPoints += 50;
            ownPoints += 50;
        }else{

            rivalPoints += 100;
            ownPoints += 100;

        }


    }

    public int getOwnPoints() {
        return ownPoints;
    }

    public int getRivalPoints() {
        return rivalPoints;
    }
}
