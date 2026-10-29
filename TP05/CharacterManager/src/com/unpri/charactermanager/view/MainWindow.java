package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {

    private static final int HIGH_LEVEL_LIMIT = 5;

    private final CharacterManager manager;
    private final JPanel characterPanel;
    private final JLabel totalLabel;
    private final JLabel averageLabel;

    private int newCharacterNumber = 1;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager - Sprint #4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        getContentPane().setBackground(AppTheme.BACKGROUND);

        // Judul aplikasi
        JLabel titleLabel = new JLabel(
                "DAFTAR KARAKTER",
                SwingConstants.CENTER
        );

        titleLabel.setFont(AppTheme.TITLE_FONT);
        titleLabel.setForeground(AppTheme.PRIMARY);
        titleLabel.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 10, 10)
        );

        add(titleLabel, BorderLayout.NORTH);

        // Panel daftar karakter
        characterPanel = new JPanel();
        characterPanel.setLayout(
                new BoxLayout(characterPanel, BoxLayout.Y_AXIS)
        );
        characterPanel.setBackground(AppTheme.BACKGROUND);
        characterPanel.setBorder(
                BorderFactory.createEmptyBorder(12, 15, 12, 15)
        );

        JScrollPane scrollPane = new JScrollPane(characterPanel);
        scrollPane.getViewport().setBackground(AppTheme.BACKGROUND);
        scrollPane.setPreferredSize(new Dimension(600, 350));

        add(scrollPane, BorderLayout.CENTER);

        // Statistik karakter
        totalLabel = new JLabel("", SwingConstants.CENTER);
        totalLabel.setFont(AppTheme.NORMAL_FONT);

        averageLabel = new JLabel("", SwingConstants.CENTER);
        averageLabel.setFont(
                AppTheme.NORMAL_FONT.deriveFont(Font.BOLD)
        );

        JPanel statisticsPanel = new JPanel(
                new GridLayout(2, 1, 5, 5)
        );
        statisticsPanel.setBackground(AppTheme.BACKGROUND);
        statisticsPanel.add(totalLabel);
        statisticsPanel.add(averageLabel);

        // Tombol tambah karakter
        JButton addButton = new JButton("Tambah Karakter");
        addButton.setFont(AppTheme.NORMAL_FONT);
        addButton.addActionListener(e -> addNewCharacter());

        // Panel bawah
        JPanel bottomPanel = new JPanel(new BorderLayout(5, 10));
        bottomPanel.setBackground(AppTheme.BACKGROUND);
        bottomPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 15, 15, 15)
        );

        bottomPanel.add(statisticsPanel, BorderLayout.CENTER);
        bottomPanel.add(addButton, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        refreshData();

        // Mengatur ukuran jendela
        pack();
        setMinimumSize(new Dimension(520, 400));
        setLocationRelativeTo(null);
    }

    // Memperbarui daftar karakter dan statistik
    public void refreshData() {
        characterPanel.removeAll();

        List<Character> characters = manager.getAllCharacters();

        for (Character character : characters) {
            characterPanel.add(createCharacterCard(character));
            characterPanel.add(Box.createVerticalStrut(10));
        }

        totalLabel.setText(
                "Total Karakter: " + manager.getTotalCharacters()
        );

        averageLabel.setText(
                String.format(
                        "Rata-rata Level: %.2f",
                        manager.getAverageLevel()
                )
        );

        characterPanel.revalidate();
        characterPanel.repaint();
    }

    // Membuat kartu karakter
    private JPanel createCharacterCard(Character character) {
        JPanel card = new JPanel(new BorderLayout(10, 5));

        card.setBackground(AppTheme.colorFor(character.getType()));
        card.setBorder(AppTheme.CARD_BORDER);
        card.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));

        // Nama karakter
        JLabel nameLabel = new JLabel(character.getName());
        nameLabel.setFont(
                AppTheme.NORMAL_FONT.deriveFont(Font.BOLD)
        );
        nameLabel.setForeground(AppTheme.TEXT);

        // Role karakter
        JLabel roleLabel = new JLabel(
                "Role: " + character.getType()
        );
        roleLabel.setFont(AppTheme.MONO_FONT);
        roleLabel.setForeground(AppTheme.TEXT);

        // Level karakter
        JLabel levelLabel = new JLabel(
                "Level: " + character.getLevel()
        );
        levelLabel.setFont(AppTheme.NORMAL_FONT);
        levelLabel.setForeground(AppTheme.TEXT);

        // Highlight level minimal 5
        if (character.getLevel() >= HIGH_LEVEL_LIMIT) {
            levelLabel.setFont(
                    AppTheme.NORMAL_FONT.deriveFont(Font.BOLD)
            );
            levelLabel.setForeground(AppTheme.HIGH_LEVEL);
        }

        // Panel informasi
        JPanel details = new JPanel();
        details.setOpaque(false);
        details.setLayout(
                new BoxLayout(details, BoxLayout.Y_AXIS)
        );

        details.add(nameLabel);
        details.add(roleLabel);
        details.add(levelLabel);

        card.add(details, BorderLayout.CENTER);

        // Properti tambahan 1: tooltip informasi
        card.setToolTipText(
                "Nama: " + character.getName()
                + " | Role: " + character.getType()
                + " | Level: " + character.getLevel()
        );

        // Properti tambahan 2: level 1 dinonaktifkan
        if (character.getLevel() == 1) {
            setEnabledRecursively(card, false);
            card.setToolTipText(
                    "Karakter level 1 dinonaktifkan."
            );
        }

        return card;
    }

    // Menonaktifkan komponen beserta anak komponennya
    private void setEnabledRecursively(
            Container container, boolean enabled) {

        container.setEnabled(enabled);

        for (Component component : container.getComponents()) {
            component.setEnabled(enabled);

            if (component instanceof Container) {
                setEnabledRecursively(
                        (Container) component, enabled
                );
            }
        }
    }

    // Menambahkan karakter baru
    private void addNewCharacter() {
        String name = "PahlawanBaru" + newCharacterNumber;

        CharacterType[] types = CharacterType.values();

        CharacterType type =
                types[(newCharacterNumber - 1) % types.length];

        int level = 1 + (newCharacterNumber % 10);

        Character newCharacter =
                new Character(name, level, type);

        if (manager.addCharacter(newCharacter)) {
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
}
