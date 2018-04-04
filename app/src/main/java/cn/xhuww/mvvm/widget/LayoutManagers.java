package cn.xhuww.mvvm.widget;

import android.support.annotation.IntDef;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by xhu_ww on 2018/4/4.
 * description:RecyclerView的 LayoutManagers
 */

public class LayoutManagers {
    protected LayoutManagers() {
    }

    public interface LayoutManagerFactory {
        RecyclerView.LayoutManager create(RecyclerView recyclerView);
    }

    public static LayoutManagerFactory linear() {
        return recyclerView -> new LinearLayoutManager(recyclerView.getContext());
    }

    public static LayoutManagerFactory linear(@Orientation final int orientation, final boolean reverseLayout) {
        return recyclerView -> new LinearLayoutManager(recyclerView.getContext(), orientation, reverseLayout);
    }


    public static LayoutManagerFactory grid(final int spanCount) {
        return recyclerView -> new GridLayoutManager(recyclerView.getContext(), spanCount);
    }


    public static LayoutManagerFactory grid(final int spanCount, @Orientation final int orientation, final boolean reverseLayout) {
        return recyclerView -> new GridLayoutManager(recyclerView.getContext(), spanCount, orientation, reverseLayout);
    }

    public static LayoutManagerFactory staggeredGrid(final int spanCount, @Orientation final int orientation) {
        return recyclerView -> new StaggeredGridLayoutManager(spanCount, orientation);
    }

    @IntDef({LinearLayoutManager.HORIZONTAL, LinearLayoutManager.VERTICAL})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }
}

