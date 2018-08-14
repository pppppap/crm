package cn.gezhi.crm.org.entity;

/**
 * TODO
 *
 * @author pppppap
 */
public class Development {
    private Integer id;
    private String name;

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
        this.name = name;
    }

    @Override
    public String toString() {
        return "Development{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
