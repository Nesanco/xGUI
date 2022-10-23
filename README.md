# Information
This is a GUI library which makes creating GUIs easier, this has no use for server owners. The library currently features animations, buttons, events, extra methods, and more

# Maven
```
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
```

```
        <dependency>
            <groupId>com.github.Nesanco</groupId>
            <artifactId>xGUI</artifactId>
            <version>VERSION</version>
            <scope>provided</scope>
        </dependency>
```

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

# Buttons
You can easily create buttons by using the Button constructor, then adding the button to the gui using ``gui.addButton(slot, button)`` you don't need to create a seperate constructor for the button, you could just do 
```
        gui.addButton(10, new Button(new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage("Hello!");
            }
        }));
```

# Animations
You can easily create animations by using the Animation constructor, then adding the animation to the gui using ``gui.addAnimation(slot, button)``, the constructor allows you to easily customize the animation by adding new frames, setting the time of the frames, toggling, or playing the animation, and more, example:
```
        Animation animation = new Animation();
        animation.newFrame(buildItem(Material.RED_WOOL, "&4Red Wool", ""));
        animation.newFrame(buildItem(Material.BLUE_WOOL, "&9Blue Wool", ""));
        animation.newFrame(buildItem(Material.GREEN_WOOL, "&2Green Wool", ""));
        animation.setTime(20);
        
        gui.addAnimation(10, animation);
        animation.toggle();
```

You can also create animation groups which allow you to add multiple animations to a group, you will then be able to add frames to all of the animations in the group, toggle them, player them, set the time for them, etc, example:
```
        AnimationGroup g1 = new AnimationGroup();
        g1.addAnimation(1, new Animation()); // 1 is the slot the animation will be played in
        g1.addAnimation(2, new Animation()); // 2 is the slot the animation will be played in
        g1.addAnimation(3, new Animation()); // 3 is the slot the animation will be played in

        g1.newFrame(buildItem(Material.RED_WOOL, "&4Red", ""));
        g1.newFrame(buildItem(Material.BLUE_WOOL, "&9Blue", ""));
        g1.newFrame(buildItem(Material.YELLOW_WOOL, "&eYellow", ""));

        gui.addAnimation(g1);

        g1.toggle();
```

# Utils
You can easily create ItemStacks using the ItemBuilder class, example:
```
ItemBuilder.buildItem(Material.RED_WOOL, "&4Red Wool")
```



