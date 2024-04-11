package org.omoknoone.onionhotsayyo.post.aggregate;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity
@Table(name = "language")
public class Language {

    @Id
    @Column(name = "language")
    private String language;
}
