package org.riking.herocraft.externsample;

import org.bukkit.plugin.java.JavaPlugin;

import com.herocraftonline.heroes.api.SkillRegistrar;

public class ExternalHeroesSkill extends JavaPlugin {
    @Override
    public void onLoad() {
    }

    @Override
    public void onEnable() {
        SkillRegistrar.registerSkill(this, SkillTest.class);
    }

}
