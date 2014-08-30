package com.github.tamurashingo.kakuge;

public class Character {
    
    public static final Character RYU = new Character(1, "RYU");
    
    private int id;
    private String name;
    
    private Character(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Character) {
            Character character = (Character)obj;
            return character.id == this.id;
        }
        
        return false;
    }
    
    
    public enum Status {
        STAND,
        GUARD,
        JUMP,
        PUNCH,
        KICK,
        HADOKEN,
        SHORYUKEN,
    }


}
