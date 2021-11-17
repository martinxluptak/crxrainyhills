package com.luptak.crxrainyhills;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RainyHillsWebController.class)
public class RainyHillsWebControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenValidInput_thenReturns200() throws Exception {
        mockMvc.perform(get("/rainy")
                        .param("surfaces", "1,2,3"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/rainy")
                        .param("surfaces", "2,4,6,8,10,8,6,4,2"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/rainy")
                        .param("surfaces", "10,8,6,4,2,0,2,4,6,8,10"))
                .andExpect(status().isOk());
        mockMvc.perform(get("/rainy")
                        .param("surfaces", ""))
                .andExpect(status().isOk()); // empty list is a valid input
        mockMvc.perform(get("/rainy")
                        .param("surfaces", "-4,-2,-4"))
                .andExpect(status().isOk()); // negative integers are a valid input
    }

    @Test
    void whenMissingSurfacesParameter_thenReturns400() throws Exception {
        mockMvc.perform(get("/rainy"))
                .andExpect(status().isBadRequest()); // no GET parameters
        mockMvc.perform(get("/rainy")
                        .param("wrongParameter", "wrongParameterValue"))
                .andExpect(status().isBadRequest());
        mockMvc.perform(get("/rainy")
                        .param("surfacez", "wrongParameterValue"))
                .andExpect(status().isBadRequest());
        mockMvc.perform(get("/rainy")
                        .param("123", "wrongParameterValue"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenValidAndUnsupportedParametersPresent_thenReturns200() throws Exception {
        mockMvc.perform(get("/rainy")
                .param("surfaces", "10,8,6,4,2,0,2,4,6,8,10")
                .param("wrongParameter", "wrongParameterValue"))
                .andExpect(status().isOk());
    }

    @Test
    void whenWrongParameterType_thenReturns400() throws Exception {
        mockMvc.perform(get("/rainy")
                        .param("surfaces", "1,2,null"))
                .andExpect(status().isBadRequest());
        mockMvc.perform(get("/rainy")
                        .param("surfaces", "2,4,stringValue,8,10,8,6,4,2"))
                .andExpect(status().isBadRequest());
    }
}
