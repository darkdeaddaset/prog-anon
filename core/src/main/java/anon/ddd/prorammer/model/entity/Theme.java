package anon.ddd.prorammer.model.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.Iterator;
import java.util.List;

/**
 * Сущность темы.
 */
@Entity
@Table(schema = "prog_anon", name = "themes")
@NoArgsConstructor
@AllArgsConstructor
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "createDttm", nullable = false)
    private OffsetDateTime createDttm = OffsetDateTime.now();

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "theme")
    private List<Topic> topics;

    /**
     * Добавленгие топика.
     *
     * @param topic - топик.
     */
    public void addTopic(Topic topic) {
        if (topic != null) {
            this.topics.add(topic);
            topic.setTheme(this);
        }
    }

    /**
     * Удаление топика.
     *
     * @param topic - топик.
     */
    public void removeTopic(Topic topic) {
        if (topic != null) {
            this.topics.remove(topic);
            topic.setTheme(null);
        }
    }

    /**
     * Удаление всех топиков.
     */
    public void removeTopics() {
        Iterator<Topic> iterator = this.topics.iterator();

        while (iterator.hasNext()) {
            Topic topic = iterator.next();
            topic.setTheme(null);
            iterator.remove();
        }
    }
}
