package dk.turpem.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dk.turpem.client.gui.TestGui;
import dk.turpem.creativetab.TurpemTabs;

public class Saw extends TurpemItem {	

	public Saw(String name) {
		super(name);
		setFull3D();
		setCreativeTab(TurpemTabs.tabTools);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world,	EntityPlayer player) {
		//player.openGui(Turpem.instance, Turpem.guiCharacterCreation, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
		TestGui.createAndShowGUI(player);
		return super.onItemRightClick(itemstack, world, player);
	}

	
	@Override
    @SideOnly(Side.CLIENT)
    public boolean shouldRotateAroundWhenRendering()
    {
        return true;
    }
}
