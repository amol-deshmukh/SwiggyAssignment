package com.deshmukh.swiggyassignment.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by
 *
 * @author Amol Deshmukh
 * @since 16/04/19
 */
public class VariantGroup {

    @SerializedName("group_id")
    private String groupId;

    @SerializedName("name")
    private String name;

    @SerializedName("variations")
    private List<Variation> variations = null;



    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Variation> getVariations() {
        return variations;
    }

    public void setVariations(List<Variation> variations) {
        this.variations = variations;
    }
}
