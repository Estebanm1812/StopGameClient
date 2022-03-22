package model;

public class Answer {

    private String type = "Answer";

    private String name_lastName;

    private String animal;

    private String city_country;

    private String thing;

    private Player player;

    public Answer(String name_lastName, String animal, String city_country, String thing,Player player){

        this.name_lastName = name_lastName;

        this.animal = animal;

        this.city_country = city_country;

        this.thing = thing;

        this.player = player;

    }


}
