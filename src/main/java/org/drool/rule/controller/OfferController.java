package org.drool.rule.controller;

import org.drool.rule.model.Product;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class OfferController {

    @Autowired
    private KieSession session;

    @PostMapping (produces = "application/json", consumes = "application/json", path="/offer")
    public Product orderProduct(@RequestBody Product product){
        session.insert(product);
        session.fireAllRules();
        return product;
    }
}
