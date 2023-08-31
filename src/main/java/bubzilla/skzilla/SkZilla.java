package bubzilla.skzilla;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public final class SkZilla extends JavaPlugin {

    private CommandSender sender;
    private Command cmd;
    private String label;
    private String[] args;

    @Override
    public void onEnable() {
        Plugin skript = getServer().getPluginManager().getPlugin("Skript");

        if (skript == null) {
            getLogger().severe("Could not find Skript! Disabling...");
            getServer().getPluginManager().disablePlugin(this);
            return;
        } else if (!skript.isEnabled()) {
            getLogger().severe("Skript seems to be disabled! Disabling...");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        SkriptAddon addon = Skript.registerAddon(this);

        try {
            addon.loadClasses("bubzilla.skzilla.elements");
        } catch (IOException e) {
            getLogger().severe("some error is here so uhh sorry i ain't giving you info");
        }

        getLogger().info("Enabled SkZilla!");
        getLogger().info("Keep in mind that SkZilla isn't that useful.");
        getLogger().info("And you should try to keep the scripts to yourself because its hard to find this random dependency!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled SkZilla :(");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase(("skzilla"))) {
            sender.sendMessage("You are running SkZilla.... i forgor");
            return true;
        }
        return false;
    }
}