package org.riking.herocraft.externsample;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import com.herocraftonline.heroes.Heroes;
import com.herocraftonline.heroes.api.SkillResult;
import com.herocraftonline.heroes.characters.Hero;
import com.herocraftonline.heroes.characters.skill.ActiveSkill;
import com.herocraftonline.heroes.characters.skill.SkillConfigManager;
import com.herocraftonline.heroes.characters.skill.SkillSetting;
import com.herocraftonline.heroes.characters.skill.SkillType;

public class SkillTest extends ActiveSkill {

    public SkillTest(Heroes plugin) {
        super(plugin, "Test");
        setDescription("This is a test for externally provided skills.");
        setUsage("/skill test");
        setArgumentRange(0, 0);
        setTypes(SkillType.MOVEMENT);
    }

    @Override
    public ConfigurationSection getDefaultConfig() {
        final ConfigurationSection node = super.getDefaultConfig();
        node.set(SkillSetting.APPLY_TEXT.node(), "The test is a success!");
        return node;
    }

    @Override
    public void init() {
        setUseText(SkillConfigManager.getRaw(this, SkillSetting.APPLY_TEXT, "The test is a success!"));
        super.init();
    }

    @Override
    public SkillResult use(Hero hero, String[] args) {
        broadcastExecuteText(hero);

        final Player player = hero.getPlayer();
        player.getWorld().playEffect(player.getLocation(), org.bukkit.Effect.SMOKE, 4);

        return SkillResult.NORMAL;
    }

    @Override
    public String getDescription(Hero hero) {
        return getDescription();
    }
}
