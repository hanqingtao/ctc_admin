package com.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:spring-context.xml"})
public class MapTest {
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
    private MockMvc mockMvc;
    
    private MockHttpServletRequest request;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        request = new MockHttpServletRequest();
    }

    @Test
    public void testStationList() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders.get("/getStationList");
        /*RequestBuilder builder = MockMvcRequestBuilders.post("/shopping/alipay")
				.param("grant_type", "password")
				.param("client_id", "demohour_pc")
				.param("client_secret", "FIJ539NV158F")
				.param("username", "whxu215@aliyun.com")
				.param("password", "Q1w2e3r4t5")
				.contentType("application/x-www-form-urlencoded");
        */
        mockMvc.perform(builder).andExpect(status().isOk()).andDo(print());

    }
}
