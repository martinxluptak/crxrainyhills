package com.luptak.crxrainyhills;

class RainCalculatorImpl implements RainCalculator {

    /**
     * Get the volume of maximum trapped rain water for a surface height profile.
     * <p>
     * This implementation traverses the array once and only allocates a constant number of variables,
     * the computational complexity thus being O(n) and memory complexity O(1).
     * <p>
     * 1. Loop from index 0 to the end of the array and count holes.
     * 2. If a taller wall is found at the end of the array,
     * loop backwards and update the size of the last hole.
     *
     * @param surfaces an integer array describing the surface height profile.
     * @return an integer specifying the maximum trapped rain water volume.
     */
    public int getMaxWater(int[] surfaces) {
        // surfaces with less than elements can not form a rain water hole.
        if (surfaces.length < 3)
            return 0;

        // Start the loop from index 0.
        int prev = surfaces[0];

        // To store previous wall's index
        int prevIndex = 0;
        int water = 0;

        // 'temp' stores the water value until a larger wall is found.
        // If there are no larger walls, 'temp' value is subtracted from 'water' value.
        int temp = 0;
        for (int i = 1; i <= surfaces.length - 1; i++) {
            // If the current wall is taller than the previous wall,
            // set 'prev' to current wall.
            // (We start counting water in a new "hole" in the surface.)
            if (surfaces[i] >= prev) {
                prev = surfaces[i];
                prevIndex = i; // save index for the backwards loop in the second part.

                // Larger or same height wall is found, reset temp.
                temp = 0;
            } else {

                // Since current wall is shorter than
                // the previous, subtract previous
                // wall's height from the current wall's
                // height and add it to the water.
                water += prev - surfaces[i];

                // Store the same value in 'temp' as well.
                // If no larger wall is found, 'temp' is subtracted from 'water'.
                temp += prev - surfaces[i];
            }
        }

        // If the last wall was larger than or equal
        // to the previous wall then prevIndex would
        // be equal to size of the array.
        // If a wall taller than or equal height to the wall
        // stored at index 'prev' is not found from the left side,
        // then prevIndex must be less than the index
        // of the last element.
        int lastIndex = surfaces.length - 1;
        if (prevIndex < lastIndex) {

            // 'temp' stores the water collected
            // from previous largest wall till the end
            // of array if no larger wall was found.
            // That means it holds excess water that
            // needs to be subtracted.
            water -= temp;

            // Iterate from the end of the array,
            // so the value of 'prev' starts as the last element
            prev = surfaces[lastIndex];

            // Loop from the end of array up to the 'previous index'
            // which would contain the "largest wall from the left"
            for (int i = lastIndex; i >= prevIndex; i--)
                if (surfaces[i] >= prev)
                    // Right end wall is smaller than wall at index 'prev'
                    prev = surfaces[i];
                else
                    // Add water since right end wall is higher.
                    water += prev - surfaces[i];
        }

        // Return the maximum water
        return water;
    }
}
