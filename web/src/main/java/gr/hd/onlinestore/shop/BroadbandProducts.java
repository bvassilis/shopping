package gr.hd.onlinestore.shop;

import java.util.List;

import com.google.common.collect.Lists;

public enum BroadbandProducts implements Product {

    CONNECT {
        @Override
        public List<AddOnsCode> addOns() {
            return Lists.newArrayList();
        }
    },
    LITE {
        @Override
        public List<AddOnsCode> addOns() {
            return Lists.newArrayList(AddOnsCode.BB_EXTRA_CAPACITY_ADD_ON, AddOnsCode.BB_FIXED_SINGLE_IP_ADDRESS);
        }
    },
    UNLIMITED {
        @Override
        public List<AddOnsCode> addOns() {
            return Lists.newArrayList(AddOnsCode.BB_FIXED_SINGLE_IP_ADDRESS, AddOnsCode.BB_FIXED_MULTIPLE_IP_ADDRESS);
        }
    }

}
