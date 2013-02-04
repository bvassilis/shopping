package gr.hd.onlinestore;

import gr.hd.onlinestore.shop.AddOnsCode;
import gr.hd.onlinestore.shop.BroadbandProducts;
import gr.hd.onlinestore.shop.Product;

import java.util.List;

import com.google.common.collect.Lists;

public class Basket {
    
    public static final String invalidPostCode = "Invalid PostCode ";

    private List<Product> availableProducts = Lists.newArrayList();
    private boolean validPostCode = true;
    
    public List<Product> getAvailableProducts() {
        return availableProducts;
    }

    public void addAvailableProducts(List<BroadbandProducts> availableProducts) {
        this.availableProducts.addAll(availableProducts);
    }

    public boolean hasValidPostCode() {
        return validPostCode;
    }

    public void setValidPostCode(boolean valid) {
        this.validPostCode = valid;
    }
    
    public String printAvailableAddOns() {
        StringBuilder sb = new StringBuilder();
        sb.append("Available Add Ons \n");
        for (Product product : availableProducts) {
            sb.append(product.name() + "{ ");
            for (AddOnsCode addOnsCode : product.addOns()) {
                sb.append(addOnsCode.name() + ", ");
            }
            sb.append("}\n");
        }
        return sb.toString();
    }

}
