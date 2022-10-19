package nesancodev.com.xgui.component.groups;

import nesancodev.com.xgui.component.Animation;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class AnimationGroup {
    private HashMap<Integer, Animation> animationHashMap = new HashMap<>();

    public AnimationGroup() {
    }

    public void addAnimation(int slot, Animation animation) {
        animationHashMap.put(slot, animation);
        animation.setSlot(slot);
    }

    public void removeAnimation(Animation animation) {
        for (int i : animationHashMap.keySet()) {
            if (animationHashMap.get(i) ==  animation) {
                animationHashMap.remove(i);
            }
        }
    }

    public void setTime(int ticks) {
        for (Animation animation : animationHashMap.values()) {
            animation.setTime(ticks);
        }
    }

    public void stop() {
        for (Animation animation : animationHashMap.values()) {
            animation.stop();
        }
    }

    public void newFrame(ItemStack stack) {
        for (Animation animation : animationHashMap.values()) {
            animation.newFrame(stack);
        }
    }

    public void play() {
        for (Animation animation : animationHashMap.values()) {
            animation.play();
        }
    }

    public void toggle() {
        for (Animation animation : animationHashMap.values()) {
            animation.toggle();
        }
    }

    public HashMap<Integer, Animation> getAnimationHashMap() {
        return animationHashMap;
    }
}
