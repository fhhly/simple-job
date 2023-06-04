package simple.job.core.shecdule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;
import simple.job.api.enums.ScheduleTypeEnum;
import simple.job.common.idgeneate.IIdGenerate;
import simple.job.common.utils.SpringContextUtils;
import simple.job.core.factory.IdGenerateFactory;
import simple.job.core.task.TimerTask;

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

    private IIdGenerate idGenerate;

    private Map<String, TimerTask> timerTaskRunnerConcurrentHashMap = new ConcurrentHashMap<String, TimerTask>();

    private Map<String, ScheduledFuture> scheduledFutureMap = new ConcurrentHashMap<>();

    public CornSimpleJobSchedule() {
        this.idGenerate = idGenerateFactory.creatIdGenerate();
    }

    @Override
    public String register(String taskTime, TimerTask timerTask) {
        ThreadPoolTaskScheduler taskScheduler = SpringContextUtils.getBean(ThreadPoolTaskScheduler.class);
        String uniqueId = idGenerate.nextId();
        return "";
    }

    @Override
    public void unregister(String uniqueId) {

    }

    @Override
    public ScheduleTypeEnum getScheduleType() {
        return ScheduleTypeEnum.CORN;
    }
}
