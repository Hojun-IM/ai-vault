package lab.connor.aivault.domain.comment;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "asset_comments")
public class AssetComment extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

    @Column(name = "asset_version_id")
    private UUID assetVersionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private CommentStatus status;

    @Column(name = "author_name", length = 120)
    private String authorName;

    @Column(name = "author_token", nullable = false, length = 255)
    private String authorToken;

    @Column(name = "body", nullable = false, columnDefinition = "TEXT")
    private String body;
}
