
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.CharacterManager;
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private final CharacterManager manager;
    private final JPanel characterPanel;
    private final JLabel totalLabel;
    private final JLabel averageLabel;

    private int newCharacterNumber = 1;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager - Sprint #3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setMinimumSize(new Dimension(500, 400));
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Judul aplikasi
        JLabel titleLabel = new JLabel(
                "Daftar Karakter",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 22)
        );

        titleLabel.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 10, 10)
        );

        add(titleLabel, BorderLayout.NORTH);

        // Panel daftar karakter
        characterPanel = new JPanel();

        characterPanel.setLayout(
                new BoxLayout(characterPanel, BoxLayout.Y_AXIS)
        );

        characterPanel.setBorder(
                BorderFactory.createEmptyBorder(5, 15, 5, 15)
        );

        JScrollPane scrollPane =
                new JScrollPane(characterPanel);

        add(scrollPane, BorderLayout.CENTER);

        // Panel statistik
        JPanel statisticsPanel =
                new JPanel(new GridLayout(2, 1, 5, 5));

        totalLabel = new JLabel("", SwingConstants.CENTER);
        averageLabel = new JLabel("", SwingConstants.CENTER);

        totalLabel.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );

        averageLabel.setFont(
                new Font("Arial", Font.BOLD, 15)
        );

        statisticsPanel.add(totalLabel);
        statisticsPanel.add(averageLabel);

        // Tombol tambah karakter
        JButton addButton =
                new JButton("Tambah Karakter");

        addButton.addActionListener(event -> addNewCharacter());

        // Panel bagian bawah
        JPanel bottomPanel =
                new JPanel(new BorderLayout(5, 10));

        bottomPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 15, 15, 15)
        );

        bottomPanel.add(
                statisticsPanel,
                BorderLayout.CENTER
        );

        bottomPanel.add(
                addButton,
                BorderLayout.SOUTH
        );

        add(bottomPanel, BorderLayout.SOUTH);

        // Tampilkan data awal
        refreshData();
    }

    // Menambahkan karakter baru
    private void addNewCharacter() {

        String name = "PahlawanBaru" + newCharacterNumber;

        CharacterType type;

        switch (newCharacterNumber % 4) {
            case 1:
                type = CharacterType.WARRIOR;
                break;

            case 2:
                type = CharacterType.MAGE;
                break;

            case 3:
                type = CharacterType.ARCHER;
                break;

            default:
                type = CharacterType.HEALER;
                break;
        }

        int level = 10 + newCharacterNumber;

        Character newCharacter =
                new Character(name, level, type);

        boolean berhasil =
                manager.addCharacter(newCharacter);

        if (berhasil) {
            newCharacterNumber++;
            refreshData();
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Karakter gagal ditambahkan.",
                    "Informasi",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // Memperbarui daftar dan statistik
    public void refreshData() {

        characterPanel.removeAll();

        // Menampilkan karakter secara dinamis
        for (Character character : manager.getAllCharacters()) {

            JLabel characterLabel =
                    new JLabel(character.toString());

            characterLabel.setFont(
                    new Font("Arial", Font.PLAIN, 14)
            );

            characterLabel.setBorder(
                    BorderFactory.createEmptyBorder(8, 5, 8, 5)
            );

            characterPanel.add(characterLabel);
        }

        // Memperbarui total karakter
        totalLabel.setText(
                "Total Karakter: "
                + manager.getTotalCharacters()
        );

        // Memperbarui rata-rata level
        averageLabel.setText(
                String.format(
                        "Rata-rata Level: %.2f",
                        manager.getAverageLevel()
                )
        );

        characterPanel.revalidate();
        characterPanel.repaint();
    }
}
