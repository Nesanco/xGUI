# Information
This is a GUI library which makes creating GUIs easier, this has no use for server owners. The library currently features animations, buttons, events, extra methods, and more

# Maven
Adding in a few mins

# Usage
Begin by registering xGUI, use this method in your onEnable
```xGUI.instance(this);```

GUIs can be created by using ```GUI gui = new GUI("title", GUIType.TYPE, size);``` every method is called from GUI, meaning every possible method can be easily seen and used. GUIs can eather be formatted normally by using ```gui.setSlot(slot, item)``` or you can use the content method, which allows you to sort of visualize your GUI by using different characters, example:
```
        String conent = "#########" +
                        "#$$$$$$$#" +
                        "#%%%%%%%#" +
                        "#########";
                        
        gui.content(conent);
        gui.addFormat("#", buildItem(Material.GRAY_STAINED_GLASS_PANE, " ", ""));
        gui.addFormat("$", buildItem(Material.RED_WOOL, "&4Red Wool", ""));
        gui.addFormat("%", buildItem(Material.BLUE_WOOL, "&9Blue Wool", ""));
```
        
which would look like:

![image](https://user-images.githubusercontent.com/80917510/196790942-8371e4b0-7b3b-463c-ba87-752eb0dffbb9.png)

# General Methods
This section contains some of the useful methods & how they are used
```gui.lock()``` Locks the GUI, meaning when someone tries to take the item out, the event is cancelled
```gui.border(ItemStack)``` Sets the border of the GUI to the specified item
```gui.getAll(ItemStack)``` Gets all the itemstacks that are the same as itemstack
```gui.getAll(Material)``` Gets all the itemstacks that have the same material
```gui.getAll()``` Returns a hashmap with an integer and an itemstack for each item and its slot
```gui.getDefaultInventory()``` Returns the default Bukkit inventory
```gui.close(Player)``` Close the gui for a player
```gui.open(Player)``` Open the gui for a player

# Events
There are currently 2 events you can use in your GUI
```gui.onClick(BukkitRunnable)``` Called when a player clicks in the GUI, use ``gui.getLastClicker()`` to get the last person that clicked in the GUI, use ``gui.getLastClickedSlot()`` to get the last clicked slot in the GUI, use ``gui.getLastClickedItem()`` to get the last clicked item in the GUI, use ``gui.getLastClickType()`` to get the type of the last click in the GUI

```gui.onClose(BukkitRunnable)``` Called when a player closes the GUI, use ``gui.getLastCloser()`` to get the person that closed the GUI

