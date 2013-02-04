package gr.hd.onlinestore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/dispatcher-config-test.xml"})
public class TestBase {

    protected static MockMvc mockMvc = MockMvcBuilders.xmlConfigSetup("classpath:dispatcher-config-test.xml").build();

    @Test
    public void empty() {
    }

}
