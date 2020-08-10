package com.zefir.gnaeus.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.ResourceLocation;

import java.util.function.Supplier;

public enum  ModItemTier implements IItemTier
{
    ICE(0, 29, 8, 0, 19, () -> {
        return Ingredient.fromTag(new ItemTags.Wrapper(new ResourceLocation("gnaeus", "ice")));});

    int maxUses;
    float efficiency;
    float attackDamage;
    int harvestLevel;
    int enchantability;
    private final LazyLoadBase<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial)
    {
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.harvestLevel = harvestLevel;
        this.enchantability = enchantability;
        this.repairMaterial =  new LazyLoadBase<>(repairMaterial);
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() { return this.repairMaterial.getValue(); }
}
