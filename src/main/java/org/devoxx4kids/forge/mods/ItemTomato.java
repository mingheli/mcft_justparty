package org.devoxx4kids.forge.mods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;

public class ItemTomato extends RecipeItemSeedFood
{

    public ItemTomato()
    {
        super(1, 0.3F, RecipePlus.blockTomato, Blocks.farmland);
        setUnlocalizedName("tomato");
        setTextureName("recipeplus:tomato");
        setCreativeTab(CreativeTabs.tabFood);
        setPotionEffect(Potion.regeneration.id, 5, 1, 1.0F);
    }
}