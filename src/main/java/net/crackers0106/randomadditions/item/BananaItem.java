package net.crackers0106.randomadditions.item;

import net.minecraft.entity.LivingEntity;
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
		if (stack.isItemEqual(RAItems.PEELED_BANANA.getDefaultStack())) {
			ItemStack itemStack = super.finishUsing(stack, world, user);
			return user instanceof PlayerEntity && ((PlayerEntity) user).getAbilities().creativeMode ? itemStack : new ItemStack(RAItems.BANANA_PEEL);
		}
		return super.finishUsing(stack, world, user);
	}

	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) { // fires when player right clicks
		ItemStack itemStack = user.getStackInHand(hand);
		if (itemStack.isItemEqual(RAItems.BANANA.getDefaultStack())) {
			world.playSound(user, user.getX(), user.getY(), user.getZ(), SoundEvents.BLOCK_WOOL_BREAK, SoundCategory.PLAYERS, 1.0F, 1.0F);
			return new TypedActionResult(ActionResult.PASS, new ItemStack(RAItems.PEELED_BANANA));
		}
		if (itemStack.isItemEqual(RAItems.BANANA_PEEL.getDefaultStack())) {
			//place on the floor? //compostable?
		}
		return super.use(world, user, hand);
	}

}