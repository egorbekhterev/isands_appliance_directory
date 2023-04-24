package ru.isands.appliance.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author: Egor Bekhterev
 * @date: 21.04.2023
 * @project: isands_appliance_directory
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Appliance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;

    private String country;

    private String manufacturer;

    private boolean online;

    private boolean instalment;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "appliance")
    private List<Model> models = new ArrayList<>();

    @NonNull
    public Appliance setModels(Collection<Model> models) {
        models.forEach(model -> model.setAppliance(this));
        this.models.clear();
        this.models.addAll(models);
        return this;
    }
}
