package com.nttdata.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("customer")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private String id;
    private String customerType;
    private String documentType;
    private String documentNumber;
    private String name;
    private String legalRepresentative;
    private String email;
    private String phone;
    private String address;
}
