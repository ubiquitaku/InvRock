package ubiquitaku.invrock;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class InvRock extends JavaPlugin implements Listener {
    boolean r;
    FileConfiguration config;


    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new InvRock(),this);
        getCommand("ir").setExecutor(this);
        // Plugin startup logic
        try {
            r = config.getBoolean("r");
        } catch (NumberFormatException kaku){
            r = false;
            config.set("r",false);
            System.out.println("configの値を取得できなかったためデフォルトのfalseに設定されました");
        }
        r = config.getBoolean("r",false);
        saveConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("ir")) {
//            if (sender.isOp()) {
                if (args[0].equals("on")) {
                    r = true;
                    return true;
                }
                if (args[0].equals("off")) {
                    r = false;
                    return true;
                }
//            }
        }
        return true;
    }

    @EventHandler
    public void rock(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
//        if (p.isOp()) {
//            return;
//        }
        e.setCancelled(true);
        return;
    }
}
