package com.unpri.charactermanager.model;

import java.util.Locale;
import java.util.Objects;

public class Character {

    private String name;
    private int level;
    private CharacterType type;

    private static int totalCharacterCreated = 0;

    public Character(String name, int level, CharacterType type) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Nama karakter tidak boleh kosong."
            );
        }

        if (level < 1) {
            throw new IllegalArgumentException(
                "Level minimal adalah 1."
            );
        }

        this.name = name.trim();
        this.level = level;
        this.type = Objects.requireNonNull(type, "Tipe tidak boleh null.");

        totalCharacterCreated++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Nama karakter tidak boleh kosong."
            );
        }

        this.name = name.trim();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException(
                "Level minimal adalah 1."
            );
        }

        this.level = level;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = Objects.requireNonNull(type);
    }

    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;

        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase(Locale.ROOT).hashCode();
    }

    @Override
    public String toString() {
        return "Character{name='" + name
            + "', level=" + level
            + ", type=" + type + "}";
    }
}
