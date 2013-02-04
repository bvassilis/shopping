package gr.hd.onlinestore;

import static org.junit.matchers.JUnitMatchers.containsString;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import gr.hd.onlinestore.Basket;
import gr.hd.onlinestore.ProductController;
import gr.hd.onlinestore.shop.BroadbandProducts;

import org.junit.Assert;
import org.junit.Test;

public class ProductControllerTest extends TestBase {

    // Test acceptance criteria

    @Test
    public void controllerTest() throws Exception {
        String postcode = "1";
        mockMvc.perform(get("/product")
                .param("postcode", postcode))
            .andExpect(status().isOk())
            .andExpect(handler().handlerType(ProductController.class))
            .andExpect(handler().methodName("showBasket"))
            .andExpect(content().string(containsString(BroadbandProducts.UNLIMITED.name())));
        
        postcode = "2";
        String content = mockMvc.perform(get("/product")
                .param("postcode", postcode))
            .andExpect(status().isOk())
            .andExpect(handler().handlerType(ProductController.class))
            .andExpect(handler().methodName("showBasket"))
            .andReturn().getResponse().getContentAsString();
        Assert.assertFalse(content.contains(BroadbandProducts.UNLIMITED.name()));
        
        postcode = "3";
        content = mockMvc.perform(get("/product")
                .param("postcode", postcode))
            .andExpect(status().isOk())
            .andExpect(handler().handlerType(ProductController.class))
            .andExpect(handler().methodName("showBasket"))
            .andReturn().getResponse().getContentAsString();
        Assert.assertFalse(content.contains(BroadbandProducts.UNLIMITED.name()));
        
        postcode = "4";
        content = mockMvc.perform(get("/product")
                .param("postcode", postcode))
            .andExpect(status().isOk())
            .andExpect(handler().handlerType(ProductController.class))
            .andExpect(handler().methodName("showBasket"))
            .andReturn().getResponse().getContentAsString();
        Assert.assertFalse(content.contains(BroadbandProducts.UNLIMITED.name()));
        Assert.assertTrue(content.contains(Basket.invalidPostCode));
        
        postcode = "5";
        content = mockMvc.perform(get("/product")
                .param("postcode", postcode))
            .andExpect(status().isOk())
            .andExpect(handler().handlerType(ProductController.class))
            .andExpect(handler().methodName("showBasket"))
            .andReturn().getResponse().getContentAsString();
        Assert.assertFalse(content.contains(BroadbandProducts.UNLIMITED.name()));
    }

}
