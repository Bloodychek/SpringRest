package org.example.springrest.controllers;

import lombok.RequiredArgsConstructor;
import org.example.springrest.entity.Subscription;
import org.example.springrest.service.SubscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscription/")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @GetMapping
    public List<Subscription> findAll() {
        return subscriptionService.findAll();
    }

    @PostMapping
    public Subscription add(@RequestBody Subscription newSubscription) {
        return subscriptionService.add(newSubscription);
    }

    @PutMapping("{id}")
    public Subscription update(@RequestBody Subscription newSubscription, @PathVariable int id) {
        return subscriptionService.update(newSubscription, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        subscriptionService.delete(id);
    }
}
