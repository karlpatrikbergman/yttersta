package se.patrikbergman.yttersta.entity;

import javax.persistence.*;

/**
 * Created by patrikbergman on 2014-03-03.
 */
@Entity
@Table(name = "band_member", schema = "public", catalog = "yttersta")
public class BandMemberEntity {
    private int id;
    private int bandId;
    private int musicianId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "band_id")
    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }

    @Basic
    @Column(name = "musician_id")
    public int getMusicianId() {
        return musicianId;
    }

    public void setMusicianId(int musicianId) {
        this.musicianId = musicianId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BandMemberEntity that = (BandMemberEntity) o;

        if (bandId != that.bandId) return false;
        if (id != that.id) return false;
        if (musicianId != that.musicianId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + bandId;
        result = 31 * result + musicianId;
        return result;
    }
}
