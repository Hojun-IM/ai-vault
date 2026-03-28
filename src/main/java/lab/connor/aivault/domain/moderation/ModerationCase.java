package lab.connor.aivault.domain.moderation;

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
import lab.connor.aivault.domain.admin.AdminUser;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "moderation_cases")
public class ModerationCase extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "target_type", nullable = false, length = 30)
    private ModerationTargetType targetType;

    @Column(name = "target_id", nullable = false)
    private UUID targetId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private ModerationStatus status;

    @Column(name = "report_reason", nullable = false, columnDefinition = "TEXT")
    private String reportReason;

    @Column(name = "resolution_note", columnDefinition = "TEXT")
    private String resolutionNote;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignee_id")
    private AdminUser assignee;
}
