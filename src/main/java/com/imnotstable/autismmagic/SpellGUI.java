package com.imnotstable.autismmagic;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandTree;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SpellGUI {
  //    /SpellGUI < >
  private final CommandTree command = new CommandTree("spells")
    .executesPlayer((sender, args) -> {
      // Open the spell GUI
      ItemStack Filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
      Inventory gui = Bukkit.createInventory(sender, 27);
      for (int i = 0; i<gui.getSize(); i++){
        gui.setItem(i,Filler);
      }
      
    });
  
  public void register() {
    command.register();
  }
  
  public void unregister() {
    CommandAPI.unregister(command.getName(), false);
  }

}
