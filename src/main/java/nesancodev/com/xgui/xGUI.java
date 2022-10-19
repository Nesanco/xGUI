package nesancodev.com.xgui;

import nesancodev.com.xgui.listeners.InventoryClickListener;
import nesancodev.com.xgui.listeners.InventoryCloseListener;
import org.bukkit.plugin.Plugin;

public class xGUI {
    public static Plugin instance;

    public static void instance(Plugin plugin) {
        instance = plugin;

        instance.getServer().getPluginManager().registerEvents(new InventoryClickListener(), instance);
        instance.getServer().getPluginManager().registerEvents(new InventoryCloseListener(), instance);
    }

    public static Plugin getInstance() {
        return instance;
    }
}
