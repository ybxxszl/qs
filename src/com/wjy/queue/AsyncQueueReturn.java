package src.com.wjy.queue;

/**
 * @desc 异步队列返回实体，异步队列父级引导子级时使用
 * @author wjy
 * @data 2019年3月18日
 */
public class AsyncQueueReturn {

    // 父级任务是否执行成功
    private boolean isSuccess;
    // 父级任务执行失败时的异常
    private Exception exception;
    // 子级任务是否继续执行
    private boolean isContinue;

    /**
     * @desc 任务执行失败
     * @param e
     *            异常
     * @return
     */
    public static AsyncQueueReturn executeFail(Exception e) {
        return new AsyncQueueReturn(false, e);
    }

    /**
     * @desc 任务执行成功
     * @param isContinue
     *            子级任务是否继续执行
     * @return
     */
    public static AsyncQueueReturn executeSuccess(boolean isContinue) {
        return new AsyncQueueReturn(true, isContinue);
    }

    public AsyncQueueReturn(boolean isSuccess, Exception exception) {
        this.isSuccess = isSuccess;
        this.exception = exception;
    }

    public AsyncQueueReturn(boolean isSuccess, boolean isContinue) {
        this.isSuccess = isSuccess;
        this.isContinue = isContinue;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public Exception getException() {
        return exception;
    }

    public boolean isContinue() {
        return isContinue;
    }

}
