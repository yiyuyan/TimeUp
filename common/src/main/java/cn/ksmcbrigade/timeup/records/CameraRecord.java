package cn.ksmcbrigade.timeup.records;

import net.minecraft.client.Camera;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public record CameraRecord(Vector3f lookV, Vector3f upV, Vector3f leftV,
                           Camera.NearPlane nearPlane,
                           Quaternionf rotation, float xr, float yr,
                           Vec3 pos, BlockPos.MutableBlockPos blockPos) {
}
