package com.plexus.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.IdGeneratorType;

/**
 * Example JPA entity.
 *
 * To use it, get access to a JPA EntityManager via injection.
 *
 * {@code
 *     @Inject
 *     EntityManager em;
 *
 *     public void doSomething() {
 *         MyEntity entity1 = new MyEntity();
 *         entity1.field = "field-1";
 *         em.persist(entity1);
 *
 *         List<MyEntity> entities = em.createQuery("from MyEntity", MyEntity.class).getResultList();
 *     }
 * }
 */
@Entity
@Table(name = "country")
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    public String name;
}
