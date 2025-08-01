package br.com._0xf.HideCommands;

import br.com._0xf.handlers.PreCommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        new PreCommandHandler(this);
        msgs();
    }

    void msgs() {
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§7==============================================================");
        Bukkit.getConsoleSender().sendMessage("§6=>[0xfHideCommands] §f" + this.getDescription().getName() + " " + this.getDescription().getVersion() + " plugin habilitado com sucesso!!!");
        Bukkit.getConsoleSender().sendMessage("§7==============================================================");
        Bukkit.getConsoleSender().sendMessage("");
    }
}