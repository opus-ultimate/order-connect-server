package com.opusultimate.orderconnect.entity;

import java.util.UUID;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "party_address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartyAddress {

    private static final GeometryFactory factory = new GeometryFactory(new PrecisionModel(), 4326);

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String address;

    @Column
    private String landmark;

    @Column
    private int pincode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "party_id", nullable = false)
    Party party;

    /**
     * Geo location (longitude, latitude)
     * Uses PostGIS geography type
     */
    @Column(columnDefinition = "geography(Point,4326)", nullable = false)
    private Point location;

    public static Point createPoint(double longitude, double latitude) {
        return factory.createPoint(new Coordinate(longitude, latitude));
    }
}
