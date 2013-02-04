package gr.hd.onlinestore.shop;

import java.util.List;

public interface Product {
    
    List<AddOnsCode> addOns();
    String name();

}
