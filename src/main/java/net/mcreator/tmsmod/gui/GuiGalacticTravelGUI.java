
package net.mcreator.tmsmod.gui;

import org.lwjgl.opengl.GL11;
import org.lwjgl.input.Keyboard;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Container;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.GuiButton;

import net.mcreator.tmsmod.TmsModMod;
import net.mcreator.tmsmod.ElementsTmsModMod;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

import java.io.IOException;

@ElementsTmsModMod.ModElement.Tag
public class GuiGalacticTravelGUI extends ElementsTmsModMod.ModElement {
	public static int GUIID = 8;
	public static HashMap guistate = new HashMap();
	public GuiGalacticTravelGUI(ElementsTmsModMod instance) {
		super(instance, 1588);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		elements.addNetworkMessage(GUIButtonPressedMessageHandler.class, GUIButtonPressedMessage.class, Side.SERVER);
		elements.addNetworkMessage(GUISlotChangedMessageHandler.class, GUISlotChangedMessage.class, Side.SERVER);
	}
	public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {
		private IInventory internal;
		private World world;
		private EntityPlayer entity;
		private int x, y, z;
		private Map<Integer, Slot> customSlots = new HashMap<>();
		public GuiContainerMod(World world, int x, int y, int z, EntityPlayer player) {
			this.world = world;
			this.entity = player;
			this.x = x;
			this.y = y;
			this.z = z;
			this.internal = new InventoryBasic("", true, 0);
		}

		public Map<Integer, Slot> get() {
			return customSlots;
		}

		@Override
		public boolean canInteractWith(EntityPlayer player) {
			return internal.isUsableByPlayer(player);
		}

		@Override
		public void onContainerClosed(EntityPlayer playerIn) {
			super.onContainerClosed(playerIn);
			if ((internal instanceof InventoryBasic) && (playerIn instanceof EntityPlayerMP)) {
				this.clearContainer(playerIn, playerIn.world, internal);
			}
		}

		private void slotChanged(int slotid, int ctype, int meta) {
			if (this.world != null && this.world.isRemote) {
				TmsModMod.PACKET_HANDLER.sendToServer(new GUISlotChangedMessage(slotid, x, y, z, ctype, meta));
				handleSlotAction(entity, slotid, ctype, meta, x, y, z);
			}
		}
	}

	public static class GuiWindow extends GuiContainer {
		private World world;
		private int x, y, z;
		private EntityPlayer entity;
		public GuiWindow(World world, int x, int y, int z, EntityPlayer entity) {
			super(new GuiContainerMod(world, x, y, z, entity));
			this.world = world;
			this.x = x;
			this.y = y;
			this.z = z;
			this.entity = entity;
			this.xSize = 130;
			this.ySize = 233;
		}
		private static final ResourceLocation texture = new ResourceLocation("tms_mod:textures/galactic_travel_gui.png");
		@Override
		public void drawScreen(int mouseX, int mouseY, float partialTicks) {
			this.drawDefaultBackground();
			super.drawScreen(mouseX, mouseY, partialTicks);
			this.renderHoveredToolTip(mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
			GL11.glColor4f(1, 1, 1, 1);
			this.mc.renderEngine.bindTexture(texture);
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			this.drawModalRectWithCustomSizedTexture(k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
			zLevel = 100.0F;
			this.mc.renderEngine.bindTexture(new ResourceLocation("tms_mod:textures/planets-1.png.png"));
			this.drawModalRectWithCustomSizedTexture(this.guiLeft + 10, this.guiTop + 15, 0, 0, -1, -1, -1, -1);
			this.mc.renderEngine.bindTexture(new ResourceLocation("tms_mod:textures/planets-2.png.png"));
			this.drawModalRectWithCustomSizedTexture(this.guiLeft + 10, this.guiTop + 36, 0, 0, -1, -1, -1, -1);
			this.mc.renderEngine.bindTexture(new ResourceLocation("tms_mod:textures/planets-3.png.png"));
			this.drawModalRectWithCustomSizedTexture(this.guiLeft + 10, this.guiTop + 57, 0, 0, -1, -1, -1, -1);
			this.mc.renderEngine.bindTexture(new ResourceLocation("tms_mod:textures/planets-4.png.png"));
			this.drawModalRectWithCustomSizedTexture(this.guiLeft + 10, this.guiTop + 78, 0, 0, -1, -1, -1, -1);
			this.mc.renderEngine.bindTexture(new ResourceLocation("tms_mod:textures/planets-5.png.png"));
			this.drawModalRectWithCustomSizedTexture(this.guiLeft + 10, this.guiTop + 99, 0, 0, -1, -1, -1, -1);
			this.mc.renderEngine.bindTexture(new ResourceLocation("tms_mod:textures/planets-6.png.png"));
			this.drawModalRectWithCustomSizedTexture(this.guiLeft + 10, this.guiTop + 120, 0, 0, -1, -1, -1, -1);
			this.mc.renderEngine.bindTexture(new ResourceLocation("tms_mod:textures/planets-7.png.png"));
			this.drawModalRectWithCustomSizedTexture(this.guiLeft + 10, this.guiTop + 141, 0, 0, -1, -1, -1, -1);
			this.mc.renderEngine.bindTexture(new ResourceLocation("tms_mod:textures/planets-8.png.png"));
			this.drawModalRectWithCustomSizedTexture(this.guiLeft + 10, this.guiTop + 162, 0, 0, -1, -1, -1, -1);
			this.mc.renderEngine.bindTexture(new ResourceLocation("tms_mod:textures/planets-9.png.png"));
			this.drawModalRectWithCustomSizedTexture(this.guiLeft + 10, this.guiTop + 183, 0, 0, -1, -1, -1, -1);
			this.mc.renderEngine.bindTexture(new ResourceLocation("tms_mod:textures/planets-10.png.png"));
			this.drawModalRectWithCustomSizedTexture(this.guiLeft + 10, this.guiTop + 204, 0, 0, -1, -1, -1, -1);
			this.mc.renderEngine.bindTexture(new ResourceLocation("tms_mod:textures/planets-12.png.png"));
			this.drawModalRectWithCustomSizedTexture(this.guiLeft + 151, this.guiTop + 141, 0, 0, -1, -1, -1, -1);
			this.mc.renderEngine.bindTexture(new ResourceLocation("tms_mod:textures/planets-13.png.png"));
			this.drawModalRectWithCustomSizedTexture(this.guiLeft + 151, this.guiTop + 204, 0, 0, -1, -1, -1, -1);
			this.mc.renderEngine.bindTexture(new ResourceLocation("tms_mod:textures/planets-15.png.png"));
			this.drawModalRectWithCustomSizedTexture(this.guiLeft + 151, this.guiTop + 183, 0, 0, -1, -1, -1, -1);
			this.mc.renderEngine.bindTexture(new ResourceLocation("tms_mod:textures/planets-14.png.png"));
			this.drawModalRectWithCustomSizedTexture(this.guiLeft + 151, this.guiTop + 162, 0, 0, -1, -1, -1, -1);
		}

		@Override
		public void updateScreen() {
			super.updateScreen();
		}

		@Override
		protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
			super.mouseClicked(mouseX, mouseY, mouseButton);
		}

		@Override
		protected void keyTyped(char typedChar, int keyCode) throws IOException {
			super.keyTyped(typedChar, keyCode);
		}

		@Override
		protected void drawGuiContainerForegroundLayer(int par1, int par2) {
			this.fontRenderer.drawString("Galactic Travel", 30, 3, -12829636);
			this.fontRenderer.drawString("Bonus Planets", 171, 127, -1);
		}

		@Override
		public void onGuiClosed() {
			super.onGuiClosed();
			Keyboard.enableRepeatEvents(false);
		}

		@Override
		public void initGui() {
			super.initGui();
			this.guiLeft = (this.width - 130) / 2;
			this.guiTop = (this.height - 233) / 2;
			Keyboard.enableRepeatEvents(true);
			this.buttonList.clear();
			this.buttonList.add(new GuiButton(0, this.guiLeft + 28, this.guiTop + 13, 50, 20, "Earth"));
			this.buttonList.add(new GuiButton(1, this.guiLeft + 28, this.guiTop + 34, 95, 20, "Gravity Bubble"));
			this.buttonList.add(new GuiButton(2, this.guiLeft + 28, this.guiTop + 55, 75, 20, "Neptune II"));
			this.buttonList.add(new GuiButton(3, this.guiLeft + 28, this.guiTop + 76, 75, 20, "Betelguise"));
			this.buttonList.add(new GuiButton(4, this.guiLeft + 28, this.guiTop + 97, 85, 20, "Thicc Planet"));
			this.buttonList.add(new GuiButton(5, this.guiLeft + 28, this.guiTop + 118, 70, 20, "Snurbum-4"));
			this.buttonList.add(new GuiButton(6, this.guiLeft + 28, this.guiTop + 139, 50, 20, "KM-15"));
			this.buttonList.add(new GuiButton(7, this.guiLeft + 28, this.guiTop + 160, 80, 20, "Kobe Planet"));
			this.buttonList.add(new GuiButton(8, this.guiLeft + 28, this.guiTop + 181, 45, 20, "Kawp"));
			this.buttonList.add(new GuiButton(9, this.guiLeft + 28, this.guiTop + 202, 85, 20, "Distant Moon"));
			this.buttonList.add(new GuiButton(10, this.guiLeft + 169, this.guiTop + 160, 70, 20, "Rossmania"));
			this.buttonList.add(new GuiButton(11, this.guiLeft + 169, this.guiTop + 202, 55, 20, "Natrea"));
			this.buttonList.add(new GuiButton(12, this.guiLeft + 169, this.guiTop + 139, 70, 20, "Snurbum-9"));
			this.buttonList.add(new GuiButton(13, this.guiLeft + 169, this.guiTop + 181, 55, 20, "Dislex"));
		}

		@Override
		protected void actionPerformed(GuiButton button) {
			TmsModMod.PACKET_HANDLER.sendToServer(new GUIButtonPressedMessage(button.id, x, y, z));
			handleButtonAction(entity, button.id, x, y, z);
		}

		@Override
		public boolean doesGuiPauseGame() {
			return false;
		}
	}

	public static class GUIButtonPressedMessageHandler implements IMessageHandler<GUIButtonPressedMessage, IMessage> {
		@Override
		public IMessage onMessage(GUIButtonPressedMessage message, MessageContext context) {
			EntityPlayerMP entity = context.getServerHandler().player;
			entity.getServerWorld().addScheduledTask(() -> {
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			});
			return null;
		}
	}

	public static class GUISlotChangedMessageHandler implements IMessageHandler<GUISlotChangedMessage, IMessage> {
		@Override
		public IMessage onMessage(GUISlotChangedMessage message, MessageContext context) {
			EntityPlayerMP entity = context.getServerHandler().player;
			entity.getServerWorld().addScheduledTask(() -> {
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			});
			return null;
		}
	}

	public static class GUIButtonPressedMessage implements IMessage {
		int buttonID, x, y, z;
		public GUIButtonPressedMessage() {
		}

		public GUIButtonPressedMessage(int buttonID, int x, int y, int z) {
			this.buttonID = buttonID;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public void toBytes(io.netty.buffer.ByteBuf buf) {
			buf.writeInt(buttonID);
			buf.writeInt(x);
			buf.writeInt(y);
			buf.writeInt(z);
		}

		@Override
		public void fromBytes(io.netty.buffer.ByteBuf buf) {
			buttonID = buf.readInt();
			x = buf.readInt();
			y = buf.readInt();
			z = buf.readInt();
		}
	}

	public static class GUISlotChangedMessage implements IMessage {
		int slotID, x, y, z, changeType, meta;
		public GUISlotChangedMessage() {
		}

		public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
			this.slotID = slotID;
			this.x = x;
			this.y = y;
			this.z = z;
			this.changeType = changeType;
			this.meta = meta;
		}

		@Override
		public void toBytes(io.netty.buffer.ByteBuf buf) {
			buf.writeInt(slotID);
			buf.writeInt(x);
			buf.writeInt(y);
			buf.writeInt(z);
			buf.writeInt(changeType);
			buf.writeInt(meta);
		}

		@Override
		public void fromBytes(io.netty.buffer.ByteBuf buf) {
			slotID = buf.readInt();
			x = buf.readInt();
			y = buf.readInt();
			z = buf.readInt();
			changeType = buf.readInt();
			meta = buf.readInt();
		}
	}
	private static void handleButtonAction(EntityPlayer entity, int buttonID, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}

	private static void handleSlotAction(EntityPlayer entity, int slotID, int changeType, int meta, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}
}
