package com.godel.GraphQLdemo.DTO;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private Long id;
    private String name;
    private String email;
    private List<BillDTO> bills;

}
