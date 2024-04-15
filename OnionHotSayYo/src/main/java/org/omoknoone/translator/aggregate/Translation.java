package org.omoknoone.translator.aggregate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "translation")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString @EqualsAndHashCode
public class Translation {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int translationId;
    @Column
    private int postId;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String language;

    public Translation(int postId, String content, String language) {
        this.postId = postId;
        this.content = content;
        this.language = language;
    }
}
