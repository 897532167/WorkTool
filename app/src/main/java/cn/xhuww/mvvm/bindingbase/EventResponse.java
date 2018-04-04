package cn.xhuww.mvvm.bindingbase;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by xhu_ww on 2018/4/4.
 * description:事件响应
 */

public class EventResponse<T> {

    private Action action;
    private Consumer<T> consumer;

    public EventResponse(Action action) {
        this.action = action;
    }

    public EventResponse(Consumer<T> consumer) {
        this.consumer = consumer;
    }

    public void execute() {
        if (action != null) {
            try {
                action.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void execute(T parameter) {
        if (consumer != null) {
            try {
                consumer.accept(parameter);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
