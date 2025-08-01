package br.com._0xf.commands;

import br.com._0xf.HideCommands.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.List;

public class HiddedCommand implements Listener {

    private final List<String> commands;
    private final String message;

    public HiddedCommand(Main main) {
        this.commands = main.getConfig().getStringList("commands");
        this.message = ChatColor.translateAlternateColorCodes('&',main.getConfig().getString("message"));
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    void preCommandHandler(PlayerCommandPreprocessEvent e) {
        String[] split = e.getMessage().trim().split(" ");
        if (split.length == 0) return;

        String command = split[0].substring(1).toLowerCase();

        Player p = e.getPlayer();

        if(!p.hasPermission("hidecommands.bypass")) {
            if (commands.contains(command)) {

                e.setCancelled(true);
                p.sendMessage(message.replace("{command}", command));
            }
        }
    }
}
