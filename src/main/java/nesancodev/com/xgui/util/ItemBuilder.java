package nesancodev.com.xgui.util;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class ItemBuilder {

    public static ItemStack buildItem(Material material, String name,
                               String lore, Integer modeldata) {
        ItemStack it1 = new ItemStack(material);
        ItemMeta it1meta = it1.getItemMeta();
        String itm1 = t(name);
        it1meta.setCustomModelData(modeldata);
        it1meta.setLore(Collections.singletonList(t(lore)));
        it1meta.setDisplayName(itm1);
        it1.setItemMeta(it1meta);
        return it1;
    }

    public static ItemStack buildItem(Material material, String name,
                               String lore) {
        ItemStack it1 = new ItemStack(material);
        ItemMeta it1meta = it1.getItemMeta();
        String itm1 = t(name);
        it1meta.setLore(Collections.singletonList(t(lore)));
        it1meta.setDisplayName(itm1);
        it1.setItemMeta(it1meta);
        return it1;
    }

    public static ItemStack buildItem(Material material, String name) {
        ItemStack it1 = new ItemStack(material);
        ItemMeta it1meta = it1.getItemMeta();
        String itm1 = t(name);
        it1meta.setDisplayName(itm1);
        it1.setItemMeta(it1meta);
        return it1;
    }

    public static ItemStack buildItem(Material material) {
        return new ItemStack(material);
    }

    private static String t(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
