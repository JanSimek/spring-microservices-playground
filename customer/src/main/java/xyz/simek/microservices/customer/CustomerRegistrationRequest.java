package xyz.simek.microservices.customer;

public record CustomerRegistrationRequest(
    String firstName,
    String lastName,
    String email
    ) {
}