package anon.ddd.prorammer.model.entity;

import anon.ddd.prorammer.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

/**
 * Сущность категории.
 */
@Data
@Entity
@Table(schema = "prog_anon", name = "categories")
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "createDttm", nullable = false)
    private OffsetDateTime createDttm = OffsetDateTime.now();
}
