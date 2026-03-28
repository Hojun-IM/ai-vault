package lab.connor.aivault.domain.submission;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.Getter;

@Getter
@Embeddable
public class SubmitterSnapshot {

    @Column(name = "submitter_display_name", length = 120)
    private String displayName;

    @Column(name = "submitter_email", nullable = false, length = 255)
    private String email;

    @Column(name = "submitter_token", nullable = false, length = 255)
    private String submitterToken;

    @Column(name = "submitter_ip", length = 64)
    private String submitterIp;
}
