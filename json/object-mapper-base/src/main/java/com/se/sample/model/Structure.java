package com.se.sample.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties({"parent"})
public class Structure implements Serializable {


    /** The anchor. */
    private String anchor;

    /** The value. */
    private String value;

    /** The parent. */
    @JsonIgnore
    private Structure parent;

    /** The child. */
    private List<Structure> child;

    /**
     * Instantiates a new structure.
     *
     * @param anchor the anchor
     * @param value the value
     * @param parent
     */
    public Structure(String anchor, String value, Structure parent) {

        this.anchor = anchor;
        this.value = value;
        this.child = new ArrayList<Structure>();
        this.parent = parent;
    }



    /**
     * set Child
     * @param child
     */
    public void setChild(List<Structure> child) {
        this.child = child;
    }



    /**
     * Instantiates a new structure.
     */
    public Structure() {
    }



    /**
     * Gets the anchor.
     *
     * @return the anchor
     */
    public String getAnchor() {
        return anchor;
    }

    /**
     * Sets the anchor.
     *
     * @param anchor the new anchor
     */
    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value.
     *
     * @param value the new value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the child.
     *
     * @return the child
     */
    public List<Structure> getChild() {
        return child;
    }


    /**
     * Sets the parent.
     *
     * @param parent the new parent
     */
    public void setParent(Structure parent) {
        this.parent = parent;
    }

    /**
     * Gets the parent.
     *
     * @return the parent
     */
    public Structure getParent() {
        return parent;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Structure [anchor=" + anchor + ", value=" + value + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((anchor == null) ? 0 : anchor.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Structure other = (Structure) obj;
        if (anchor == null) {
            if (other.anchor != null)
                return false;
        } else if (!anchor.equals(other.anchor))
            return false;
        return true;
    }
}