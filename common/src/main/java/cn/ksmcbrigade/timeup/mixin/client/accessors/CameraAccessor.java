package cn.ksmcbrigade.timeup.mixin.client.accessors;

import net.minecraft.client.Camera;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Camera.class)
public interface CameraAccessor {
    @Accessor("blockPosition")
    @Mutable
    void setBlockPos(BlockPos.MutableBlockPos pos);

    @Accessor("position")
    @Mutable
    void setPos(Vec3 pos);

    @Accessor("rotation")
    @Mutable
    void setRot(Quaternionf quaternionf);

    @Accessor("xRot")
    @Mutable
    void setXR(float xr);

    @Accessor("yRot")
    @Mutable
    void setYR(float yr);

    @Accessor("forwards")
    @Mutable
    static void setLookV(Vector3f vector3f) {

    }

    @Accessor("up")
    @Mutable
    static void setUpV(Vector3f vector3f) {

    }

    @Accessor("left")
    @Mutable
    static void setLeftV(Vector3f vector3f) {

    }
}
