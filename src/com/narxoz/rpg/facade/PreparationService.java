package com.narxoz.rpg.facade;
import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;
public class PreparationService {
    public String prepare(HeroProfile hero, BossEnemy boss, AttackAction action) {
        if (hero == null || boss == null || action == null) {
            return "Preparation failed: invalid hero, boss, or action.";
        }
        String summary = "Preparation complete:\n";
        summary += "Hero: " + hero.getName() + " (HP: " + hero.getHealth() + ")\n";
        summary += "Boss: " + boss.getName() + " (HP: " + boss.getHealth() + ")\n";
        summary += "Attack: " + action.getActionName() + "\n";
        summary += "Base Damage: " + action.getDamage() + "\n";
        summary += "Effects: " + action.getEffectSummary();

        return summary;
    }
}
