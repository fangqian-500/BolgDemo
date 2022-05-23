import javafx.scene.DepthTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class Recurson {

    List<Department> list = new ArrayList<>();

    @Test
    public void findParentDept(){
        //查找所有的部门
        List<Department> allDeptList = findAllDeptList();
        //递归查找父类部门
        List<Department> parentDepartment = Recurse(allDeptList, "0");
        System.out.println(parentDepartment.toString());
    }

    public List<Department> Recurse(List<Department> list,String integer){
        List<Department> list2 = new ArrayList<>();
       //获取符合传入条件的入口函数
        if (findRightDept(list,integer)!=null) {
            Department dept = findRightDept(list, integer);
            list2.add(dept);
            Recurse(list, String.valueOf(dept.getId()));
        }

        return list2;
    }

    private Department findRightDept(List<Department> list, String integer) {

        for (Department department : list) {
            if (integer.equals(department.getParentId())){
                return department;
            }
        }
        return null;
    }

    public List<Department> findAllDeptList(){
        Department dept1 = new Department(1, "研发部", "0");
        Department dept2 = new Department(2, "研发总监", "1");
        Department dept3 = new Department(3, "董事长", "2");
        list.add(dept1);
        list.add(dept2);
        list.add(dept3);
        return list;
    }

}
