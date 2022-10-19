package nesancodev.com.xgui.gui;

import nesancodev.com.xgui.component.Animation;
import nesancodev.com.xgui.component.Button;
import nesancodev.com.xgui.enums.GUIType;
import nesancodev.com.xgui.listeners.InventoryClickListener;
import nesancodev.com.xgui.listeners.InventoryCloseListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;

public class GUI {
    // DEFAULTS
    private String title = "Title";
    private int size = 45;
    private GUIType type = GUIType.CHEST;
    //

    // INVENTORY
    private Inventory inventory;
    //

    // CONTENT
    private String format;
    private HashMap<String, ItemStack> formatHashMap = new HashMap<>();

    //

    // LOCKING
    private boolean isLocked = false;
    //

    // COMPONENTS
    private HashMap<Integer, Button> buttonHashMap = new HashMap<>();
    private HashMap<Integer, Animation> animationHashMap = new HashMap<>();
    //

    // LISTENER INFO
    private HashMap<Inventory, BukkitRunnable> clickHashMap = new HashMap<>();
    private HashMap<Inventory, BukkitRunnable> closeHashMap = new HashMap<>();
    //

    // GUI STORING
    public static HashMap<Inventory, GUI> guiHashMap = new HashMap<>();
    //

    // ### ** ### CONSTRUCTORS ### ** ###
    public GUI (String title, GUIType type, int size) {
        this.title = title;
        this.type = type;
        this.size = size;

        this.inventory = Bukkit.createInventory(null, size, title);

        guiHashMap.put(this.inventory, this);
    }

    public GUI (String title, GUIType type) {
        this.title = title;
        this.type = type;

        this.inventory = Bukkit.createInventory(null, this.size, title);

        guiHashMap.put(this.inventory, this);
    }

    public GUI (String title) {
        this.title = title;

        this.inventory = Bukkit.createInventory(null, this.size, title);

        guiHashMap.put(this.inventory, this);
    }

    public GUI () {
        this.inventory = Bukkit.createInventory(null, this.size, this.title);

        guiHashMap.put(this.inventory, this);
    }
    // ### ** ### ### ** ###

    // ### ** ### GENERAL METHODS ### ** ###
    public Inventory getDefaultInventory() {
        return inventory;
    }

    public String getTitle() {
        return title;
    }

    public int getSize() {
        return size;
    }

    public ItemStack getItem(int slot) {
        return inventory.getItem(slot);
    }

    public void formatSlot(int slot, ItemStack item) {
        inventory.setItem(slot, item);
    }

    public void setSlot(int slot, ItemStack item) {
        inventory.setItem(slot, item);
    }

    public ArrayList<ItemStack> getAll(ItemStack stack) {
        ArrayList<ItemStack> stacks = new ArrayList<>();
        for (ItemStack x : inventory.getContents()) {
            if (x == stack) {
                stacks.add(x);
            }
        }
        return stacks;
    }

    public ArrayList<ItemStack> getAll(Material material) {
        ArrayList<ItemStack> stacks = new ArrayList<>();
        for (ItemStack x : inventory.getContents()) {
            if (x.getType() == material) {
                stacks.add(x);
            }
        }
        return stacks;
    }

    public HashMap<Integer, ItemStack> getAll() {
        HashMap<Integer, ItemStack> stackHashMap = new HashMap<>();
        for (int i = 0; i < inventory.getSize(); i++) {
            stackHashMap.put(i, inventory.getItem(i));
        }
        return stackHashMap;
    }

    public void remove(Integer i) {
        inventory.clear(i);
    }

    public void clear() {
        inventory.clear();
    }

    public GUIType getType() {
        return type;
    }

    public void lock() {
        isLocked = true;
    }

    public void unLock() {
        isLocked = false;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void border(ItemStack stack) {

        for (int i = 0; i < getSize(); i++) {
            // handle bottom
            if (i <= 8) {
                inventory.setItem(i, stack);
            }

            // handle top
            if (i >= getSize() - 8) {
                inventory.setItem(i, stack);
            }

            // handle left side
            if (i == 9 || i == 18 || i == 27 || i == 36) {
                inventory.setItem(i, stack);
            }

            // handle right side
            if (i == 17 || i == 26 || i == 35 || i == 44) {
                inventory.setItem(i, stack);
            }
        }
    }

    public HashMap<Integer, Button> getButtonHashMap() {
        return buttonHashMap;
    }

    public HashMap<Integer, Animation> getAnimationHashMap() {
        return animationHashMap;
    }

    public HashMap<Inventory, BukkitRunnable> getClickHashMap() {
        return clickHashMap;
    }

    public HashMap<Inventory, BukkitRunnable> getCloseHashMap() {
        return closeHashMap;
    }

    public void open(Player player) {
        if (this.format != null) {
            for(int i = 0; i < format.length(); i++)
            {
                String c = String.valueOf(format.charAt(i));
                if (formatHashMap.get(c) != null) {
                    ItemStack stack = formatHashMap.get(c);
                    inventory.setItem(i, stack);
                }
            }
        }

        player.openInventory(inventory);
    }

    public void close(Player player) {
        player.closeInventory();
    }

    public void content(String format) {
        this.format = format;
    }

    public void addFormat(String text, ItemStack stack) {
        formatHashMap.put(text, stack);
    }
    // ### ** ### ### ** ###

    // ### ** ### COMPONENTS ### ** ###
    public void addButton(int slot, Button button) {
        buttonHashMap.put(slot, button);
    }

    public void addAnimation(int slot, Animation animation) {
        animationHashMap.put(slot, animation);

        animation.setSlot(slot);
        animation.setGUI(this);
    }
    // ### ** ### ### ** ###

    // ### ** ### LISTENERS ### ** ###
    public void onClick(BukkitRunnable runnable) {
        clickHashMap.put(this.inventory, runnable);
    }

    public void onClose(BukkitRunnable runnable) {
        closeHashMap.put(this.inventory, runnable);
    }
    // ### ** ### ### ** ###

    // ### ** ### CLICK INFO ### ** ###
    public int getLastClickedSlot() {
        return InventoryClickListener.clickedSlotHashMap.get(inventory);
    }

    public Player getLastClicker() {
        return InventoryClickListener.clickerHashMap.get(inventory);
    }

    public ItemStack getLastClickedItem() {
        return InventoryClickListener.clickedItemHashMap.get(inventory);
    }

    public ClickType getLastClickType() {
        return InventoryClickListener.clickTypeHashMap.get(inventory);
    }

    public Player getLastCloser() {
        return InventoryCloseListener.closerHashMap.get(inventory);
    }
    // ### ** ### ### ** ###
}
