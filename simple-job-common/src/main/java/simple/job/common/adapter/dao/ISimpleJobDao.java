package simple.job.common.adapter.dao;

import org.springframework.stereotype.Component;
import simple.job.api.pojo.SimpleJobInfo;

import java.util.List;

/**
 * description: add a description
 * @author 方浩
 * @version 1.0.0
 * @date 2023/06/05 14:38:29
 */
@Component
public interface ISimpleJobDao {
    int save(SimpleJobInfo simpleJobInfo);

    int update(SimpleJobInfo simpleJobInfo);

    List<SimpleJobInfo> list();

    SimpleJobInfo getById(String id);

}
