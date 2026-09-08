package net.dillon.speedrunnermod.platform;

import net.dillon.dillonlib.platform.PlatformLoader;
import net.dillon.dillonlib.platform.client.ClientModPlatform;
import net.dillon.speedrunnermod.helper.ModConstants;

public class SpeedrunnerModClientPlatforms {
    private static final ClientModPlatform CLIENT_PLATFORM = PlatformLoader.load(ClientModPlatform.class, ModConstants.MOD_ID);

    public static ClientModPlatform getClientPlatform() {
        return CLIENT_PLATFORM;
    }
}