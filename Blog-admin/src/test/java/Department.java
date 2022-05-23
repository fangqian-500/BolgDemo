import lombok.Data;

@Data
public class Department {
    private int id;

    private String name;

    private String parentId;

    public Department(int id,String name,String parentId){
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

}
