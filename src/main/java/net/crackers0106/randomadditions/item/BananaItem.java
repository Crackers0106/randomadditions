package net.crackers0106.randomadditions.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class BananaItem extends Item {
	public BananaItem(Settings settings) {
		super(settings);
	}

	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) { // fires when finished using
		if (stack.isItemEqual(RAItems.PEELED_BANANA.getDefaultStack()) && !((PlayerEntity) user).getAbilities().creativeMode) { // this is probs unsafe if non players eat food
			user.dropItem(RAItems.BANANA_PEEL); // theres probs a way to give it directly to player inventory or modify the pickup function for this item to make the player "slip" when they collide
		}
		return super.finishUsing(stack, world, user);
	}

	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) { // fires when player right clicks
		ItemStack itemStack = user.getStackInHand(hand);
		if (itemStack.isItemEqual(RAItems.BANANA.getDefaultStack())) {
			world.playSound(user, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_WOOL_BREAK, SoundCategory.PLAYERS, 1.0F, 1.0F);
			ItemStack replaceOneItemStack = ItemUsage.exchangeStack(itemStack, user, new ItemStack(RAItems.PEELED_BANANA));
			return new TypedActionResult(ActionResult.PASS, replaceOneItemStack);
		}
		if (itemStack.isItemEqual(RAItems.BANANA_PEEL.getDefaultStack())) {
			//place on the floor? //compostable?
		}
		return super.use(world, user, hand);
	}

}