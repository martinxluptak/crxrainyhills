package com.luptak.crxrainyhills;

public interface RainCalculator {

    /**
     * Get the volume of maximum trapped rain water for a surface height profile.
     *
     * @param surfaces an integer array describing the surface height profile.
     * @return an integer specifying the maximum trapped rain water volume.
     */
    int getMaxWater(int[] surfaces);
}
