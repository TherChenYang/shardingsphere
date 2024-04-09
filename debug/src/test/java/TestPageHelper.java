
import com.github.pagehelper.PageHelper;
import com.yang.demo.TestShardingApplication;
import com.yang.demo.domain.EquipmentOee;
import com.yang.demo.mapper.EquipmentOeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = {TestShardingApplication.class})
public class TestPageHelper {

    @Autowired
    private EquipmentOeeMapper equipmentOeeMapper;

    @Test
    public void test02() {
        PageHelper.startPage(2, 4, false).setOrderBy("equipment_id asc");
        List<EquipmentOee> equipmentOees = equipmentOeeMapper.queryList();
        System.out.println("数据库存在条数:" + equipmentOees.size());
    }

    @Test
    public void test03() {
        PageHelper.startPage(1,4, "equipment_id asc");
        List<EquipmentOee> equipmentOees = equipmentOeeMapper.queryList();
        System.out.println(equipmentOees.size());
    }

}
