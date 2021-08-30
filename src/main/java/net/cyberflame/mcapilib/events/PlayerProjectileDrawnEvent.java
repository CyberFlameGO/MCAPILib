package net.cyberflame.mcapilib.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a player is firing a bow and the server is choosing an projectile to use.
 */
public class PlayerProjectileDrawnEvent extends PlayerEvent implements Cancellable
{
    private static final HandlerList handlers = new HandlerList();
    @NotNull
    private final ItemStack bow;
    @NotNull
    private final ItemStack projectile;
    private boolean cancelled = false;

    public PlayerProjectileDrawnEvent(@NotNull Player player, @NotNull ItemStack bow, @NotNull ItemStack projectile) {
        super(player);
        this.bow   = bow;
        this.projectile = projectile;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }

    /**
     * @return the bow the player is using to fire the arrow (in case of bow and arrow)
     */
    @NotNull
    public ItemStack getBow() {
        return bow;
    }

    /**
     * @return the projectile that is attempting to be used
     */
    @NotNull
    public ItemStack getProjectile() {
        return projectile;
    }

    @NotNull
    public HandlerList getHandlers() {
        return handlers;
    }

    /**
     * Whether the use of this projectile is cancelled.
     * On cancel, the server will try the next projectile available and fire another event.
     */
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Cancel use of this projectile.
     * On cancel, the server will try the next projectile available and fire another event.
     *
     * @param cancel true if you wish to cancel this event
     */
    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }
}