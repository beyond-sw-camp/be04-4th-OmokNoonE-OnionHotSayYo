package org.omoknoone.onionhotsayyo.post.command.aggregate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "location")
public class Location {

    @Id
    @Column(name = "location_id")
    private String locationId;     // 지역번호

    @Column(name = "location")
    private String location;        // 시도명

}
