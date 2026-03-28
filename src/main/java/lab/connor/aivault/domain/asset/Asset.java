package lab.connor.aivault.domain.asset;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import lab.connor.aivault.domain.model.AbstractEntity;
import lab.connor.aivault.domain.classification.Category;
import lab.connor.aivault.domain.classification.LlmProfile;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "assets")
public class Asset extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "asset_type", nullable = false, length = 20)
    private AssetType assetType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    private AssetStatus status;

    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Column(name = "slug", nullable = false, unique = true, length = 140)
    private String slug;

    @Column(name = "short_description", nullable = false, length = 300)
    private String shortDescription;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "owner_display_name", length = 120)
    private String ownerDisplayName;

    @Column(name = "latest_published_version_id")
    private UUID latestPublishedVersionId;

    @Column(name = "latest_submission_id")
    private UUID latestSubmissionId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "asset_categories",
        joinColumns = @JoinColumn(name = "asset_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new LinkedHashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "asset_llm_profiles",
        joinColumns = @JoinColumn(name = "asset_id"),
        inverseJoinColumns = @JoinColumn(name = "llm_profile_id")
    )
    private Set<LlmProfile> llmProfiles = new LinkedHashSet<>();
}
