package model;

public class GameInformation {

    private Player rival;

    private Answer ownAnswer;

    private Answer rivalAnswer;

    private Player self;

    private String letter;

    private int ownPoints;

    private int rivalPoints;

    private int ownNamePoints;

    private int ownAnimalPoints;

    private int ownCountryPoints;

    private int ownThingPoint;

    private int rivalNamePoints;

    private int rivalAnimalPoints;

    private int rivalCountryPoints;

    private int rivalThingPoints;

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

                rivalNamePoints +=100;

            }else if(ownName.isEmpty()==false && rivalName.isEmpty()){

                ownNamePoints += 100;
            }else{

            }


        }else if(ownName.equals(rivalName)){

            rivalNamePoints += 50;
            ownNamePoints += 50;
        }else{

            rivalNamePoints += 100;
            ownNamePoints += 100;

        }
        String ownAnimal = ownAnswer.getAnimal();

        String rivalAnimal = rivalAnswer.getAnimal();

        if(ownAnimal.isEmpty() || rivalAnimal.isEmpty()){

            if(ownAnimal.isEmpty() && rivalAnimal.isEmpty()==false){

                rivalAnimalPoints +=100;

            }else if(ownAnimal.isEmpty()==false && rivalAnimal.isEmpty()){

                ownAnimalPoints += 100;
            }else{

            }


        }else if(ownAnimal.equals(rivalAnimal)){

            rivalAnimalPoints += 50;
            ownAnimalPoints += 50;
        }else{

            rivalAnimalPoints += 100;
            ownAnimalPoints += 100;

        }
        String ownCity = ownAnswer.getCity_country();

        String rivalCity = rivalAnswer.getCity_country();

        if(ownCity.isEmpty() || rivalCity.isEmpty()){

            if(ownCity.isEmpty() && rivalCity.isEmpty()==false){

                rivalCountryPoints +=100;

            }else if(ownCity.isEmpty()==false && rivalCity.isEmpty()){

                ownCountryPoints += 100;
            }else{

            }


        }else if(ownCity.equals(rivalCity)){

            rivalCountryPoints += 50;
            ownCountryPoints += 50;
        }else{

            rivalCountryPoints += 100;
            ownCountryPoints += 100;

        }
        String ownThing = ownAnswer.getThing();

        String rivalThing = rivalAnswer.getThing();

        if(ownThing.isEmpty() || rivalThing.isEmpty()){

            if(ownThing.isEmpty() && rivalThing.isEmpty()==false){

                rivalThingPoints +=100;

            }else if(ownThing.isEmpty()==false && rivalThing.isEmpty()){

                ownThingPoint += 100;
            }else{

            }


        }else if(ownThing.equals(rivalThing)){

            rivalThingPoints += 50;
            ownThingPoint += 50;
        }else{

            rivalThingPoints += 100;
            ownThingPoint += 100;

        }

        rivalPoints = rivalAnimalPoints+rivalThingPoints+rivalNamePoints+rivalCountryPoints;
        ownPoints = ownAnimalPoints+ownNamePoints+ownCountryPoints+ownThingPoint;

    }

    public int getOwnPoints() {
        return ownPoints;
    }

    public int getRivalPoints() {
        return rivalPoints;
    }

    public int getOwnNamePoints() {
        return ownNamePoints;
    }

    public int getOwnAnimalPoints() {
        return ownAnimalPoints;
    }

    public int getOwnCountryPoints() {
        return ownCountryPoints;
    }

    public int getOwnThingPoint() {
        return ownThingPoint;
    }

    public int getRivalNamePoints() {
        return rivalNamePoints;
    }

    public int getRivalAnimalPoints() {
        return rivalAnimalPoints;
    }

    public int getRivalCountryPoints() {
        return rivalCountryPoints;
    }

    public int getRivalThingPoints() {
        return rivalThingPoints;
    }
}
