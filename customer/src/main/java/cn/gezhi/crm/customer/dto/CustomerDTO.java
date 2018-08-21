package cn.gezhi.crm.customer.dto;

import cn.gezhi.crm.org.entity.Employee;

import java.util.Date;

public class CustomerDTO {
    private Integer id;

    private String name;

    private String idcard;

    private String tel;

    private Long loan;

    private Integer bankId;

    private Long realloan;

    private String process;

    private Long common;

    private String note;

    private Employee salesmanId;

    private String attentionLevel;

    private Integer evaluteId;

    private String customerLevel;

    private Date date;

    private Integer houseId;

    private Integer carId;

    private String securityId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Long getLoan() {
        return loan;
    }

    public void setLoan(Long loan) {
        this.loan = loan;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public Long getRealloan() {
        return realloan;
    }

    public void setRealloan(Long realloan) {
        this.realloan = realloan;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process == null ? null : process.trim();
    }

    public Long getCommon() {
        return common;
    }

    public void setCommon(Long common) {
        this.common = common;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getAttentionLevel() {
        return attentionLevel;
    }

    public void setAttentionLevel(String attentionLevel) {
        this.attentionLevel = attentionLevel == null ? null : attentionLevel.trim();
    }

    public Integer getEvaluteId() {
        return evaluteId;
    }

    public void setEvaluteId(Integer evaluteId) {
        this.evaluteId = evaluteId;
    }

    public String getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(String customerLevel) {
        this.customerLevel = customerLevel == null ? null : customerLevel.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId == null ? null : securityId.trim();
    }
}