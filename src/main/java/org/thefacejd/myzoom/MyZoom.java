package org.thefacejd.myzoom;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class MyZoom implements ClientModInitializer {
    public static KeyBinding zoomKeyBinding;

    public static final org.thefacejd.myzoom.MyZoomConfig CONFIG = org.thefacejd.myzoom.MyZoomConfig.createAndLoad();

    @Override
    public void onInitializeClient() {
        zoomKeyBinding = KeyBindingHelper.registerKeyBinding(
                new KeyBinding(
                        "key.MyZoom.Zoom",
                        InputUtil.Type.KEYSYM,
                        GLFW.GLFW_KEY_Z,
                        "category.MyZoom"
                )
        );
    }
}
