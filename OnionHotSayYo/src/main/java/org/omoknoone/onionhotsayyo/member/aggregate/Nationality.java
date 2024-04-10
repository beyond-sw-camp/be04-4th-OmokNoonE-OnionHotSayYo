package org.omoknoone.onionhotsayyo.member.aggregate;

import jakarta.persistence.*;

@Entity
@Table(name = "nationality")
public class Nationality {

    @Id
    @Column(name = "nationality_id")
    private String nationalityId;

    @Column(name = "language")
    private String language;

    public Nationality() {
    }

    public Nationality(String nationalityId, String language) {
        this.nationalityId = nationalityId;
        this.language = language;
    }

    public String getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(String nationalityId) {
        this.nationalityId = nationalityId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Nationality{" +
                "nationalityId='" + nationalityId + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
