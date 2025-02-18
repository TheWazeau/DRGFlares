package net.doubledoordev.drgflares;

import org.apache.commons.lang3.tuple.Pair;
import net.minecraftforge.common.ForgeConfigSpec;

public class DRGFlaresConfig
{
    public static final DRGFlaresConfig.General GENERAL;
    static final ForgeConfigSpec spec;

    static
    {
        final Pair<General, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(DRGFlaresConfig.General::new);
        spec = specPair.getRight();
        GENERAL = specPair.getLeft();
    }

    public static class General
    {
        public ForgeConfigSpec.IntValue noSourceDecayTime;
        public ForgeConfigSpec.IntValue lightDecayTime;
        public ForgeConfigSpec.IntValue entityDecayTime;
        public ForgeConfigSpec.IntValue flareQuantity;
        public ForgeConfigSpec.IntValue flareReplenishTime;
        public ForgeConfigSpec.IntValue flareReplenishQuantity;
        public ForgeConfigSpec.IntValue flareLightLevel;

        public ForgeConfigSpec.DoubleValue bounceModifier;
        public ForgeConfigSpec.DoubleValue flareGravity;

        public ForgeConfigSpec.BooleanValue hitEntityGlows;
        public ForgeConfigSpec.BooleanValue lightBlockDebug;
        public ForgeConfigSpec.BooleanValue displayFlareCount;
        public ForgeConfigSpec.BooleanValue makeNoiseWhenThrown;

        General(ForgeConfigSpec.Builder builder)
        {
            builder.comment("General configuration settings")
                    .push("General");

            noSourceDecayTime = builder
                    .comment("How fast in ticks light sources with no entity are removed. Lower values are faster. 20 ticks = 1 second, 1200 ticks = 1 minute, 72000 ticks = 1 hour")
                    .translation("drgflares.config.noSourceDecayTime")
                    .defineInRange("noSourceDecayTime", 7, 1, Integer.MAX_VALUE);

            flareQuantity = builder
                    .comment("How many flares a single player can hold.")
                    .translation("drgflares.config.flareQuantity")
                    .defineInRange("flareQuantity", 5, 1, Integer.MAX_VALUE);

            flareReplenishTime = builder
                    .comment("Time it takes for a flare to be replenished back to the pile. Lower values are faster. 20 ticks = 1 second, 1200 ticks = 1 minute, 72000 ticks = 1 hour")
                    .translation("drgflares.config.flareReplenishTime")
                    .defineInRange("flareReplenishTime", 6000, 1, Integer.MAX_VALUE);

            flareReplenishQuantity = builder
                    .comment("How many flares are replenished per replenish cycle.")
                    .translation("drgflares.config.flareReplenishQuantity")
                    .defineInRange("flareReplenishQuantity", 1, 1, Integer.MAX_VALUE);

            lightDecayTime = builder
                    .comment("How long in ticks light sources will last. Lower values are faster. 20 ticks = 1 second, 1200 ticks = 1 minute, 72000 ticks = 1 hour")
                    .translation("drgflares.config.lightDecayTime")
                    .defineInRange("lightDecayTime", 6000, 1, Integer.MAX_VALUE);

            entityDecayTime = builder
                    .comment("How long in ticks until the entity will despawn after the light has gone out. Lower values are faster. 20 ticks = 1 second, 1200 ticks = 1 minute, 72000 ticks = 1 hour")
                    .translation("drgflares.config.entityDecayTime")
                    .defineInRange("entityDecayTime", 6000, 0, Integer.MAX_VALUE);

            flareLightLevel = builder
                    .comment("Light level the flares provide 1-16.")
                    .translation("drgflares.config.flareLightLevel")
                    .defineInRange("flareLightLevel", 15, 1, 16);

            bounceModifier = builder
                    .comment("Bounce dampening modifier. Higher numbers = less bounce.")
                    .translation("drgflares.config.bounceModifier")
                    .defineInRange("bounceModifier", 2, 0, Double.MAX_VALUE);

            flareGravity = builder
                    .comment("How much movement is removed from the entity over time in the Y direction. AKA GRAVITY! Higher = thicc flares")
                    .translation("drgflares.config.flareGravity")
                    .defineInRange("flareGravity", 0.03F, 0, 1);

            hitEntityGlows = builder
                    .comment("If the thrown flare hits an entity, it will break and make them glow.")
                    .translation("drgflares.config.hitEntityGlows")
                    .define("hitEntityGlows", true);

            lightBlockDebug = builder
                    .comment("If for whatever reason you are having issues with the invisible lights doing odd stuff enable this to see them.")
                    .translation("drgflares.config.lightBlockDebug")
                    .worldRestart()
                    .define("lightBlockDebug", false);

            displayFlareCount = builder
                    .comment("Display the count of flares currently stored on the player in the HUD.")
                    .translation("drgflares.config.displayFlareCount")
                    .worldRestart()
                    .define("displayFlareCount", true);

            makeNoiseWhenThrown = builder
                    .comment("If flares make a noise when thrown.")
                    .translation("drgflares.config.makeNoiseWhenThrown")
                    .worldRestart()
                    .define("makeNoiseWhenThrown", true);

            builder.pop();
        }
    }
}
