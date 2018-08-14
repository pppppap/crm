package cn.gezhi.crm.org.entity;

/**
 * TODO
 *
 * @author pppppap
 */
public class Employee {
    private Integer id;
    private Career career;
    private Development development;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Career getCareer() {
        return career;
    }

    public void setCareer(Career career) {
        this.career = career;
    }

    public Development getDevelopment() {
        return development;
    }

    public void setDevelopment(Development development) {
        this.development = development;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", career=" + career +
                ", development=" + development +
                ", name='" + name + '\'' +
                '}';
    }
}
