package org.example.springrest.repository;

import org.example.springrest.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepo extends JpaRepository<Subscription, Integer> {
}
