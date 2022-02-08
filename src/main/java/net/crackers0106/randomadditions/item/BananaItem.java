package net.crackers0106.randomadditions.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.Level;

public class BananaItem extends Item {
	public BananaItem(Properties settings) {
		super(settings);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) { // fires when player right clicks
		ItemStack itemStack = user.getItemInHand(hand);
		if (itemStack.sameItemStackIgnoreDurability(RAItems.BANANA.getDefaultInstance())) {
			world.playSound(user, user.getX(), user.getY(), user.getZ(), SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.PLAYERS, 1.0F, 1.0F);
			ItemStack replaceOneItemStack = ItemUtils.createFilledResult(itemStack, user, new ItemStack(RAItems.PEELED_BANANA));
			return new InteractionResultHolder(InteractionResult.PASS, replaceOneItemStack);
		}

		return InteractionResultHolder.sidedSuccess(itemStack, world.isClientSide());
	}

}