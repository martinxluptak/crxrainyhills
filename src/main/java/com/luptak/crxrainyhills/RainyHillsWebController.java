package com.luptak.crxrainyhills;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles web queries for CrxrainyhillsApplication.
 */
@RestController
public class RainyHillsWebController {

    RainCalculator rainCalculator = new RainCalculatorImpl();

    /**
     * @param surfaces An array of integers describing the height profile of a surface.
     * @return an integer specifying the maximum rain water volume of this height profile.
     */
    @GetMapping("/rainy")
    public int getMaxRainWaterVolume(@RequestParam int[] surfaces) {
        return rainCalculator.getMaxWater(surfaces);
    }
}
