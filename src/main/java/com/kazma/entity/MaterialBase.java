package com.kazma.entity;

public class MaterialBase {
    private Integer materialBaseId;//材料基础ID
    private String materialName;//材料名称
    private Integer materialType;//材料类别
    private String requirement;//采购要求
    private String inspectionRequirement;//检验要求
    private String inspectionRules;//检测规则
    private String remark;//备注

    public Integer getMaterialBaseId() {
        return materialBaseId;
    }

    public void setMaterialBaseId(Integer materialBaseId) {
        this.materialBaseId = materialBaseId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public Integer getMaterialType() {
        return materialType;
    }

    public void setMaterialType(Integer materialType) {
        this.materialType = materialType;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getInspectionRequirement() {
        return inspectionRequirement;
    }

    public void setInspectionRequirement(String inspectionRequirement) {
        this.inspectionRequirement = inspectionRequirement;
    }

    public String getInspectionRules() {
        return inspectionRules;
    }

    public void setInspectionRules(String inspectionRules) {
        this.inspectionRules = inspectionRules;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
