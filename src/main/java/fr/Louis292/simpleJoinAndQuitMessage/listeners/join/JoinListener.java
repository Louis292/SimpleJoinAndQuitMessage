package fr.Louis292.simpleJoinAndQuitMessage.listeners.join;

import fr.Louis292.simpleJoinAndQuitMessage.SimpleJoinAndQuitMessage;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (SimpleJoinAndQuitMessage.JOIN_REQUIRE_PERMISSION) {
            if (!player.hasPermission(SimpleJoinAndQuitMessage.JOIN_PERMISSION)) {
                return;
            }
        }

        String message = SimpleJoinAndQuitMessage.JOIN_MESSAGE;

        if (SimpleJoinAndQuitMessage.USE_DISPLAY_NAME) {
            message = message.replace("{PLAYER}", player.getDisplayName());
        } else {
            message = message.replace("{PLAYER}", player.getName());
        }

        message = ChatColor.translateAlternateColorCodes('&', message);

        event.setJoinMessage(message);
    }
}
