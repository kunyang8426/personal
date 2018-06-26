package com.kazma.entity;

/**
 * Created by 80002526 on 2018/6/26.
 */
public class Material {
    private Integer materialId;
    private String materialName;
    private String specifications;
    private Integer buyNum;
    private Integer totalNum;
    private String regNo;
    private String batchNo;
    private Integer validity;
    private String supplierName;
    private Integer buyTime;
    private String purchaser;
    private Integer acceptTime;
    private String acceptor;
    private String optionMaterialName;
    private Integer createTime;
    private Integer operatorId;

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Integer getValidity() {
        return validity;
    }

    public void setValidity(Integer validity) {
        this.validity = validity;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Integer buyTime) {
        this.buyTime = buyTime;
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }

    public Integer getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Integer acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(String acceptor) {
        this.acceptor = acceptor;
    }

    public String getOptionMaterialName() {
        return optionMaterialName;
    }

    public void setOptionMaterialName(String optionMaterialName) {
        this.optionMaterialName = optionMaterialName;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
}
