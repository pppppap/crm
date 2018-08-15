package cn.gezhi.crm.org.entity;

public class Career {
    private Integer id;

    private String careerName;

    private String careerDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCareerName() {
        return careerName;
    }

    public void setCareerName(String careerName) {
        this.careerName = careerName == null ? null : careerName.trim();
    }

    public String getCareerDesc() {
        return careerDesc;
    }

    public void setCareerDesc(String careerDesc) {
        this.careerDesc = careerDesc == null ? null : careerDesc.trim();
    }

    public Career() {
    }

    public Career(Integer id, String careerName, String careerDesc) {
        this.id = id;
        this.careerName = careerName;
        this.careerDesc = careerDesc;
    }

    @Override
    public String toString() {
        return "Career{" +
                "id=" + id +
                ", careerName='" + careerName + '\'' +
                ", careerDesc='" + careerDesc + '\'' +
                '}';
    }
}