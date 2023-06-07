package simple.job.core.shecdule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;
import simple.job.api.enums.JobStatusEnum;
import simple.job.api.enums.ScheduleTypeEnum;
import simple.job.api.pojo.SimpleJobInfo;
import simple.job.common.adapter.dao.ISimpleJobDao;
import simple.job.common.idgeneate.IIdGenerate;
import simple.job.common.utils.SpringContextUtils;
import simple.job.core.factory.IdGenerateFactory;
import simple.job.core.task.TimerTask;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * description: add a description
 * @author 方浩
 * @version 1.0.0
 * @date 2023/05/31 15:53:28
 */
@Service
public class CornSimpleJobSchedule implements ISimpleJobSchedule {
    @Autowired
    private IdGenerateFactory idGenerateFactory;
    @Autowired
    private ISimpleJobDao iSimpleJobDao;

    private IIdGenerate idGenerate;

    private Map<String, TimerTask> timerTaskRunnerConcurrentHashMap = new ConcurrentHashMap<>();

    private Map<String, ScheduledFuture> scheduledFutureMap = new ConcurrentHashMap<>();

    public CornSimpleJobSchedule() {
        this.idGenerate = idGenerateFactory.creatIdGenerate();
    }

    @Override
    public String register(String cron, TimerTask timerTask) {
        ThreadPoolTaskScheduler taskScheduler = SpringContextUtils.getBean(ThreadPoolTaskScheduler.class);
        String uniqueId = idGenerate.nextId();
        CronTrigger trigger = new CronTrigger(cron);
        timerTaskRunnerConcurrentHashMap.put(uniqueId, timerTask);
        ScheduledFuture scheduledFuture = taskScheduler.schedule(timerTask, trigger);
        scheduledFutureMap.put(uniqueId, scheduledFuture);
        Date now = new Date();
        SimpleJobInfo simpleJobInfo = new SimpleJobInfo();
        simpleJobInfo.setId(uniqueId);
        simpleJobInfo.setCreatedTime(now);
        simpleJobInfo.setCreatedBy("test");
        simpleJobInfo.setUpdateBy("test");
        simpleJobInfo.setUpdateTime(now);
        simpleJobInfo.setTimeExpression(cron);
        simpleJobInfo.setStatus(JobStatusEnum.WAIT_SCHEDULE.getCode());

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
        return ScheduleTypeEnum.CORN;
    }
}
