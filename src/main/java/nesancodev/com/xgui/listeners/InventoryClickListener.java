package nesancodev.com.xgui.listeners;

import nesancodev.com.xgui.gui.GUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class InventoryClickListener implements Listener {
    public static HashMap<Inventory, ItemStack> clickedItemHashMap = new HashMap<>();
    public static HashMap<Inventory, ClickType> clickTypeHashMap = new HashMap<>();
    public static HashMap<Inventory, Integer> clickedSlotHashMap = new HashMap<>();
    public static HashMap<Inventory, Player> clickerHashMap = new HashMap<>();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        GUI gui = GUI.guiHashMap.get(e.getInventory());

        if (gui == null) {
            return;
        }

        // STORE INFO
        clickedItemHashMap.put(e.getInventory(), e.getCurrentItem());
        clickTypeHashMap.put(e.getInventory(), e.getClick());
        clickedSlotHashMap.put(e.getInventory(), e.getSlot());
        clickerHashMap.put(e.getInventory(), (Player) e.getWhoClicked());
        //

        // RUN LISTENERS
        if (gui.getClickHashMap().get(e.getInventory()) != null) {
            gui.getClickHashMap().get(e.getInventory()).run();
        }

        // RUN BUTTONS
        if (gui.getButtonHashMap().get(e.getSlot()) != null) {
            gui.getButtonHashMap().get(e.getSlot()).getRunnable().run();
        }
        //

        // CHECK IF LOCKED
        if (gui.isLocked()) {
            e.setCancelled(true);
        }
        //
    }
}
