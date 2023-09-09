package anon.ddd.prorammer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Сущность файла (Изображение, статья, видео)
 */
@Data
@Entity
@Table(schema = "prog_anon", name = "file_storage")
@NoArgsConstructor
@AllArgsConstructor
public class FileStorage {
    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_storage_id")
    private Category category;
}
