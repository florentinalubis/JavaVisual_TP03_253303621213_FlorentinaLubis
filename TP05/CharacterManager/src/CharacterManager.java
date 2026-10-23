
package com.unpri.charactermanager;

import java.util.ArrayList;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class CharacterManager {

    private final ArrayList<Character> characters =
            new ArrayList<>();

    // Menambahkan karakter jika belum ada nama duplikat
    public boolean addCharacter(Character character) {

        if (character == null) {
            return false;
        }

        if (findByName(character.getName()) != null) {
            return false;
        }

        characters.add(character);
        return true;
    }

    // Mencari karakter berdasarkan nama
    public Character findByName(String name) {

        if (name == null) {
            return null;
        }

        for (Character character : characters) {

            if (character.getName()
                    .equalsIgnoreCase(name.trim())) {

                return character;
            }
        }

        return null;
    }

    // Menghapus karakter berdasarkan nama
    public boolean removeCharacter(String name) {

        Character found = findByName(name);

        if (found == null) {
            return false;
        }

        characters.remove(found);
        return true;
    }

    // Menghitung total karakter
    public int getTotalCharacters() {
        return characters.size();
    }

    // Mengembalikan salinan daftar karakter
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    // Menghitung rata-rata level
    public double getAverageLevel() {

        if (characters.isEmpty()) {
            return 0.0;
        }

        int totalLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characters.size();
    }

    // Mencari karakter berdasarkan tipe
    public ArrayList<Character> findByType(
            CharacterType type) {

        ArrayList<Character> result =
                new ArrayList<>();

        if (type == null) {
            return result;
        }

        for (Character character : characters) {

            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }

    // Menghitung jumlah karakter berdasarkan tipe
    public int countByType(CharacterType type) {

        if (type == null) {
            return 0;
        }

        int count = 0;

        for (Character character : characters) {

            if (character.getType() == type) {
                count++;
            }
        }

        return count;
    }
}
