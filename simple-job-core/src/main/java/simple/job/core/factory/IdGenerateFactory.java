package simple.job.core.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import simple.job.api.enums.IdGenerateTypeEnum;
import simple.job.common.idgeneate.IIdGenerate;
import simple.job.common.idgeneate.SnowFlakeIdGenerate;
import simple.job.common.utils.ObjectUtils;
import simple.job.core.config.SimpleJobConfig;

/**
 * description: add a description
 * @author 方浩
 * @version 1.0.0
 * @date 2023/06/04 16:18:55
 */
@Component
@RequiredArgsConstructor
public class IdGenerateFactory {
    private final SimpleJobConfig simpleJobConfig;

    public IIdGenerate creatIdGenerate() {
        IdGenerateTypeEnum idGenerateTypeEnum = IdGenerateTypeEnum.valueOf(simpleJobConfig.getIdGenerateType());
        if (ObjectUtils.isEmpty(idGenerateTypeEnum)){
            throw new RuntimeException("unknown id generate type");
        }
        switch (idGenerateTypeEnum){
            case SNOW_FLAKE:
                return new SnowFlakeIdGenerate();
            case CUSTOMER:
                try {
                    Class<?> idGenerateClass = Class.forName(simpleJobConfig.getIdGenerateClass());
                    return (IIdGenerate) idGenerateClass.newInstance();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            default:
                throw new RuntimeException("unknown id generate type");
        }
    }
}
