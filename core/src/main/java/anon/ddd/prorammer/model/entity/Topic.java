package anon.ddd.prorammer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.OffsetDateTime;

/**
 * Сущность топика.
 */
@Data
@Entity
@Table(schema = "prog_anon", name = "topics")
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nameTopic", nullable = false)
    private String nameTopic;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "createDttm", nullable = false)
    private OffsetDateTime createDttm = OffsetDateTime.now();

    @Column(name = "endDttm")
    private OffsetDateTime endDttm;

    @JoinColumn(name = "theme_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Theme theme;
}
