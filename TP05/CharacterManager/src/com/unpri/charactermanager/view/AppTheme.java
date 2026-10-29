
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public final class AppTheme {

    private AppTheme() {
    }

    public static final Color BACKGROUND =
            new Color(245, 247, 252);

    public static final Color PRIMARY =
            new Color(40, 55, 85);

    public static final Color TEXT =
            new Color(40, 45, 55);

    public static final Color HIGH_LEVEL =
            new Color(160, 110, 0);

    public static final Font TITLE_FONT =
            new Font(Font.SANS_SERIF, Font.BOLD, 24);

    public static final Font NORMAL_FONT =
            new Font(Font.SANS_SERIF, Font.PLAIN, 14);

    public static final Font MONO_FONT =
            new Font(Font.MONOSPACED, Font.PLAIN, 12);

    public static final Border CARD_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(
                            new Color(205, 212, 225)),
                    BorderFactory.createEmptyBorder(
                            12, 14, 12, 14)
            );

    public static Color colorFor(CharacterType type) {
        if (type == null) {
            return Color.LIGHT_GRAY;
        }

        switch (type) {
            case WARRIOR:
                return new Color(255, 220, 220);

            case MAGE:
                return new Color(220, 225, 255);

            case ARCHER:
                return new Color(220, 245, 220);

            case HEALER:
                return new Color(255, 240, 205);

            default:
                return Color.LIGHT_GRAY;
        }
    }
    public static Color highLevelColor() {
    return HIGH_LEVEL;
}
}
