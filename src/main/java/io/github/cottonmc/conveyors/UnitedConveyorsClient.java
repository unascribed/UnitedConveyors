package io.github.cottonmc.conveyors;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;

public class UnitedConveyorsClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		BlockEntityRendererRegistry.INSTANCE.register(UnitedConveyors.CONVEYOR_ENTITY_TYPE, ConveyorBlockEntityRenderer::new);
	}

}
