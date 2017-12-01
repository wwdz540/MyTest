import javax.xml.crypto.Data;
import java.util.List;

public class TestBeen {
    private int id;

    private Float ff;

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        System.out.println("integer ====");
        this.integer = integer;
    }

    private Integer integer;

    public Float getFf() {
        System.out.println("get   fff");
        return ff;
    }

    public void setFf(Float ff) {
        System.out.println("set ff");
        this.ff = ff;
    }

    private String name;
    private Data data;
    private List list;

    public int getId() {
        System.out.println("getId");
        return id;
    }

    public void setId(int id) {
        System.out.println("set Id");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
