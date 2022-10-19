package nesancodev.com.xgui.component;

import nesancodev.com.xgui.gui.GUI;
import nesancodev.com.xgui.xGUI;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;

public class Animation {

    private int counter = 1;
    private HashMap<Integer, ItemStack> animations = new HashMap<>();
    private int ticks = 60;
    private BukkitTask toggle;
    private Inventory inventory;
    private int slot;

    public Animation() {
    }

    public void newFrame(ItemStack stack) {
        animations.put(counter, stack);
        counter++;
    }

    public void setTime(int ticks) {
        this.ticks = ticks;
    }

    public int getTime() {
        return ticks;
    }

    public void setGUI(GUI gui) {
        this.inventory = gui.getDefaultInventory();
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public void play() {

        BukkitTask task = new BukkitRunnable() {
            int iterations = 1;
            final int keyframes = animations.values().size();

            @Override
            public void run() {
                ItemStack stack = animations.get(iterations);
                inventory.setItem(slot, stack);

                iterations++;

                if (iterations > keyframes) {
                    this.cancel();
                }
            }
        }.runTaskTimer(xGUI.instance, 0, ticks);
    }

    public void stop() {
        toggle.cancel();
    }

    public void toggle() {

        this.toggle = new BukkitRunnable() {
            int iterations = 1;
            final int keyframes = animations.values().size();

            @Override
            public void run() {
                ItemStack stack = animations.get(iterations);
                inventory.setItem(slot, stack);

                iterations++;

                if (iterations > keyframes) {
                    iterations = 1;
                }
            }
        }.runTaskTimer(xGUI.instance, 0, ticks);
    }
}
