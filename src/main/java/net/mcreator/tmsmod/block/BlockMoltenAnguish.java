
package net.mcreator.tmsmod.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

import net.mcreator.tmsmod.world.WorldHisRealm;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.Random;

@ElementsTmsModMod.ModElement.Tag
public class BlockMoltenAnguish extends ElementsTmsModMod.ModElement {
	@GameRegistry.ObjectHolder("tms_mod:molten_anguish")
	public static final Block block = null;
	@GameRegistry.ObjectHolder("tms_mod:molten_anguish")
	public static final Item item = null;
	private Fluid fluid;
	public BlockMoltenAnguish(ElementsTmsModMod instance) {
		super(instance, 642);
		fluid = new Fluid("molten_anguish", new ResourceLocation("tms_mod:blocks/163199833457000624"),
				new ResourceLocation("tms_mod:blocks/163199833457000624")).setLuminosity(5).setDensity(1000).setViscosity(1000).setGaseous(false);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockFluidClassic(fluid, Material.LAVA) {
		}.setUnlocalizedName("molten_anguish").setRegistryName("molten_anguish"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName("molten_anguish"));
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		ModelBakery.registerItemVariants(item);
		ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation("tms_mod:molten_anguish", "molten_anguish");
			}
		});
		ModelLoader.setCustomStateMapper(block, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation("tms_mod:molten_anguish", "molten_anguish");
			}
		});
	}

	@Override
	public void generateWorld(Random random, int chunkX, int chunkZ, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {
		boolean dimensionCriteria = false;
		if (dimID == WorldHisRealm.DIMID)
			dimensionCriteria = true;
		if (!dimensionCriteria)
			return;
		int i = chunkX + random.nextInt(16) + 8;
		int j = random.nextInt(256);
		int k = chunkZ + random.nextInt(16) + 8;
		new WorldGenLakes(block).generate(world, random, new BlockPos(i, j, k));
	}
}
