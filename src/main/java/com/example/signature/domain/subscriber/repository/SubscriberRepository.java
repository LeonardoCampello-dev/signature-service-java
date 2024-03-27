package com.example.signature.domain.subscriber.repository;

import com.example.signature.domain.subscriber.entity.Subscriber;

public interface SubscriberRepository {
  Subscriber save(Subscriber subscriber);
}
