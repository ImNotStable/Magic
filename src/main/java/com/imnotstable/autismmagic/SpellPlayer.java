package com.imnotstable.autismmagic;

import com.imnotstable.autismmagic.spells.ISpell;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.util.ArrayList;
import java.util.UUID;

public class SpellPlayer {
  
  public static SpellPlayer of(Player player) {
    return new SpellPlayer(player.getUniqueId());
  }
  
  @Getter
  private final UUID uniqueId;
  @Setter
  @Getter
  private double mana;
  @Setter
  @Getter
  private double maxMana;
  private final ArrayList<ISpell> spells;
  
  private SpellPlayer(UUID uniqueId) {
    this.uniqueId = uniqueId;
    this.mana = maxMana = 100;
    spells = new ArrayList<>(4);
  }
  
  public void addMana(double amount) {
    mana += amount;
  }
  
  public void removeMana(double amount) {
    mana -= amount;
  }
  
  public void setSpell(@Range(from = 0, to = 4) int slot, @Nullable ISpell spell) {
    spells.set(slot, spell);
  }
  
  public @NotNull ArrayList<@Nullable ISpell> getSpells() {
    return spells;
  }
  
}
