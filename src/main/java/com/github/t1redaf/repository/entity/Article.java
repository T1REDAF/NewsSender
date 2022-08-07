package com.github.t1redaf.repository.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "description")
    @NotNull
    String description;

    public Article(String description) {
        this.description = description;
    }

}
