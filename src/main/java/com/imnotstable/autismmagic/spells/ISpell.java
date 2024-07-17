package com.imnotstable.autismmagic.spells;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ISpell {
  
  @NotNull String getName();
  
  @NotNull List<@NotNull String> getDescription();
  
  int getManaCost();
  
  void cast(@NotNull Player caster);
  
}
