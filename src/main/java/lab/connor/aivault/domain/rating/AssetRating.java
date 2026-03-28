package lab.connor.aivault.domain.rating;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lab.connor.aivault.domain.model.AbstractEntity;
import lab.connor.aivault.domain.asset.Asset;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "asset_ratings")
public class AssetRating extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

    @Column(name = "asset_version_id")
    private UUID assetVersionId;

    @Column(name = "rater_token", nullable = false, length = 255)
    private String raterToken;

    @Column(name = "score", nullable = false, columnDefinition = "integer check (score between 1 and 5)")
    private Integer score;

    @Column(name = "review_text", columnDefinition = "TEXT")
    private String reviewText;
}
