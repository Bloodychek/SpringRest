package org.example.springrest.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.springrest.entity.Subscription;
import org.example.springrest.repository.SubscriptionRepo;
import org.example.springrest.service.SubscriptionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepo subscriptionRepo;

    @Override
    public List<Subscription> findAll() {
        return subscriptionRepo.findAll();
    }

    @Override
    public Subscription add(Subscription subscription) {
        return this.subscriptionRepo.saveAndFlush(subscription);
    }

    @Override
    public Subscription update(Subscription newSubscription, int id) {
        return subscriptionRepo.findById(id).map(subscription -> {
                    subscription.setIssueDate(newSubscription.getIssueDate());
                    subscription.setReturnDate(newSubscription.getReturnDate());
                    subscription.setReader(newSubscription.getReader());
                    subscription.setBook(newSubscription.getBook());
                    return subscriptionRepo.saveAndFlush(subscription);
                })
                .orElseGet(() -> subscriptionRepo.saveAndFlush(newSubscription));
    }

    @Override
    public void delete(int id) {
        this.subscriptionRepo.deleteById(id);
    }
}
