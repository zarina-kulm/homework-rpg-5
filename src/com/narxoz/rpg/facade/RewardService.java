package com.narxoz.rpg.facade;
public class RewardService {
    public String determineReward(AdventureResult battleResult) {
        if (battleResult == null) {
            return "No reward: battle result is missing.";
        }
        if ("Hero".equalsIgnoreCase(battleResult.getWinner())) {
            return "100 gold + Epic Sword";
        }
        return "No reward";
    }
}
