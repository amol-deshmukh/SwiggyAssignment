package com.deshmukh.swiggyassignment.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by
 *
 * @author Amol Deshmukh
 * @since 16/04/19
 */
public class Variants {

    @SerializedName("variant_groups")
    private List<VariantGroup> variantGroups;

    @SerializedName("exclude_list")
    private List<List<ExcludeList>> excludeList;

    public List<VariantGroup> getVariantGroups() {
        return variantGroups;
    }

    public void setVariantGroups(List<VariantGroup> variantGroups) {
        this.variantGroups = variantGroups;
    }

    public List<List<ExcludeList>> getExcludeList() {
        return excludeList;
    }

    public void setExcludeList(List<List<ExcludeList>> excludeList) {
        this.excludeList = excludeList;
    }
}
