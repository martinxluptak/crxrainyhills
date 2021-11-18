package com.luptak.crxrainyhills;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * Handles web queries for CrxrainyhillsApplication.
 */
@RestController
public class RainyHillsWebController {

    RainCalculator rainCalculator = new RainCalculatorImpl();

    /**
     * @param surfaces An array of integers describing the height profile of a surface.
     * @return a JSON object with integer property "volume" specifying the maximum rain water volume of this height profile.
     */
    @GetMapping(value = "/rainy", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Integer> getMaxRainWaterVolume(@RequestParam int[] surfaces) {
        int volume = rainCalculator.getMaxWater(surfaces);
        return Collections.singletonMap("volume", volume);
    }
}
