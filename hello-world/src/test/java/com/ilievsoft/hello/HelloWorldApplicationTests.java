package com.ilievsoft.hello;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ilievsoft.hello.controller.HelloController;

@ContextConfiguration(classes = {HelloController.class})
@WebMvcTest
@AutoConfigureMockMvc
class HelloWorldApplicationTests {

	@Autowired
    private MockMvc mockMvc;
	
    @Test
    public void getsHello() throws Exception {
    	MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/hello")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())                
                .andReturn();
    	
    	String content = result.getResponse().getContentAsString();
    	assertThat(content).isEqualTo("Hello World");
    }
}


