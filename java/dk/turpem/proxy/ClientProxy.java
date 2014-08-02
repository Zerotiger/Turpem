package dk.turpem.proxy;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.NetworkRegistry;
import dk.turpem.Turpem;
import dk.turpem.client.gui.GuiHandler;
import dk.turpem.client.renderer.tileentity.TileEntitySafeRenderer;
import dk.turpem.client.renderer.tileentity.TileEntityTurpemChestRenderer;
import dk.turpem.event.ServerEvents;
import dk.turpem.event.RenderEvents;
import dk.turpem.tileentity.TileEntitySafe;
import dk.turpem.tileentity.TileEntityTurpemChest;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerEventRenderers(){
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTurpemChest.class, new TileEntityTurpemChestRenderer());
    	RenderingRegistry.registerBlockHandler(new TileEntityTurpemChestRenderer());
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySafe.class, new TileEntitySafeRenderer());
    	RenderingRegistry.registerBlockHandler(new TileEntitySafeRenderer());
    	
		NetworkRegistry.INSTANCE.registerGuiHandler(Turpem.instance, new GuiHandler());
	}
	
	@Override
	public void setNametagRange(int range, int sneakRange){
		RenderLiving.NAME_TAG_RANGE = range;
		RenderLiving.NAME_TAG_RANGE_SNEAK = sneakRange;
	}
	
	@Override
	public void registerEventHandlers(){
        MinecraftForge.EVENT_BUS.register(new RenderEvents());
	}
}
