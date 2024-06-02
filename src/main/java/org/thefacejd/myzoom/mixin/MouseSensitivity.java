package org.thefacejd.myzoom.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.thefacejd.myzoom.MyZoom;

@Mixin(GameOptions.class)
public class MouseSensitivity {
    private double originalSensitivity;
    private boolean isZooming;

    @ModifyReturnValue(method = "getMouseSensitivity", at = @At("RETURN"))
    private SimpleOption<Double> modifyMouseSensitivity(SimpleOption<Double> original) {
        if (MyZoom.zoomKeyBinding.isPressed() && !this.isZooming) {
            this.originalSensitivity = original.getValue();
            this.isZooming = true;
            double sensitivityMultiplier = (double) MyZoom.CONFIG.ZoomMultiplier() / 1.4;
            original.setValue(original.getValue() / sensitivityMultiplier);
        } else if (!MyZoom.zoomKeyBinding.isPressed() && this.isZooming) {
            this.isZooming = false;
            original.setValue(this.originalSensitivity);
        }
        return original;
    }
}