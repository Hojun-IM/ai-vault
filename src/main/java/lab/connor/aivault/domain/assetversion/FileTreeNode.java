package lab.connor.aivault.domain.assetversion;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.Getter;

@Getter
@Embeddable
public class FileTreeNode {

    @Column(name = "node_path", nullable = false, length = 500)
    private String path;

    @Column(name = "node_type", nullable = false, length = 20)
    private String nodeType;

    @Column(name = "node_depth")
    private Integer depth;

    @Column(name = "file_size_bytes")
    private Long fileSizeBytes;
}
