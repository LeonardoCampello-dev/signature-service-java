package com.example.signature.infra.rest.subscriber;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record CreateTrialSubscriberDTO(
    @NotBlank String name,
    @Email String email,
    @NotEmpty SubscriberAddressDTO address,
    String partnerId
) {
}
