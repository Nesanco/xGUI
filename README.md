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
                        
        GUI gui = new GUI("test", GUIType.CHEST, 36);
        gui.content(conent);
        gui.addFormat("#", buildItem(Material.GRAY_STAINED_GLASS_PANE, " ", ""));
        gui.addFormat("$", buildItem(Material.RED_WOOL, "&4Red Wool", ""));
        gui.addFormat("%", buildItem(Material.BLUE_WOOL, "&9Blue Wool", ""));
        
        which would 
