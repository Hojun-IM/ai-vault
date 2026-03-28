package lab.connor.aivault.domain.statistics;

import java.util.UUID;

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
@Table(name = "asset_metrics")
public class AssetMetrics extends AbstractEntity {

    @Column(name = "asset_id", nullable = false, unique = true)
    private UUID assetId;

    @Column(name = "view_count", nullable = false)
    private Long viewCount = 0L;

    @Column(name = "download_count", nullable = false)
    private Long downloadCount = 0L;

    @Column(name = "comment_count", nullable = false)
    private Long commentCount = 0L;

    @Column(name = "rating_count", nullable = false)
    private Long ratingCount = 0L;

    @Column(name = "average_rating")
    private Double averageRating;
}
