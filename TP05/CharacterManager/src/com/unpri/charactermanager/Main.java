package com.unpri.charactermanager;

import javax.swing.SwingUtilities;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;

public class Main {

public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // Membuat pengelola karakter
        CharacterManager manager = new CharacterManager();

            // Karakter 1
        manager.addCharacter(
                new Character("Arka", 10, CharacterType.WARRIOR)
        );

            // Karakter 2
        manager.addCharacter(
                new Character("Luna", 8, CharacterType.MAGE)
        );

            // Karakter 3
        manager.addCharacter(
                new Character("Raka", 6, CharacterType.WARRIOR)
        );

            // Karakter 4
        manager.addCharacter(
                new Character("Nara", 5, CharacterType.HEALER)
        );

            // Karakter 5
            manager.addCharacter(
                new Character("Kirana", 12, CharacterType.ARCHER)
            );

            // Karakter 6
            manager.addCharacter(
                new Character("Frodo", 1, CharacterType.ARCHER)
            );

            // Membuka jendela aplikasi
            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}
