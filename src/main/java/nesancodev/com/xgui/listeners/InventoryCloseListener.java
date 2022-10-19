package nesancodev.com.xgui.listeners;

import nesancodev.com.xgui.gui.GUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

public class InventoryCloseListener implements Listener {

    public static HashMap<Inventory, Player> closerHashMap = new HashMap<>();

    @EventHandler
    public void onInventoryClick(InventoryCloseEvent e) {
        GUI gui = GUI.guiHashMap.get(e.getInventory());

        if (gui == null) {
            return;
        }

        // STORE INFO
        closerHashMap.put(e.getInventory(), (Player) e.getPlayer());
        //

        // RUN LISTENERS
        if (gui.getCloseHashMap().get(e.getInventory()) != null) {
            gui.getCloseHashMap().get(e.getInventory()).run();
        //
        }
    }
}
