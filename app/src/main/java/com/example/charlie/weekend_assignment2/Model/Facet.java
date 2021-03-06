package com.example.charlie.weekend_assignment2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlie on 12/06/2016.
 */

public class Facet {

    @SerializedName("FacetValues")
    @Expose
    private List<FacetValue> facetValues = new ArrayList<FacetValue>();
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Sequence")
    @Expose
    private Integer sequence;

    /**
     *
     * @return
     * The facetValues
     */
    public List<FacetValue> getFacetValues() {
        return facetValues;
    }

    /**
     *
     * @param facetValues
     * The FacetValues
     */
    public void setFacetValues(List<FacetValue> facetValues) {
        this.facetValues = facetValues;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The Id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The sequence
     */
    public Integer getSequence() {
        return sequence;
    }

    /**
     *
     * @param sequence
     * The Sequence
     */
    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

}