package genspark.assignments.section6;

import genspark.assignments.Assignment;

public class Goblin implements Assignment {
    int strength;
    String stamina;
    String name;
    String color;

    // Do not change the constructor for goblin please!
    public Goblin() {
    }

    public Goblin(int strength) {
        this.strength = strength;
    }


    public int getStrength() {
        return strength;
    }

    // ↓↓↓↓ your code goes here ↓↓↓↓
    //TODO fix importing/instantiating of a zombie object
    Zombie zombie = new Zombie();
//    public int attack(zombie){
//        zombie.health += this.strength;
//        return zombie;
//    }

//    public class GoblinAttackZombie{
//        int outcome = attack(zombie);
//        public int determineOutcome(zombie){
//            if (outcome <= 0) {
//                System.out.println("ermmm I am still alive!");
//            } else {
//                System.out.println("Zombie is alive, therefore it is not a zombie!");
//            }
//    }
//}
}
