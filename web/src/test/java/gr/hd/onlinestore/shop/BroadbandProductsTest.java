package gr.hd.onlinestore.shop;

import gr.hd.onlinestore.shop.AddOnsCode;
import gr.hd.onlinestore.shop.BroadbandProducts;

import org.junit.Assert;
import org.junit.Test;


public class BroadbandProductsTest {
    
    @Test
    public void testConnectProduct(){
        Assert.assertTrue(BroadbandProducts.CONNECT.addOns().isEmpty());
    }
    
    @Test
    public void testLiteProduct(){
        Assert.assertTrue(BroadbandProducts.LITE.addOns().contains(AddOnsCode.BB_EXTRA_CAPACITY_ADD_ON));
        Assert.assertTrue(BroadbandProducts.LITE.addOns().contains(AddOnsCode.BB_FIXED_SINGLE_IP_ADDRESS));
    }
    
    @Test
    public void testUnlimitedProduct(){
        Assert.assertTrue(BroadbandProducts.UNLIMITED.addOns().contains(AddOnsCode.BB_FIXED_SINGLE_IP_ADDRESS));
        Assert.assertTrue(BroadbandProducts.UNLIMITED.addOns().contains(AddOnsCode.BB_FIXED_MULTIPLE_IP_ADDRESS));
    }
}
