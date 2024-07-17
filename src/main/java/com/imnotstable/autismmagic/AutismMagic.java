package com.imnotstable.autismmagic;

import com.imnotstable.autismmagic.managers.SpellManager;
import com.imnotstable.autismmagic.managers.SpellPlayerManager;
import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class AutismMagic extends JavaPlugin {
  
  @Getter
  private static AutismMagic singleton;
  
  @Override
  public void onLoad() {
    singleton = this;
    CommandAPI.onLoad(new CommandAPIBukkitConfig(this));
  }
  
  @Override
  public void onEnable() {
    CommandAPI.onEnable();
    SpellManager.loadSpells();
    SpellPlayerManager.load(this);
  }
  
  @Override
  public void onDisable() {
    CommandAPI.onDisable();
  }
  
}
