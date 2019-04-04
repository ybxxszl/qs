package src.com.wjy.delay;

/**
 * @desc 延时队列返回实体，延时队列返回处理结果时使用
 * @author wjy
 * @data 2019年3月22日
 */
public class DelayQueueReturn {

    // 任务是否执行成功
    private boolean isSuccess;
    // 任务执行失败时的异常
    private Exception exception;

    /**
     * @desc 任务执行失败
     * @param e
     *            异常
     * @return
     */
    public static DelayQueueReturn executeFail(Exception e) {
        return new DelayQueueReturn(false, e);
    }

    /**
     * @desc 任务执行成功
     * @return
     */
    public static DelayQueueReturn executeSuccess() {
        return new DelayQueueReturn(true);
    }

    public DelayQueueReturn(boolean isSuccess, Exception exception) {
        this.isSuccess = isSuccess;
        this.exception = exception;
    }

    public DelayQueueReturn(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public Exception getException() {
        return exception;
    }

}
