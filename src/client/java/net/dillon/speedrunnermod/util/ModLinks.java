package net.dillon.speedrunnermod.util;

import net.dillon.speedrunnermod.helper.ModConstants;

/**
 * All Speedrunner Mod {@code external links.}
 */
public class ModLinks {
    public static final String MODRINTH = "https://modrinth.com/mod/speedrunner-mod";
    public static final String MODRINTH_VERSIONS = "https://modrinth.com/mod/speedrunner-mod/versions";
    public static final String SHOWCASE_VIDEO = "https://youtu.be/08z9VvnFacw";
    public static final String RELEASE_TRAILER = "https://youtu.be/u37ujBiCMCw";

    public static final String SODIUM = link("https://modrinth.com/mod/sodium");
    public static final String LITHIUM = link("https://modrinth.com/mod/lithium");
    public static final String SPEEDRUNIGT = link("https://modrinth.com/mod/speedrunigt");
    public static final String KRYPTON = link("https://modrinth.com/mod/krypton");
    public static final String SIMPLE_KEYBINDS = link("https://modrinth.com/mod/simple-keybinds");
    public static final String QUALITY_OF_QUESO = link("https://modrinth.com/mod/quality-of-queso");

    /**
     * Returns a {@code link} with correct version filtering.
     */
    private static String link(String url) {
        return url + "/versions?g=" + ModConstants.MC_VERSION + "&l=fabric";
    }

    public static final String QUESTIONS_AND_ISSUES = "https://discord.gg/vfqEAn4YFy";
}