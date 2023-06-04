package simple.job.core.shecdule;

import simple.job.api.enums.ScheduleTypeEnum;
import simple.job.core.task.TimerTask;

/**
 * description: add a description
 * @author 方浩
 * @version 1.0.0
 * @date 2023/05/31 15:52:04
 */
public interface ISimpleJobSchedule {

    /**
     * 注册定时任务
     * @author 方浩
     * @date 2023/6/4 10:37
     * @version 1.0.0
     * @param taskTime 调度事件
     * @param timerTask 调度类
     * @see ScheduleTypeEnum
     * @return
     */
    String register(String taskTime, TimerTask timerTask);

    /**
     * 取消定时任务注册
     * @author 方浩
     * @date 2023/6/4 10:39
     * @version 1.0.0
     * @param uniqueId 定时任务唯一id
     */
    void unregister(String uniqueId);

    ScheduleTypeEnum getScheduleType();
}
