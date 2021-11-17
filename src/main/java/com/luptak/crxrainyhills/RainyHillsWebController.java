package com.luptak.crxrainyhills;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Handles web queries for CrxrainyhillsApplication.
 */
@RestController
public class RainyHillsWebController {

    /**
     * TODO: Attach business logic.
     *
     * @param surfaces An array of integers describing the height profile of a surface.
     * @return an integer specifying the maximum rain water volume of this height profile.
     */
    @GetMapping("/rainy")
    public String getMaxRainWaterVolume(@RequestParam int[] surfaces) {
        return "Hello world! Input: " + Arrays.toString(surfaces);
    }
}
