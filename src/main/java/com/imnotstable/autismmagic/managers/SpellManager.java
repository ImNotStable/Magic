package com.imnotstable.autismmagic.managers;

import com.imnotstable.autismmagic.AutismMagic;
import com.imnotstable.autismmagic.spells.ISpell;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.util.HashMap;
import java.util.Map;

public class SpellManager {
  
  private static Map<String, ISpell> spells;
  
  public static void loadSpells() {
    spells = new HashMap<>();
    ClassLoader classLoader = AutismMagic.getSingleton().getClass().getClassLoader();
    Reflections reflections = new Reflections(new ConfigurationBuilder()
      .setUrls(ClasspathHelper.forClassLoader(classLoader))
      .setScanners(Scanners.SubTypes)
      .filterInputsBy(new FilterBuilder()
        .includePackage("com.imnotstable.pewpew.pewpews")
      )
      .addClassLoaders(classLoader));
    reflections.getSubTypesOf(ISpell.class).forEach(spellClass -> {
      try {
        ISpell spell = spellClass.getConstructor().newInstance();
        spells.put(spell.getClass().getSimpleName(), spell);
      } catch (ReflectiveOperationException exception) {
        exception.printStackTrace();
      }
    });
  }
  
  public static Map<String, ISpell> getSpells() {
    return new HashMap<>(spells);
  }
  
}
