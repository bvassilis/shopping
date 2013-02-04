package gr.hd.onlinestore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author vassilis
 *
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    
    @Autowired 
    private BroadbandAddOnService broadbandAddOnService;
    
    /**
     * Creates a new Basket and inserts new available products 
     * @param postcode
     * @return invalid postcode message and basket available products
     */
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String showBasket(@RequestParam(value = "postcode", required = true) String postcode) {
        Basket basket = new Basket();
        broadbandAddOnService.checkForAddOnProducts(basket, postcode);
        String respond = "";
        if(!basket.hasValidPostCode()){
            respond = Basket.invalidPostCode;
        }
        return respond += basket.printAvailableAddOns();
    }
}
