import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== CHARACTER MANAGER ===");

        // Membuat tiga karakter menggunakan constructor pertama
        Character hero = new Character(
                "Aragorn", CharacterType.WARRIOR);

        Character mage = new Character(
                "Gandalf", CharacterType.MAGE);

        Character archer = new Character(
                "Legolas", CharacterType.ARCHER);

        // Menampilkan tiga karakter
        System.out.println("\n--- Daftar Karakter ---");
        System.out.println(hero);
        System.out.println(mage);
        System.out.println(archer);

        // Demo level up
        System.out.println("\n--- Demo Level Up ---");
        hero.setLevel(hero.getLevel() + 1);
        System.out.println(hero);

        // Demo Bagian B: karakter baru dengan mana
        Character necromancer = new Character(
                "Morgana",
                CharacterType.MAGE,
                3,
                140,
                20,
                80
        );

        necromancer.setMana(120);

        System.out.println("\n--- Mini-Challenge Mana ---");
        System.out.println("Nama: " + necromancer.getName());
        System.out.println("Mana: " + necromancer.getMana());
        System.out.println("Hidup: " + necromancer.isAlive());

        // Demo karakter dengan HP nol
        Character defeated = new Character(
                "Fallen Hero",
                CharacterType.WARRIOR,
                1,
                0,
                10,
                50
        );

        System.out.println("\n--- Demo isAlive() ---");
        System.out.println(defeated);
        System.out.println("Apakah masih hidup? "
                + defeated.isAlive());
    }
}
