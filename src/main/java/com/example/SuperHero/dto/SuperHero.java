package com.example.SuperHero.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//@Data
//@Document(collection = "superheroes") //mongo collection name
//public class SuperHero {
//
//    @Id
//    private String id;
//    private String name;
//    private String power;
//    private String universe;
//}
//
@Data
@Document(collection = "superheroes") //mongo collection name
public class SuperHero {
    @Id
    private String id;
    private String name;
    private String power;
    private String gender;
    private String universe;
    private String villain;

    public SuperHero() {
    }

    public String getPower() {
        return this.power;
    }

    public String getUniverse() {
        return this.universe;
    }

    public void setPower(String Power) {
        this.power = Power;
    }

    public void setUniverse(String Universe) {
        this.universe = Universe;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SuperHero;
    }

}
