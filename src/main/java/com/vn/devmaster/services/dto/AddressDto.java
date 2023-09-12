package com.vn.devmaster.services.dto;

import lombok.*;



/**
 * DTO for {@link com.vn.devmaster.services.domain.Address}
 */
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Data
@Builder
@Value
public class AddressDto{
    String name;
    String city;
    String district;
}