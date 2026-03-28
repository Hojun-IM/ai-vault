package lab.connor.aivault.domain.submission;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import lab.connor.aivault.domain.model.AbstractEntity;
import lab.connor.aivault.domain.asset.AssetType;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "submissions")
public class Submission extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "submission_type", nullable = false, length = 40)
    private SubmissionType submissionType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    private SubmissionStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "requested_asset_type", nullable = false, length = 20)
    private AssetType requestedAssetType;

    @Column(name = "target_asset_id")
    private UUID targetAssetId;

    @Column(name = "proposed_name", nullable = false, length = 120)
    private String proposedName;

    @Column(name = "proposed_slug", length = 140)
    private String proposedSlug;

    @Column(name = "proposed_version", length = 60)
    private String proposedVersion;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "install_guide", columnDefinition = "TEXT")
    private String installGuide;

    @Column(name = "package_url", length = 1000)
    private String packageUrl;

    @Embedded
    private SubmitterSnapshot submitterSnapshot;
}
