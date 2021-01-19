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

    public boolean beats(Type type){
        if(this.typeName.equals(type.getTypeName())){
            return false;
        }
        if(this.typeName.equals("kamień") && type.getTypeName().equals("nożyce")){
            return true;
        }
        if(this.typeName.equals("kamień") && type.getTypeName().equals("papier")){
            return false;
        }
        if(this.typeName.equals("nożyce") && type.getTypeName().equals("kamień")){
            return false;
        }
        if(this.typeName.equals("nożyce") && type.getTypeName().equals("papier")){
            return true;
        }
        if(this.typeName.equals("papier") && type.getTypeName().equals("kamień")){
            return true;
        }
        if(this.typeName.equals("papier") && type.getTypeName().equals("nożyce")){
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
