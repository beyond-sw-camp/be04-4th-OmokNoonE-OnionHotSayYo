package org.omoknoone.onionhotsayyo.post.command.aggregate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @Column(name = "location_id")
    private Integer locationId;     // 지역번호

    @Column(name = "location")
    private String location;        // 시도명

    public Location() {
    }

    public Location(Integer locationId, String location) {
        this.locationId = locationId;
        this.location = location;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", location='" + location + '\'' +
                '}';
    }
}
