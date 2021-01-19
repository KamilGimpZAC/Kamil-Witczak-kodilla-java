package com.kodilla.rps;

import java.util.Objects;

public class Type {
    private String typeName;

    public Type(int value) {
        if (value == 1)
            this.typeName = "kamień";
        if (value == 2)
            this.typeName = "nożyce";
        if (value == 3)
            this.typeName = "papier";
    }

    public String getTypeName() {
        return typeName;
    }

    public boolean beats(Type type1, Type type2){
        if(type1.getTypeName().equals(type2.getTypeName())){
            return false;
        }
        if(type1.getTypeName().equals("kamień") && type2.getTypeName().equals("nożyce")){
            return true;
        }
        if(type1.getTypeName().equals("kamień") && type2.getTypeName().equals("papier")){
            return false;
        }
        if(type1.getTypeName().equals("nożyce") && type2.getTypeName().equals("kamień")){
            return false;
        }
        if(type1.getTypeName().equals("nożyce") && type2.getTypeName().equals("papier")){
            return true;
        }
        if(type1.getTypeName().equals("papier") && type2.getTypeName().equals("kamień")){
            return true;
        }
        if(type1.getTypeName().equals("papier") && type2.getTypeName().equals("nożyce")){
            return false;
        }
        else
            return false;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return Objects.equals(typeName, type.typeName);
    }
}
