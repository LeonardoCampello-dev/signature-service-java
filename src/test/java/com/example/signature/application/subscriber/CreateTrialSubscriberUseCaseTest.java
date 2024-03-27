package com.example.signature.application.subscriber;

import com.example.signature.domain.subscriber.entity.Subscriber;
import com.example.signature.domain.subscriber.repository.SubscriberRepository;
import com.example.signature.infra.rest.subscriber.CreateTrialSubscriberDTO;
import com.example.signature.infra.rest.subscriber.SubscriberAddressDTO;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class CreateTrialSubscriberUseCaseTest {
  @Test
  @DisplayName("Deve criar um subscriber")
  public void testCreate() {
    Faker faker = new Faker();

    CreateTrialSubscriberDTO dto = new CreateTrialSubscriberDTO(
        faker.name().fullName(),
        faker.internet().emailAddress(),
        new SubscriberAddressDTO(
            faker.address().streetAddress(),
            faker.address().buildingNumber(),
            faker.address().secondaryAddress(),
            faker.address().city(),
            faker.address().state(),
            faker.number().digits(5) + "-" + faker.number().digits(5),
            null
        ),
        null
    );

    SubscriberRepository subscriberRepositoryMock = mock(SubscriberRepository.class);

    CreateTrialSubscriberUseCase useCase = new CreateTrialSubscriberUseCase(subscriberRepositoryMock);

    useCase.execute(dto);

    ArgumentCaptor<Subscriber> captor = ArgumentCaptor.forClass(Subscriber.class);

    Mockito.verify(subscriberRepositoryMock).save(captor.capture());

    Subscriber subscriber = captor.getValue();

    assertEquals(
        dto.name(),
        subscriber.getName()
    );

    assertEquals(
        dto.email(),
        subscriber.getEmail()
    );

    assertTrue(subscriber.getContract().isTrial());

    // TODO testar data de expiração do contrato

    assertEquals(
        dto.address().street(),
        subscriber.getAddress().getStreet()
    );
    assertEquals(
        dto.address().number(),
        subscriber.getAddress().getNumber()
    );

    assertEquals(
        dto.address().neighborhood(),
        subscriber.getAddress().getNeighborhood()
    );

    assertEquals(
        dto.address().city(),
        subscriber.getAddress().getCity()
    );

    assertEquals(
        dto.address().state(),
        subscriber.getAddress().getState()
    );

    assertEquals(
        dto.address().zipCode(),
        subscriber.getAddress().getZipCode()
    );
  }
}
