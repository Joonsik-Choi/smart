package com.gwnu.smart.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Medicine {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String imageURL;
    @NotEmpty
    private String name;
    @NotEmpty
    private String shape;
    @NotEmpty
    private String company;
    @NotEmpty
    private String color;
    @NotEmpty
    private String formula;
    @NotEmpty
    private String line;
    @NotEmpty
    private String sortation;
}
