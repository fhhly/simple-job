package simple.job.core.shecdule;

import org.springframework.stereotype.Service;
import simple.job.api.enums.ScheduleTypeEnum;
import simple.job.core.task.TimerTask;

/**
 * description: add a description
 *
 * @author 方浩
 * @version 1.0.0
 * @date 2023/05/31 15:52:52
 */
@Service
public class DatetimeSimpleJobSchedule implements ISimpleJobSchedule {
    @Override
    public String register(String taskTime, TimerTask timerTask) {
        return "";
    }

    @Override
    public void unregister(String uniqueId) {

    }

    @Override
    public ScheduleTypeEnum getScheduleType() {
        return ScheduleTypeEnum.DATETIME;
    }
}
