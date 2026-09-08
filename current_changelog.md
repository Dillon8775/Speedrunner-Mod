# Version 1.13
- Update to 26.3.

## Mod now requires [YetAnotherConfigLib](https://modrinth.com/mod/yacl) in order to run!
### Requires [Fabric Loader version 0.19.5](https://fabricmc.net/use/installer/) *and* [Fabric API version 0.160.0](https://modrinth.com/mod/fabric-api) or greater.
### Requires [DillonLib](https://modrinth.com/mod/dillon-lib) version 1.1 or greater.

## Removed Features
- The Speedrunner Paddle has been removed from the mod, and all fireproof boat items have also been removed. Speedrunner, warped and crimson boats are now immune to lava with the default boat crafting recipe with planks.
    - You no longer need a speedrunner paddle to make them fireproof.
    - The Dead Speedrunner Boat is still vulnerable to fire.
- All Dead Speedrunner Blocks can now be smelted in regular Speedrunner Blocks.
- Speedrunner ingots, nuggets and blocks can no longer be used to craft some vanilla items.
- Due to redundancy, all stripped speedrunner logs have been removed from the mod.

## Loot and Worldgen
- The mod's Structure Spawn Rate option is now a simple toggle switch, which has been renamed to the legacy "Make Structures More Common" option, and custom structure spawn rates are only possible via the config (and if Make Structures More Common option is enabled).
- Certain structure spawn rates have been modified.
- Abandoned camps generate more commonly.
- Forest and taiga abandoned camps can generate in the Speedrunner's Wasteland biome.
- More mobs now drop more loot, and modified some existing buffed loot tables, including piglin bartering and abandoned camps.
- Various mob spawning changes, and removed "Creature Spawn Rate" option.

## Fireball Changes
- The default fireball explosion power has been reverted to 1.
- On doom mode, zombies now only throw 1-2 explosion power fireballs, and the power is not increased based on the fireball explosion power option.

## Revamps and Other Changes
- The mod's built-in "fog" option is now disabled by default (meaning Minecraft's fog will be disabled by default).
- Tweaked how long certain speedrunner items last in a furnace as fuel.
- Doom blocks now function the same on easy and balanced mode as they do on doom mode.
- New number providers (floats and integers).
- Finally wiped the leaderboards from the mod entirely.
- Removed the mod's safe boot screen and links screen.
- Removed stronghold configuration options.
- Revamped speedrunner mod screens.

## Technical Changes
- Massive backend optimizations, and several changes to the mod's configuration system.
- Several tag removals for conventional item tag replacements.
- Removed "minBrightness" option.