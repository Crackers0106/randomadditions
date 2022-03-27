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
import org.jetbrains.annotations.NotNull;

public class BananaItem extends Item {
    public BananaItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull Level world, Player user, @NotNull InteractionHand hand) { // fires when player right clicks
        ItemStack heldItem = user.getItemInHand(hand);
        ItemStack replaceOneItemStack = ItemUtils.createFilledResult(heldItem, user, new ItemStack(RAItems.PEELED_BANANA));

        if (heldItem.sameItemStackIgnoreDurability(RAItems.BANANA.getDefaultInstance())) {
            world.playSound(user, user.getX(), user.getY(), user.getZ(), SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.PLAYERS, 1.0F, 1.0F);

            return new InteractionResultHolder<>(InteractionResult.SUCCESS, replaceOneItemStack);
        }

        return InteractionResultHolder.sidedSuccess(heldItem, world.isClientSide());
    }
}