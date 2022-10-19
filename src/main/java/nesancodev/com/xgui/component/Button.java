package nesancodev.com.xgui.component;

import org.bukkit.scheduler.BukkitRunnable;

public class Button {
    private BukkitRunnable runnable;

    public Button(BukkitRunnable runnable) {
        this.runnable = runnable;
    }

    public BukkitRunnable getRunnable() {
        return runnable;
    }
}
