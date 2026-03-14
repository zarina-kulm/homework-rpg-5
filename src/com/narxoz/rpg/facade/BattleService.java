package com.narxoz.rpg.facade;
import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

import java.util.Random;
public class BattleService {
    private Random random = new Random(1L);
    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }
    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        AdventureResult result = new AdventureResult();
        int rounds = 0;
        result.addLine("Battle started: " + hero.getName() + " vs " + boss.getName());
        while (hero.isAlive() && boss.isAlive() && rounds < 20) {
            rounds++;
            int heroDamage = action.getDamage();
            boss.takeDamage(heroDamage);

            result.addLine("Round " + rounds + ": " + hero.getName() + " uses " + action.getActionName() + " dealing " + heroDamage + " damage.");
            if (!boss.isAlive()) {
                result.setWinner(hero.getName());
                result.setReward("Boss defeated! Reward: 100 gold");
                break;
            }
            int bossDamage = boss.getAttackPower();
            hero.takeDamage(bossDamage);

            result.addLine(boss.getName() + " attacks dealing " + bossDamage + " damage.");
            if (!hero.isAlive()) {
                result.setWinner(boss.getName());
                result.setReward("Hero was defeated. No reward.");
                break;
            }
        }
        result.setRounds(rounds);
        return result;
    }
}
