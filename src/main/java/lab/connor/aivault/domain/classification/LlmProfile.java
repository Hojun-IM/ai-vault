package lab.connor.aivault.domain.classification;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lab.connor.aivault.domain.model.AbstractEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "llm_profiles")
public class LlmProfile extends AbstractEntity {

    @Column(name = "name", nullable = false, unique = true, length = 120)
    private String name;

    @Column(name = "vendor", length = 120)
    private String vendor;

    @Column(name = "slug", nullable = false, unique = true, length = 140)
    private String slug;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "active", nullable = false)
    private boolean active = true;
}
