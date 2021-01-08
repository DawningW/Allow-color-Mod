package io.github.qingchenw.allowcolor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import com.google.common.eventbus.Subscribe;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;

public class AllowColorEventListener {
    public static final char FORMAT_CODE = '\u00A7';
    public static final char[] ALL_CODES = { '\0', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'k', 'l', 'm', 'n', 'o', 'r' };

    private static Logger logger;

    @SideOnly(Side.CLIENT)
    private boolean isLocal;
    @SideOnly(Side.CLIENT)
    private List<GuiButton> buttonList = new ArrayList<GuiButton>();

    public static void init(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        MinecraftForge.EVENT_BUS.register(new AllowColorEventListener());

        logger().info("Allow Color Mod has been installed successfully, made by QingChenW. ");
        logger().info("Can you input format code? " + ChatAllowedCharacters.isAllowedCharacter(FORMAT_CODE));

        logger().info("Your version is 1.7.10, trying to enable format code GUI(Experimental). ");
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void loadWorld(WorldEvent.Load event) {
        Minecraft mc = Minecraft.getMinecraft();
        this.isLocal = (mc.getIntegratedServer() != null);
        logger().info("Is local game: " + this.isLocal);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void initGuiPost(GuiScreenEvent.InitGuiEvent.Post event) {
        if (event.gui instanceof GuiChat) {
            GuiScreen screen = event.gui;
            this.buttonList.clear();
            for (int i = 0; i < ALL_CODES.length; i++) {
                String text = (i == 0) ? (this.isLocal ? String.valueOf(FORMAT_CODE) : "&") : ("" + FORMAT_CODE + ALL_CODES[i] + ALL_CODES[i]);
                GuiButton button = new GuiButton(i, 2 + i * 14, screen.height - 26, text);
                button.width = 13;
                button.height = 11;
                this.buttonList.add(button);
            }
            event.buttonList.addAll(this.buttonList);
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void clickButtonPost(GuiScreenEvent.ActionPerformedEvent.Post event) {
        if (event.gui instanceof GuiChat) {
            for (GuiButton button : this.buttonList) {
                if (event.button == button) {
                    String text = (this.isLocal ? "" + FORMAT_CODE : "&") + ALL_CODES[button.id];
                    this.insertText((GuiChat) event.gui, text);
                }
            }
        }
    }

    /**
     * 将字符串插入到聊天框的光标位置 <br>
     * 本来想用AT来着,但是我觉得用反射也无伤大雅吧
     * 
     * @author QingChenW
     * 
     * @param guiChat 聊天界面
     * @param text    要插入的文字
     */
    @SideOnly(Side.CLIENT)
    private void insertText(GuiChat guiChat, String text) {
        logger().debug("You typed: " + text);
        try {
            Field f = ReflectionHelper.findField(GuiChat.class, "inputField");
            f.setAccessible(true);
            GuiTextField inputField = (GuiTextField) f.get(guiChat);
            inputField.writeText(text); // FIXME 原版算法的光标计算有问题
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Logger logger() {
        return logger;
    }
}
