package com.deshmukh.swiggyassignment.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by
 *
 * @author Amol Deshmukh
 * @since 16/04/19
 */
public class ExcludeList {

    @SerializedName("group_id")
    private String groupId;

    @SerializedName("variation_id")
    private String variationId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getVariationId() {
        return variationId;
    }

    public void setVariationId(String variationId) {
        this.variationId = variationId;
    }
}
