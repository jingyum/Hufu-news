package generator.domain;

import java.io.Serial;
import java.io.Serializable;

public class Interfaces implements Serializable {
    private Integer id;

    private String interf;

    private String settittle;

    private String settime;

    private String setsourceweb;

    private String setoriginalurl;

    private String setsummary;

    private String doc;

    @Serial
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInterf() {
        return interf;
    }

    public void setInterf(String interf) {
        this.interf = interf;
    }

    public String getSettittle() {
        return settittle;
    }

    public void setSettittle(String settittle) {
        this.settittle = settittle;
    }

    public String getSettime() {
        return settime;
    }

    public void setSettime(String settime) {
        this.settime = settime;
    }

    public String getSetsourceweb() {
        return setsourceweb;
    }

    public void setSetsourceweb(String setsourceweb) {
        this.setsourceweb = setsourceweb;
    }

    public String getSetoriginalurl() {
        return setoriginalurl;
    }

    public void setSetoriginalurl(String setoriginalurl) {
        this.setoriginalurl = setoriginalurl;
    }

    public String getSetsummary() {
        return setsummary;
    }

    public void setSetsummary(String setsummary) {
        this.setsummary = setsummary;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Interfaces other = (Interfaces) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInterf() == null ? other.getInterf() == null : this.getInterf().equals(other.getInterf()))
            && (this.getSettittle() == null ? other.getSettittle() == null : this.getSettittle().equals(other.getSettittle()))
            && (this.getSettime() == null ? other.getSettime() == null : this.getSettime().equals(other.getSettime()))
            && (this.getSetsourceweb() == null ? other.getSetsourceweb() == null : this.getSetsourceweb().equals(other.getSetsourceweb()))
            && (this.getSetoriginalurl() == null ? other.getSetoriginalurl() == null : this.getSetoriginalurl().equals(other.getSetoriginalurl()))
            && (this.getSetsummary() == null ? other.getSetsummary() == null : this.getSetsummary().equals(other.getSetsummary()))
            && (this.getDoc() == null ? other.getDoc() == null : this.getDoc().equals(other.getDoc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInterf() == null) ? 0 : getInterf().hashCode());
        result = prime * result + ((getSettittle() == null) ? 0 : getSettittle().hashCode());
        result = prime * result + ((getSettime() == null) ? 0 : getSettime().hashCode());
        result = prime * result + ((getSetsourceweb() == null) ? 0 : getSetsourceweb().hashCode());
        result = prime * result + ((getSetoriginalurl() == null) ? 0 : getSetoriginalurl().hashCode());
        result = prime * result + ((getSetsummary() == null) ? 0 : getSetsummary().hashCode());
        result = prime * result + ((getDoc() == null) ? 0 : getDoc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", interf=").append(interf);
        sb.append(", settittle=").append(settittle);
        sb.append(", settime=").append(settime);
        sb.append(", setsourceweb=").append(setsourceweb);
        sb.append(", setoriginalurl=").append(setoriginalurl);
        sb.append(", setsummary=").append(setsummary);
        sb.append(", doc=").append(doc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}