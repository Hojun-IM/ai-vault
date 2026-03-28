package lab.connor.aivault.domain.review;

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
import lab.connor.aivault.domain.submission.Submission;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "review_records")
public class ReviewRecord extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "submission_id", nullable = false)
    private Submission submission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewer_id")
    private AdminUser reviewer;

    @Enumerated(EnumType.STRING)
    @Column(name = "decision", nullable = false, length = 30)
    private ReviewDecision decision;

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;
}
