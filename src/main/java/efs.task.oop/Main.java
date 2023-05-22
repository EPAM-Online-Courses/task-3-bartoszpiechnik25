package efs.task.oop;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Villager kashya = new Villager("Kashya", 30);
        ExtraordinaryVillager akara = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);
        Villager gheed = new Villager("Gheed", 50);
        ExtraordinaryVillager deckardCain = new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        Villager warriv = new Villager("Warriv", 35);
        Villager flawia = new Villager("Flawia", 25);

        Villager[] villagers = {kashya, akara, gheed, deckardCain, warriv, flawia};
        for (Villager villager : villagers) {
            villager.sayHello();
        }
        Object objectDeckardCain = deckardCain;
        Object objectAkara = akara;
//        objectDeckardCain.sayHello(); --> error 'java: cannot find symbol, symbol: method sayHello()'

        while (Monsters.monstersHealth > 0) {
            System.out.println("Potwory posiadaja jeszcze " + Monsters.monstersHealth + " punkty zycia");

            for (Villager v: villagers) {
                if (v.getHealth() <= 0)
                    continue;

                System.out.println("Aktualnie walczacy osadnik to " + v.getName());
                villagerAttack(Monsters.andariel, v);
                villagerAttack(Monsters.blacksmith, v);

                if (Monsters.blacksmith.health <= 0) {
                    System.out.println("Blacksmith została pokonana!");
                }
                if (Monsters.andariel.health <= 0) {
                    System.out.println("Andariel została pokonana!");
                }
            }
            System.out.println("\n" + "Atak potworów");
            for (Villager v: villagers) {
                if (v.getHealth() <= 0)
                    continue;

                System.out.println("Aktualnie walczy " + v.getName());
                monsterAttack(Monsters.andariel, v);
                monsterAttack(Monsters.blacksmith, v);

                if (v.getHealth() <= 0) {
                    System.out.println(v.getName() + " został pokonany/na!");
                }
            }

        }
        System.out.println("Obozowisko ocalone!");

        ExtraordinaryVillager deckardCainCasted = (ExtraordinaryVillager) objectDeckardCain;
        deckardCainCasted.sayHello();

        ExtraordinaryVillager akaraCasted = (ExtraordinaryVillager) objectAkara;
        akaraCasted.sayHello();

    }

    public static void monsterAttack(Monster monster, Villager villager) {
        if (Monsters.monstersHealth > 0) {
            if (villager.getHealth() > 0) {
                monster.attack(villager);
            }
        }
    }
    public static void villagerAttack(Monster monster, Villager villager) {
        if (Monsters.monstersHealth > 0) {
            villager.attack(monster);
        }
    }
}