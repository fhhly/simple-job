package simple.job.core.shecdule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;
import simple.job.api.enums.ScheduleTypeEnum;
import simple.job.common.idgeneate.IIdGenerate;
import simple.job.common.utils.DateUtils;
import simple.job.common.utils.SpringContextUtils;
import simple.job.core.factory.IdGenerateFactory;
import simple.job.core.task.TimerTask;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * description: add a description
 *
 * @author 方浩
 * @version 1.0.0
 * @date 2023/05/31 15:52:52
 */
@Service
public class DatetimeSimpleJobSchedule implements ISimpleJobSchedule {
    @Autowired
    private IdGenerateFactory idGenerateFactory;

    private IIdGenerate idGenerate;

    private Map<String, TimerTask> timerTaskRunnerConcurrentHashMap = new ConcurrentHashMap<>();

    private Map<String, ScheduledFuture> scheduledFutureMap = new ConcurrentHashMap<>();

    public DatetimeSimpleJobSchedule() {
        this.idGenerate = idGenerateFactory.creatIdGenerate();
    }

    @Override
    public String register(String datetime, TimerTask timerTask) {
        ThreadPoolTaskScheduler taskScheduler = SpringContextUtils.getBean(ThreadPoolTaskScheduler.class);
        String uniqueId = idGenerate.nextId();
        timerTaskRunnerConcurrentHashMap.put(uniqueId, timerTask);
        Date date;
        try {
            date = DateUtils.strToDate(datetime);
        } catch (ParseException e) {
            throw new RuntimeException("datetime format error");
        }
        ScheduledFuture scheduledFuture = taskScheduler.schedule(timerTask, date);
        scheduledFutureMap.put(uniqueId, scheduledFuture);
        return uniqueId;
    }

    @Override
    public void unregister(String uniqueId) {
        TimerTask timerTask = timerTaskRunnerConcurrentHashMap.get(uniqueId);
        if (timerTask == null) {
            return;
        }
        timerTaskRunnerConcurrentHashMap.remove(uniqueId);
        ScheduledFuture scheduledFuture = scheduledFutureMap.remove(uniqueId);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    @Override
    public ScheduleTypeEnum getScheduleType() {
        return ScheduleTypeEnum.DATETIME;
    }
}
