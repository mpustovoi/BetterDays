package betterdays.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;

import net.minecraft.client.gui.screens.InBedChatScreen;

import betterdays.client.gui.SleepGui;
import betterdays.client.TimeInterpolator;

public class ClientEventListener {

    public static void setup() {
        ScreenEvents.AFTER_INIT.register((minecraft, screen, scaledWidth, scaledHeight) -> {
            if (screen instanceof InBedChatScreen) {
                ScreenEvents.afterRender(screen).register(((renderScreen, guiGraphics, mouseX, mouseY, tickDelta) -> {
                    SleepGui.onGuiEvent(renderScreen, guiGraphics);
                }));
            }
        });

        ClientTickEvents.END_CLIENT_TICK.register(TimeInterpolator::onClientTickEvent);
    }

}
