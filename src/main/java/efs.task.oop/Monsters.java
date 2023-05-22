package efs.task.oop;

public class Monsters {
    static final Monster andariel = new Monster(10, 70) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(getDamage());
        }

        @Override
        public void takeHit(int damage) {
            health -= damage;
            monstersHealth -= damage;
        }
    };
    static final Monster blacksmith = new Monster(100, 25) {
        @Override
        public void attack(Fighter victim) {
            victim.takeHit(getDamage());
        }

        @Override
        public void takeHit(int damage) {
            int hit = 5 + damage;
            health -= hit;
            monstersHealth -= hit;
        }
    };
    static int monstersHealth = andariel.health + blacksmith.health;

//    public static int getMonstersHealth() {
//        return monstersHealth;
//    }
//
//    public static Monster getAndariel() {
//        return andariel;
//    }
//
//    public static Monster getBlacksmith() {
//        return blacksmith;
//    }
}
