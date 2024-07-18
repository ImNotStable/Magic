package com.imnotstable.autismmagic.managers;

import com.imnotstable.autismmagic.AutismMagic;
import com.imnotstable.autismmagic.SpellPlayer;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class ManaManager {

  public void load(){
    new BukkitRunnable() {
      
      @Override
      public void run() {
        Bukkit.getOnlinePlayers().forEach(player -> {
          SpellPlayer spellPlayer = SpellPlayerManager.getSpellPlayer(player.getUniqueId());
          spellPlayer.addMana(1);
          player.sendActionBar(MiniMessage.miniMessage().deserialize("<aqua>This is your mana bitch, " + spellPlayer.getMana() + "/" + spellPlayer.getMaxMana()));
        });
      }
      
    }.runTaskTimer(AutismMagic.getSingleton(), 0, 20);
    
    
  }
  
  
  
}
