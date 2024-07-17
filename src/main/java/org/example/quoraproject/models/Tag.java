package org.example.quoraproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Tag extends BaseModel{
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Question> questions;

    @ManyToMany(mappedBy = "followedTags")
    private Set<User> followers;
}
