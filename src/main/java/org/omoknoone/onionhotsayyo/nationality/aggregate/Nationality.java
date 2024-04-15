package org.omoknoone.onionhotsayyo.nationality.aggregate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "nationality")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
@EqualsAndHashCode
public class Nationality {

    @Id
    @Column(name = "nationality_id")
    private String nationalityId;

    @Column(name = "language")
    private String language;

    @Column(name = "country")
    private String country;
}
