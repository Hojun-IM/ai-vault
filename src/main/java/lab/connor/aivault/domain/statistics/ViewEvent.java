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
@Table(name = "view_events")
public class ViewEvent extends AbstractEntity {

    @Column(name = "asset_id", nullable = false)
    private UUID assetId;

    @Column(name = "asset_version_id")
    private UUID assetVersionId;

    @Column(name = "viewer_token", length = 255)
    private String viewerToken;

    @Column(name = "viewer_ip", length = 64)
    private String viewerIp;

    @Column(name = "user_agent", length = 500)
    private String userAgent;
}
