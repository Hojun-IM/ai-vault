package lab.connor.aivault.domain.assetversion;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lab.connor.aivault.domain.model.AbstractEntity;
import lab.connor.aivault.domain.asset.Asset;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(
    name = "asset_versions",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_asset_version_asset_id_version", columnNames = {"asset_id", "version"})
    }
)
public class AssetVersion extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

    @Column(name = "version", nullable = false, length = 60)
    private String version;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    private VersionStatus status;

    @Column(name = "release_title", length = 150)
    private String releaseTitle;

    @Column(name = "release_notes", columnDefinition = "TEXT")
    private String releaseNotes;

    @Column(name = "install_command", length = 1000)
    private String installCommand;

    @Column(name = "manual_installation_steps", columnDefinition = "TEXT")
    private String manualInstallationSteps;

    @Column(name = "package_name", length = 255)
    private String packageName;

    @Enumerated(EnumType.STRING)
    @Column(name = "package_format", length = 30)
    private PackageFormat packageFormat;

    @Column(name = "download_url", length = 1000)
    private String downloadUrl;

    @Column(name = "package_checksum", length = 255)
    private String packageChecksum;

    @Column(name = "package_size_bytes")
    private Long packageSizeBytes;

    @ElementCollection
    @CollectionTable(name = "asset_version_file_tree", joinColumns = @JoinColumn(name = "asset_version_id"))
    private List<FileTreeNode> fileTree = new ArrayList<>();
}
