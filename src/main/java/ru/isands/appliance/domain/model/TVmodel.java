package ru.isands.appliance.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author: Egor Bekhterev
 * @date: 21.04.2023
 * @project: isands_appliance_directory
 */
@Data
@Entity
@Table(name = "tv_model")
public class TVmodel extends Model {

    private String category;

    private String technology;
}
