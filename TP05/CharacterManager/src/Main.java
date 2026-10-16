package com.unpri.charactermanager;

import java.util.ArrayList;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {
        CharacterManager manager = new CharacterManager();

        System.out.println("=== PENGUJIAN CRUD ===");

        Character c1 = new Character(
            "Arka", 10, CharacterType.WARRIOR
        );
        Character c2 = new Character(
            "Luna", 8, CharacterType.MAGE
        );
        Character c3 = new Character(
            "Raka", 6, CharacterType.WARRIOR
        );

        System.out.println("Tambah Arka: "
            + manager.addCharacter(c1));
        System.out.println("Tambah Luna: "
            + manager.addCharacter(c2));
        System.out.println("Tambah Raka: "
            + manager.addCharacter(c3));

        Character duplicate = new Character(
            "ARKA", 15, CharacterType.ARCHER
        );

        System.out.println("Tambah nama duplikat ARKA: "
            + manager.addCharacter(duplicate));

        System.out.println("\n=== DAFTAR KARAKTER ===");
        for (Character c : manager.getAllCharacters()) {
            System.out.println(c);
        }

        System.out.println("\nTotal karakter: "
            + manager.getTotalCharacters());

        System.out.println("Cari Luna: "
            + manager.findByName("Luna"));

        System.out.println("Hapus Raka: "
            + manager.removeCharacter("Raka"));

        System.out.println("Total setelah hapus: "
            + manager.getTotalCharacters());

        System.out.println("\n=== MINI-CHALLENGE ===");
        System.out.println("Rata-rata level: "
            + manager.getAverageLevel());

        System.out.println("Karakter bertipe WARRIOR:");
        for (Character c : manager.findByType(
                CharacterType.WARRIOR)) {
            System.out.println(c.getName());
        }

        System.out.println("Jumlah WARRIOR: "
            + manager.countByType(CharacterType.WARRIOR));

        System.out.println("\n=== EKSPERIMEN SALINAN LIST ===");
        ArrayList<Character> copy = manager.getAllCharacters();
        copy.clear();

        System.out.println("Isi salinan setelah clear: "
            + copy.size());
        System.out.println("Isi manager setelah clear salinan: "
            + manager.getTotalCharacters());

        System.out.println("\n=== EKSPERIMEN REFERENCE ===");
        Character a = new Character(
            "Nara", 5, CharacterType.HEALER
        );
        Character b = a;

        b.setLevel(8);

        System.out.println("Level a: " + a.getLevel());
        System.out.println("a == b: " + (a == b));

        Character independent = new Character(
            a.getName(), a.getLevel(), a.getType()
        );

        independent.setLevel(12);

        System.out.println("Level a setelah independent diubah: "
            + a.getLevel());
        System.out.println("Level independent: "
            + independent.getLevel());

        System.out.println("\nObjek Character yang dibuat: "
            + Character.getTotalCharacterCreated());

        System.out.println("\n=== UJI DAFTAR KOSONG ===");
        CharacterManager emptyManager = new CharacterManager();

        System.out.println("Rata-rata daftar kosong: "
            + emptyManager.getAverageLevel());
    }
}
