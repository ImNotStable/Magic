package com.imnotstable.autismmagic.util;

import com.destroystokyo.paper.ParticleBuilder;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class ParticleUtils {
  
  public static void createParticleLine(Vector start, Vector end, World world, ParticleBuilder particle) {
    createParticleLine(start, end, world, particle, 0.1);
  }
  
  public static void createParticleLine(Vector start, Vector end, World world, Particle particle, double distanceBetweenParticles) {
    createParticleLine(start, end, world, new ParticleBuilder(particle).count(1).extra(0), distanceBetweenParticles);
  }
  
  public static void createParticleLine(Vector start, Vector end, World world, ParticleBuilder particle, double distanceBetweenParticles) {
    Vector direction = end.clone().subtract(start).normalize();
    double distance = start.distance(end);
    for (double i = 0; i < distance; i += distanceBetweenParticles) {
      Vector particleLocation = start.clone().add(direction.clone().multiply(i));
      particle.location(particleLocation.toLocation(world)).spawn();
    }
  }
  
}
