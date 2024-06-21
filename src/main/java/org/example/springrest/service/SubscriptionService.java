package org.example.springrest.service;

import org.example.springrest.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    List<Subscription> findAll();

    Subscription add(Subscription subscription);

    Subscription update(Subscription subscription, int id);

    void delete(int id);
}
