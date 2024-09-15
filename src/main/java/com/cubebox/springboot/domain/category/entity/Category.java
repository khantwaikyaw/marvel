package com.cubebox.springboot.domain.category.entity;

import com.cubebox.springboot.core.model.AbstractAuditableModel;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;


@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Table(name = "categories")
public class Category extends AbstractAuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "category_uuid", nullable = false, unique = true)
    UUID id;
    String name;
    String description;
}
