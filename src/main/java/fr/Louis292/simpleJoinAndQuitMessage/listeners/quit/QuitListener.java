package fr.Louis292.simpleJoinAndQuitMessage.listeners.quit;

import fr.Louis292.simpleJoinAndQuitMessage.SimpleJoinAndQuitMessage;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (SimpleJoinAndQuitMessage.QUIT_REQUIRE_PERMISSION) {
            if (!player.hasPermission(SimpleJoinAndQuitMessage.QUIT_PERMISSION)) {
                return;
            }
        }

        String message = SimpleJoinAndQuitMessage.QUIT_MESSAGE;

        if (SimpleJoinAndQuitMessage.USE_DISPLAY_NAME) {
            message = message.replace("{PLAYER}", player.getDisplayName());
        } else {
            message = message.replace("{PLAYER}", player.getName());
        }

        message = ChatColor.translateAlternateColorCodes('&', message);

        event.setQuitMessage(message);
    }
}
