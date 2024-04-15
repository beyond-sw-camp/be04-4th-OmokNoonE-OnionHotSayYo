package org.omoknoone.nationality.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
@EqualsAndHashCode
public class NationalityDTO {

    private String nationalityId;
    private String language;
    private String country;
}
