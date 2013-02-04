package gr.hd.onlinestore;

import gr.hd.onlinestore.Basket;
import gr.hd.onlinestore.BroadbandAddOnService;
import gr.hd.onlinestore.shop.BroadbandProducts;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBroadbandAddOnServiceTest extends TestBase {

    @Autowired BroadbandAddOnService broadbandAddOnService;
    
    @Test
    public void serviceAllAddOnsAvailable(){
        String postcodeAvailable = "11";
        Basket basket = new Basket();
        broadbandAddOnService.checkForAddOnProducts(basket, postcodeAvailable);
        int expected = BroadbandProducts.values().length;
        int actual = basket.getAvailableProducts().size();
        Assert.assertEquals(expected, actual);
        Assert.assertTrue(basket.hasValidPostCode());
    }
    
    @Test
    public void serviceNoneAddOns(){
        Basket basket = new Basket();
        String postcodeAvailable = "21";
        broadbandAddOnService.checkForAddOnProducts(basket, postcodeAvailable);
        int expectedSize = 0;
        int actualSize = basket.getAvailableProducts().size();
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertTrue(basket.hasValidPostCode());
        
        basket = new Basket();
        postcodeAvailable = "31";
        broadbandAddOnService.checkForAddOnProducts(basket, postcodeAvailable);
        actualSize = basket.getAvailableProducts().size();
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertTrue(basket.hasValidPostCode());
        
        basket = new Basket();
        postcodeAvailable = "41";
        broadbandAddOnService.checkForAddOnProducts(basket, postcodeAvailable);
        actualSize = basket.getAvailableProducts().size();
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertFalse(basket.hasValidPostCode());
        
        basket = new Basket();
        postcodeAvailable = "51";
        broadbandAddOnService.checkForAddOnProducts(basket, postcodeAvailable);
        actualSize = basket.getAvailableProducts().size();
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertTrue(basket.hasValidPostCode());
    }
    
}
