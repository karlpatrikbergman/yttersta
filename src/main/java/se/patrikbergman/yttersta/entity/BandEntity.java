package se.patrikbergman.yttersta.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name="Band.findAllBands", query="SELECT b FROM BandEntity b"),
        @NamedQuery(name="Band.findAllBandsByBandName", query="SELECT b FROM BandEntity b WHERE b.name = :bandName")
})
@Table(name = "band", schema = "public", catalog = "yttersta")
public class BandEntity {
    @Id
    @SequenceGenerator(name = "band_id_seq", sequenceName = "band_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "band_id_seq")
    @Column(name = "id", updatable = false)
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(
            name="band_member",
            joinColumns={@JoinColumn(name="band_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="musician_id", referencedColumnName="ID")})
    private List<MusicianEntity> members;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MusicianEntity> getMembers() {
        return members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BandEntity that = (BandEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BandEntity{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
