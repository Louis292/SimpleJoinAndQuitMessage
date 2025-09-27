package fr.Louis292.simpleJoinAndQuitMessage;

import fr.Louis292.simpleJoinAndQuitMessage.listeners.join.JoinListener;
import fr.Louis292.simpleJoinAndQuitMessage.listeners.quit.QuitListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleJoinAndQuitMessage extends JavaPlugin {
    public FileConfiguration config;

    public static boolean JOIN_MESSAGE_ACTIVE;
    public static String JOIN_MESSAGE;
    public static String JOIN_PERMISSION;
    public static boolean JOIN_REQUIRE_PERMISSION;

    public static boolean QUIT_MESSAGE_ACTIVE;
    public static String QUIT_MESSAGE;
    public static String QUIT_PERMISSION;
    public static boolean QUIT_REQUIRE_PERMISSION;

    public static boolean USE_DISPLAY_NAME;

    @Override
    public void onEnable() {
        getLogger().info("Starting...");

        this.saveDefaultConfig();
        config = getConfig();

        USE_DISPLAY_NAME = config.getBoolean("use_displayName");

        JOIN_MESSAGE_ACTIVE = config.getBoolean("join.active");
        JOIN_MESSAGE = config.getString("join.message");
        JOIN_PERMISSION = config.getString("join.permission");
        JOIN_REQUIRE_PERMISSION = config.getBoolean("join.require_permission");

        if (JOIN_MESSAGE_ACTIVE) {
            getServer().getPluginManager().registerEvents(new JoinListener(), this);
        }

        QUIT_MESSAGE_ACTIVE = config.getBoolean("quit.active");
        QUIT_MESSAGE = config.getString("quit.message");
        QUIT_PERMISSION = config.getString("quit.permission");
        QUIT_REQUIRE_PERMISSION = config.getBoolean("quit.require_permission");

        if (QUIT_MESSAGE_ACTIVE) {
            getServer().getPluginManager().registerEvents(new QuitListener(), this);
        }

        getLogger().info("The plugin was been start !");
    }

    @Override
    public void onDisable() {
        getLogger().info("The plugin was been disable");
    }
}
