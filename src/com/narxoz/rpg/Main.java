package com.narxoz.rpg;
import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.decorator.BasicAttack;
import com.narxoz.rpg.decorator.CriticalFocusDecorator;
import com.narxoz.rpg.decorator.FireRuneDecorator;
import com.narxoz.rpg.decorator.PoisonCoatingDecorator;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.hero.HeroProfile;
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 5 Demo: Decorator + Facade ===\n");
        HeroProfile hero = new HeroProfile("Knight", 100);
        BossEnemy boss = new BossEnemy("Dragon", 120, 15);

        AttackAction basicAttack = new BasicAttack("Sword Strike", 12);
        AttackAction fireAttack = new FireRuneDecorator(basicAttack);
        AttackAction poisonAttack = new PoisonCoatingDecorator(basicAttack);
        AttackAction ultimateAttack = new CriticalFocusDecorator(new PoisonCoatingDecorator(new FireRuneDecorator(basicAttack)));

        System.out.println("--- Decorator Preview ---\n");

        System.out.println("Base Attack:");
        System.out.println("Name: " + basicAttack.getActionName());
        System.out.println("Damage: " + basicAttack.getDamage());
        System.out.println("Effects: " + basicAttack.getEffectSummary());
        System.out.println();

        System.out.println("Fire Attack:");
        System.out.println("Name: " + fireAttack.getActionName());
        System.out.println("Damage: " + fireAttack.getDamage());
        System.out.println("Effects: " + fireAttack.getEffectSummary());
        System.out.println();

        System.out.println("Poison Attack:");
        System.out.println("Name: " + poisonAttack.getActionName());
        System.out.println("Damage: " + poisonAttack.getDamage());
        System.out.println("Effects: " + poisonAttack.getEffectSummary());
        System.out.println();

        System.out.println("Ultimate Attack (Fire + Poison + Critical):");
        System.out.println("Name: " + ultimateAttack.getActionName());
        System.out.println("Damage: " + ultimateAttack.getDamage());
        System.out.println("Effects: " + ultimateAttack.getEffectSummary());

        System.out.println("\n--- Facade Dungeon Run ---\n");

        DungeonFacade facade = new DungeonFacade().setRandomSeed(42L);

        AdventureResult result = facade.runAdventure(hero, boss, ultimateAttack);

        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());
        System.out.println("Reward: " + result.getReward());

        System.out.println("\nBattle Log:");
        for (String line : result.getLog()) {
            System.out.println(line);
        }
        System.out.println("\n=== Demo Complete ===");
    }
}
