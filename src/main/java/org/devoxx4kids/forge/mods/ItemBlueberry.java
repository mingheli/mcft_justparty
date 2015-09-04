package org.devoxx4kids.forge.mods;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;

public class ItemBlueberry extends RecipeItemSeedFood
{

    public ItemBlueberry()
    {
        super(1, 0.3F, RecipePlus.blockBlueberry, Blocks.farmland);
        setUnlocalizedName("blueberry");
        setTextureName("recipeplus:blueberry");
        setCreativeTab(CreativeTabs.tabFood);
        setPotionEffect(Potion.regeneration.id, 5, 1, 1.0F);
    }
}