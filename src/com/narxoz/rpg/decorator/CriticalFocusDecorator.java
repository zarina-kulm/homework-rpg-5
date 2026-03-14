package com.narxoz.rpg.decorator;
public class CriticalFocusDecorator extends ActionDecorator {
    private static final double CRITICAL_MULTIPLIER = 1.5;
    public CriticalFocusDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return super.getActionName() + " [Critical Focus]";
    }
    @Override
    public int getDamage() {
        return (int) (super.getDamage() * CRITICAL_MULTIPLIER);
    }
    @Override
    public String getEffectSummary() {
        return super.getEffectSummary() + ", increased critical damage";
    }
}
