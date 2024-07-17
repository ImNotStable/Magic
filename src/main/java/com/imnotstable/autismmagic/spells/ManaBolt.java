package com.imnotstable.autismmagic.spells;

import com.destroystokyo.paper.ParticleBuilder;
import com.imnotstable.autismmagic.util.ParticleUtils;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ManaBolt implements ISpell {
  
  @Override
  public @NotNull String getName() {
    return "<aqua>Mana Bolt";
  }
  
  @Override
  public @NotNull List<@NotNull String> getDescription() {
    return List.of("<gray>Shoots a bolt of mana at your target");
  }
  
  @Override
  public int getManaCost() {
    return 5;
  }
  
  @Override
  public void cast(@NotNull Player caster) {
    Entity rawTarget = caster.getTargetEntity(20);
    
    if (!(rawTarget instanceof LivingEntity target))
      return;
    
    ParticleUtils.createParticleLine(
      caster.getEyeLocation().toVector(),
      target.getLocation().toVector().add(new Vector(0, 1, 0)),
      caster.getWorld(),
      new ParticleBuilder(Particle.DUST)
        .data(new Particle.DustOptions(Color.AQUA, 1))
        .count(1)
        .extra(0)
    );
    target.damage(1, caster);
  }
}
