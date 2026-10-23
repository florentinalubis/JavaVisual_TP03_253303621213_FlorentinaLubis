
package com.unpri.charactermanager;

import javax.swing.SwingUtilities;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // Membuat pengelola karakter
            CharacterManager manager =
                    new CharacterManager();

            // Karakter pertama
            manager.addCharacter(
                    new Character(
                            "Arka",
                            10,
                            CharacterType.WARRIOR
                    )
            );

            // Karakter kedua
            manager.addCharacter(
                    new Character(
                            "Luna",
                            8,
                            CharacterType.MAGE
                    )
            );

            // Karakter ketiga
            manager.addCharacter(
                    new Character(
                            "Raka",
                            6,
                            CharacterType.WARRIOR
                    )
            );

            // Karakter keempat
            manager.addCharacter(
                    new Character(
                            "Nara",
                            5,
                            CharacterType.HEALER
                    )
            );

            // Karakter kelima
            manager.addCharacter(
                    new Character(
                            "Kirana",
                            12,
                            CharacterType.ARCHER
                    )
            );

            // Membuat jendela aplikasi
            MainWindow window =
                    new MainWindow(manager);

            // Menampilkan jendela
            window.setVisible(true);
        });
    }
}
