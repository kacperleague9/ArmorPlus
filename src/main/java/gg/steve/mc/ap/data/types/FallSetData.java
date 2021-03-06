package gg.steve.mc.ap.data.types;

import gg.steve.mc.ap.data.SetData;
import gg.steve.mc.ap.data.SetDataType;
import gg.steve.mc.ap.message.MessageType;
import gg.steve.mc.ap.utils.SoundUtil;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FallSetData implements SetData {
    private SetDataType type;
    private ConfigurationSection section;
    private String entry;

    public FallSetData(ConfigurationSection section, String entry) {
        this.type = SetDataType.FALL;
        this.section = section;
        this.entry = entry;
    }

    @Override
    public void onApply(Player player) {

    }

    @Override
    public void onRemoval(Player player) {

    }

    @Override
    public void onHit(EntityDamageByEntityEvent event, Player damager) {

    }

    @Override
    public void onDamage(EntityDamageByEntityEvent event) {

    }

    @Override
    public void onFall(EntityDamageEvent event) {
        event.setCancelled(true);
        SoundUtil.playSound(this.section, this.entry, (Player) event.getEntity());
        MessageType.doProcMessage(this.section, this.entry, (Player) event.getEntity());
    }

    @Override
    public void onHungerDeplete(FoodLevelChangeEvent event) {

    }

    @Override
    public void onTargetDeath(EntityDeathEvent event, Player killer) {

    }

    // <-- Getters and Setters from this point on -->
    public ConfigurationSection getSection() {
        return section;
    }

    public void setSection(ConfigurationSection section) {
        this.section = section;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public SetDataType getType() {
        return type;
    }

    public void setType(SetDataType type) {
        this.type = type;
    }
}