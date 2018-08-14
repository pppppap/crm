package cn.gezhi.crm.org.entity;

public class Department {
    private Integer id;

    private String depName;

    private String depDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName == null ? null : depName.trim();
    }

    public String getDepDesc() {
        return depDesc;
    }

    public void setDepDesc(String depDesc) {
        this.depDesc = depDesc == null ? null : depDesc.trim();
    }

    @Override
    public String toString() {
        return "DepartmentService{" +
                "id=" + id +
                ", depName='" + depName + '\'' +
                ", depDesc='" + depDesc + '\'' +
                '}';
    }
}