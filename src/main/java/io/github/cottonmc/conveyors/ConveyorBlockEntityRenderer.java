package io.github.cottonmc.conveyors;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

public class ConveyorBlockEntityRenderer extends BlockEntityRenderer<ConveyorBlockEntity> {
	public ConveyorBlockEntityRenderer(BlockEntityRenderDispatcher blockEntityRenderDispatcher) {
		super(blockEntityRenderDispatcher);
	}

	@Override
	public void render(ConveyorBlockEntity conveyor, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumerProvider, int light, int overlay) {
		Direction dir = conveyor.getCachedState().get(Properties.HORIZONTAL_FACING);
		
		ItemStack stack = conveyor.stack;
		
		if (!stack.isEmpty()) {
			matrices.push();
			
			float progress = -(conveyor.getProgress(tickDelta)-0.3f);
			
			matrices.translate(0.5, 0.6, 0.5);
			matrices.translate(progress*dir.getOffsetX(), progress*dir.getOffsetY(), progress*dir.getOffsetZ());
			matrices.multiply(Vector3f.POSITIVE_X.getDegreesQuaternion(90));
			
			matrices.scale(0.8f, 0.8f, 0.8f);
			MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.FIXED, light, overlay, matrices, vertexConsumerProvider);
			matrices.pop();
		}
	}

}
