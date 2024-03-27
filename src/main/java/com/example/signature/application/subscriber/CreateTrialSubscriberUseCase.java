package com.example.signature.application.subscriber;

import com.example.signature.domain.shared.vo.Address;
import com.example.signature.domain.subscriber.entity.Contract;
import com.example.signature.domain.subscriber.entity.Subscriber;
import com.example.signature.domain.subscriber.repository.SubscriberRepository;
import com.example.signature.infra.rest.subscriber.CreateTrialSubscriberDTO;

import java.util.UUID;

public class CreateTrialSubscriberUseCase {
  private final SubscriberRepository subscriberRepository;

  public CreateTrialSubscriberUseCase(SubscriberRepository subscriberRepository) {
    this.subscriberRepository = subscriberRepository;
  }

  public void execute(CreateTrialSubscriberDTO dto) {
    Subscriber subscriber = new Subscriber(
        UUID.randomUUID(),
        dto.name(),
        dto.email(),
        new Address(
            dto.address().street(),
            dto.address().number(),
            dto.address().neighborhood(),
            dto.address().city(),
            dto.address().state(),
            dto.address().zipCode(),
            dto.address().complement()
        ),
        Contract.buildTrial()
    );

    if (dto.partnerId() != null) subscriber.linkPartner(dto.partnerId());

    this.subscriberRepository.save(subscriber);
  }
}
