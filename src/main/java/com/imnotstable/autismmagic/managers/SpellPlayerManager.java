package com.imnotstable.autismmagic.managers;

import com.imnotstable.autismmagic.AutismMagic;
import com.imnotstable.autismmagic.SpellPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SpellPlayerManager {
  
  private static final Map<UUID, SpellPlayer> spellPlayers = new HashMap<>();

  public static void load(AutismMagic plugin) {
    plugin.getServer().getOnlinePlayers().forEach(player -> spellPlayers.put(player.getUniqueId(), SpellPlayer.of(player)));
    Bukkit.getPluginManager().registerEvents(new Listener(){
     
      @EventHandler
      public void on(PlayerJoinEvent event) {
        spellPlayers.put(event.getPlayer().getUniqueId(), SpellPlayer.of(event.getPlayer()));
      }
      
    }, plugin);
  }
  
  public static SpellPlayer getSpellPlayer(UUID uuid) {
    return spellPlayers.get(uuid);
  }
  
}
