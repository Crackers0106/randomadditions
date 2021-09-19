package net.crackers0106.randomadditions.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class BananaItem extends Item {
	public BananaItem(Settings settings) {
		super(settings);
	}

	   public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		      ItemStack itemStack = super.finishUsing(stack, world, user);
		      return user instanceof PlayerEntity && ((PlayerEntity)user).getAbilities().creativeMode ? itemStack : new ItemStack(RAItems.PEELED_BANANA);
		   }	
	   
	   public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		      return ItemUsage.consumeHeldItem(world, user, hand);
		   }
		}