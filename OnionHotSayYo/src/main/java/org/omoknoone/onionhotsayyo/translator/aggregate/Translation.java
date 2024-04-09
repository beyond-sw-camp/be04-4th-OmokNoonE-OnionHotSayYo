package org.omoknoone.onionhotsayyo.translator.aggregate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "translation")
@Data
public class Translation {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int translationId;
    @Column
    private String content;
    @Column
    private String title;
    @Column
    private String language;
    @Column
    private int postingId;
}
