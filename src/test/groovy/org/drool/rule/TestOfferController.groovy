package org.drool.rule

import groovy.json.JsonOutput
import org.drool.rule.model.Product
import org.kie.api.runtime.KieSession;
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import spock.lang.Specification;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TestOfferController extends Specification {

    @Autowired
    MockMvc mvc;


    def "When pass invoke order request then return status is ok [200]"(){
        given:
            Product product = new Product();
            product.setCardType("HDFC");
            product.setShoppingAmount(20000.00);
        product.setName("test");

        when:
        def results = mvc.perform(post("/offer")
                .contentType("application/json")
                .content(JsonOutput.toJson(product)));

        then:
        results.andExpect(status().isOk())

        and:
        results.andExpect(jsonPath('$.cashBackPercent').value(10.0))


    }
}
