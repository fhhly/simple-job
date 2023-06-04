package simple.job.core.factory;

import simple.job.api.enums.ScheduleTypeEnum;
import simple.job.common.utils.SpringContextUtils;
import simple.job.common.utils.StringUtils;
import simple.job.core.shecdule.ISimpleJobSchedule;

/**
 * description: add a description
 * @author 方浩
 * @version 1.0.0
 * @date 2023/06/04 10:55:20
 */
public class SimpleJobScheduleFactory {
    public static ISimpleJobSchedule createJobSchedule(ScheduleTypeEnum scheduleTypeEnum){
        String jobScheduleName = StringUtils.EMPTY;
        switch (scheduleTypeEnum){
            case CORN:
                jobScheduleName = "cornSimpleJobSchedule";
                break;
            case DATETIME:
                jobScheduleName = "datetimeSimpleJobSchedule";;
                break;
        }
        if (StringUtils.isBlank(jobScheduleName)){
            throw new RuntimeException("不支持的任务调度器");
        }
        return (ISimpleJobSchedule) SpringContextUtils.getBean(jobScheduleName);
    }

    public static ISimpleJobSchedule createCornJobSchedule(){
        return (ISimpleJobSchedule) SpringContextUtils.getBean("cornSimpleJobSchedule");
    }

    public static ISimpleJobSchedule createDatetimeJobSchedule(){
        return (ISimpleJobSchedule) SpringContextUtils.getBean("datetimeSimpleJobSchedule");
    }
}
