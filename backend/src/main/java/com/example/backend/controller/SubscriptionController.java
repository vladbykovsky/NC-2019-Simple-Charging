package com.example.backend.controller;

import com.example.backend.entity.Subscription;
import com.example.backend.service.ProductService;
import com.example.backend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

//    @RequestMapping(value = "/userId/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Subscription> getSubscriptionByUserId(@PathVariable(name = "id") Integer id){
//        Optional<Subscription> subscription = subscriptionService.findByUserId(id);
//        if (subscription.isPresent()){
//            return ResponseEntity.ok(subscription.get());
//        }else {
//            return  ResponseEntity.notFound().build();
//        }
//    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Subscription> getAll(){
        return subscriptionService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable(name = "id") Integer id){
        Optional<Subscription> subscription = subscriptionService.findById(id);
        if (subscription.isPresent()){
            return ResponseEntity.ok(subscription.get());
        }else {
            return  ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "userId/{id}", method = RequestMethod.GET)
    public List<Subscription> getSubscriptionsByUserId(@PathVariable(name = "id") Integer id) {
        return subscriptionService.getSubscriptionsByUserId(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Subscription saveSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.saveSubscription(subscription);
    }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
    public void deleteSubscription(@PathVariable(name = "id") Integer id) {
        subscriptionService.delete(id);
    }

}
