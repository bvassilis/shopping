package gr.hd.onlinestore;

import gr.hd.onlinestore.shop.BroadbandProducts;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.acme.serviceavailability.AvailabilityChecker;
import com.acme.serviceavailability.ServiceCode;
import com.acme.serviceavailability.TechnicalFailureException;
import com.google.common.collect.Lists;

/**
 * @author vassilis
 *
 */
public class MyBroadbandAddOnService implements BroadbandAddOnService {
    
    private static final Logger log = Logger.getLogger(MyBroadbandAddOnService.class);
    
    @Autowired 
    private AvailabilityChecker availabilityChecker;

    /**
     * Using ThirdParty Service
     * if SERVICE_AVAILABLE then add all available products into Basket
     * if POSTCODE_INVALID set Baket.validPostCode to false
     * otherwise do nothing
     * @param basket
     * @param postCode
     */
    @Override
    public void checkForAddOnProducts(Basket basket, String postcode) {
        try{
            String service = availabilityChecker.isPostCodeInServicableArea(postcode);
            if(service.equals(ServiceCode.SERVICE_AVAILABLE.name())){
                basket.addAvailableProducts(Lists.newArrayList(BroadbandProducts.values()));
            } else if (service.equals(ServiceCode.POSTCODE_INVALID.name())){
                basket.setValidPostCode(false);
            }
        } catch (TechnicalFailureException tfe) {
            log.warn("Techinal Failure for Postcode "+ postcode , tfe);
        }
    }
    
}
