package org.thefacejd.myzoom.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.thefacejd.myzoom.MyZoom;

@Mixin(GameRenderer.class)
public class Fov {
    @Shadow
    @Final
    MinecraftClient client;
    private float currentFOV;

    @ModifyReturnValue(method = "getFov", at = @At("RETURN"))
    private double modifyFov(double original) {
        if (MyZoom.zoomKeyBinding.isPressed()) {
            float ZOOM_FOV = (float) client.options.getFov().getValue() / MyZoom.CONFIG.ZoomMultiplier();
            this.currentFOV += (float) ((ZOOM_FOV - this.currentFOV) * 0.25);
        } else {
            this.currentFOV += (float) ((client.options.getFov().getValue() - this.currentFOV) * 0.25);
        }
        return this.currentFOV;
    }
}