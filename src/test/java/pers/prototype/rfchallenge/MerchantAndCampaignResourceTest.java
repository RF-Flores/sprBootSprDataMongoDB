package pers.prototype.rfchallenge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class MerchantAndCampaignResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getMerchants() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/challenge/merchants"))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void getMerchantById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/challenge/merchant/randomID"))
                .andExpect(status().isNotFound()).andReturn();
    }

    @Test
    public void getCampaigns() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/challenge/campaigns"))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void getCampaignsWithLimit() throws Exception {
        MvcResult mvcResultOk = mockMvc.perform(MockMvcRequestBuilders.get("/api/challenge/campaigns/1"))
                .andExpect(status().isOk()).andReturn();

        MvcResult mvcResultBadRequest = mockMvc.perform(MockMvcRequestBuilders.get("/api/challenge/campaigns/-1"))
                .andExpect(status().isBadRequest()).andReturn();

    }

    @Test
    public void getCampaignsWithLimitAndOffset() throws Exception {
        MvcResult mvcResultOk = mockMvc.perform(MockMvcRequestBuilders.get("/api/challenge/campaigns/1/1"))
                .andExpect(status().isOk()).andReturn();

        MvcResult mvcResultBadRequestLimit = mockMvc.perform(MockMvcRequestBuilders.get("/api/challenge/campaigns/-1/0"))
                .andExpect(status().isBadRequest()).andReturn();

        MvcResult mvcResultBadRequestOffset = mockMvc.perform(MockMvcRequestBuilders.get("/api/challenge/campaigns/1/-1"))
                .andExpect(status().isBadRequest()).andReturn();

    }

    @Test
    public void getCampaignById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/challenge/campaign/randomID"))
                .andExpect(status().isNotFound()).andReturn();
    }

    @Test
    public void consumeBudget() throws Exception {
        String requestBody = "{\n" +
                "    \"id\":\"randomID\",\n" +
                "    \"amount\": 10.1\n" +
                "}";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/challenge/campaign/consume")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isNotFound()).andReturn();

        MvcResult mvcResultBadRequest = mockMvc.perform(MockMvcRequestBuilders.post("/api/challenge/campaign/consume").content(""))
                .andExpect(status().isBadRequest()).andReturn();
    }

}
