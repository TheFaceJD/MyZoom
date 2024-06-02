package org.thefacejd.myzoom;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.RangeConstraint;

@Modmenu(modId = "my-zoom")
@Config(name = "my-zoom-config", wrapperName = "MyZoomConfig")
public class MyZoomConfigModel {
    @RangeConstraint(min = 2, max = 16)
    public int ZoomMultiplier = 5;
}
