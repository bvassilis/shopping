package com.acme.serviceavailability;

import org.apache.log4j.Logger;

/**
 * @author vassilis
 *
 */
public class MyAvailabilityChecker implements AvailabilityChecker {
    
    private static final Logger log = Logger.getLogger(MyAvailabilityChecker.class);

    @Override
    public String isPostCodeInServicableArea(String postCode) throws TechnicalFailureException {
        String service = MyAvailabilityChecker.getServiceCode(postCode);
        log.info("PostCode:" + postCode + ", ServiceCode: " + service);
        return service;
    }
    
    
    /**
     * @param postCode
     * @return PostCodeService enum as String
     * @throws TechnicalFailureException if no PostCodeService found    
     */
    private static String getServiceCode(String postCode) throws TechnicalFailureException {
        for (PostCodeService postCodeService : PostCodeService.values()) {
            if (postCodeService.isPostCodeMatches(postCode)) {
                return postCodeService.getService().name();
            }
        }
        throw new TechnicalFailureException();
    }
    
    
    /**
     *  PostCodeService 
     *  Bind PostCode with ServiceCode
     */
    private enum PostCodeService {
        AVAILABLE("1", ServiceCode.SERVICE_AVAILABLE), UNAVAILABLE("2", ServiceCode.SERVICE_UNAVAILABLE), PLANNED("3", ServiceCode.SERVICE_PLANNED), INVALID("4", ServiceCode.POSTCODE_INVALID);

        private String prefix;
        private ServiceCode serviceCode;
        
        PostCodeService(String prefix, ServiceCode serviceCode) {
            this.prefix = prefix;
            this.serviceCode = serviceCode;
        }
        
        public ServiceCode getService(){
            return serviceCode;
        }
        
        public boolean isPostCodeMatches(String postCode){
            return postCode.startsWith(prefix);
        }
    }
    
}
