package de.photon.AACAdditionPro.modules.clientcontrol;

import com.google.common.collect.ImmutableSet;
import de.photon.AACAdditionPro.modules.ModuleType;
import de.photon.AACAdditionPro.modules.PluginMessageListenerModule;
import de.photon.AACAdditionPro.util.pluginmessage.MessageChannel;
import org.bukkit.entity.Player;

import java.util.Set;

public class LiteLoaderControl extends ClientControlModule implements PluginMessageListenerModule
{
    private static final String[] LITELOADERFLAGS = {"LiteLoader"};

    @Override
    public void onPluginMessageReceived(final String channel, final Player player, final byte[] message)
    {
        if (this.shouldFlagBrandCheck(channel, player, message, LITELOADERFLAGS)) {
            executeCommands(player);
        }
    }

    @Override
    public Set<MessageChannel> getIncomingChannels()
    {
        return ImmutableSet.of(MessageChannel.MC_BRAND_CHANNEL);
    }

    @Override
    public ModuleType getModuleType()
    {
        return ModuleType.LITELOADER_CONTROL;
    }
}
