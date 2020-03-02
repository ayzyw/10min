package com.example.examplemod.handler;

import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PlayerHandler {
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (!event.getWorld().isRemote && event.getHand().equals(Hand.MAIN_HAND)) {
            ITextComponent text = event.getWorld().getBlockState(event.getPos()).getBlock().getNameTextComponent();
            event.getPlayer().sendMessage(new StringTextComponent("你选择了").appendSibling(text));
        }
    }
}
