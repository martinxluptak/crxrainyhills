package com.luptak.crxrainyhills;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class RainyHillsWebControllerMockBeanTests {

    @MockBean
    RainCalculator rainCalculator;

    @InjectMocks
    RainyHillsWebController controller;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void whenValidInput_getMaxWaterCalledOnce() throws Exception {

        int[] surfacesMock = {1, 2, 3};
        Mockito.when(rainCalculator.getMaxWater(surfacesMock))
                .thenReturn(0);

        mockMvc.perform(get("/rainy")
                        .param("surfaces", "1,2,3"))
                .andExpect(status().isOk());

        Mockito.verify(rainCalculator, times(1)).getMaxWater(surfacesMock);
    }
}
