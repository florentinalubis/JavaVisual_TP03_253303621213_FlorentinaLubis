package com.unpri.charactermanager.model;

public class Character {

    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attack;
    private int mana;

    // Constructor pertama: menggunakan nilai default
    public Character(String name, CharacterType type) {
        this(name, type, 1, 100, 10, 50);
    }

    // Constructor kedua: menerima seluruh atribut
    public Character(
            String name,
            CharacterType type,
            int level,
            int hitPoints,
            int attack,
            int mana) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nama karakter tidak boleh kosong.");
        }

        if (type == null) {
            throw new IllegalArgumentException(
                    "Tipe karakter tidak boleh null.");
        }

        if (level < 1 || hitPoints < 0
                || attack < 0 || mana < 0) {
            throw new IllegalArgumentException(
                    "Level minimal 1 dan status tidak boleh negatif.");
        }

        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attack = attack;
        this.mana = mana;
    }

    // Getter dan setter name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nama karakter tidak boleh kosong.");
        }
        this.name = name;
    }

    // Getter dan setter type
    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        if (type == null) {
            throw new IllegalArgumentException(
                    "Tipe karakter tidak boleh null.");
        }
        this.type = type;
    }

    // Getter dan setter level
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException(
                    "Level minimal adalah 1.");
        }

        this.level = level;

        // Perhitungan ulang status berdasarkan level
        this.hitPoints = 100 + (level - 1) * 20;
        this.attack = 10 + (level - 1) * 5;
    }

    // Getter dan setter hitPoints
    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        if (hitPoints < 0) {
            throw new IllegalArgumentException(
                    "Hit points tidak boleh negatif.");
        }
        this.hitPoints = hitPoints;
    }

    // Getter dan setter attack
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        if (attack < 0) {
            throw new IllegalArgumentException(
                    "Attack tidak boleh negatif.");
        }
        this.attack = attack;
    }

    // Getter dan setter mana
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                    "Mana tidak boleh negatif.");
        }
        this.mana = mana;
    }

    // Memeriksa apakah karakter masih hidup
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // Representasi karakter dalam bentuk String
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", attack=" + attack +
                ", mana=" + mana +
                ", isAlive=" + isAlive() +
                '}';
    }
}
