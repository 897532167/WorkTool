package com.example.study.utils;

import com.example.study.mvvm.model.data.ClientAccumulativeRate;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;

import java.util.List;
import java.util.Map;


/**
 * Created by xhu_ww on 2018/5/30.
 * description:
 */
public class LineChartManager_java {
    private LineChart lineChart;

    public LineChartManager_java(LineChart lineChart) {
        this.lineChart = lineChart;
    }

    /**
     * 初始化 LineChart
     *
     * @param lineChart
     */
    private void initChart(LineChart lineChart) {

    }

    /**
     * 展示一条曲线 默认x轴
     *
     * @param yData    y轴的数据
     * @param lineName 曲线名称
     * @param color    曲线颜色
     */
    public void showOneLineChart(List<Integer> yData, String lineName, int color) {

    }

    /**
     * 展示一条曲线 自定义 X轴 的显示内容
     *
     * @param xyData x y 轴的数据
     */
    public void showOneLineChart(Map<String, Integer> xyData, String lineName, int color) {

    }

    /**
     * 展示多条曲线 默认X轴
     *
     * @param yDataList List<Integer> 代表一条曲线的数据  yDataList.size 代表曲线的条数
     */
    public void showMultiNormalLineChart(List<List<Integer>> yDataList) {

    }

    /**
     * 展示多条曲线 自定义 X轴 的显示内容
     *
     * @param xyDataList Map<Integer, Integer> 代表一条曲线的数据  xyDataList.size 代表曲线的条数
     */
    public void showMultiLineChart(List<Map<String, Integer>> xyDataList) {

    }

    /**
     * 根据自己的数据对象 展示曲线
     *
     * @param chartDataList
     */
    public void showChart(List<ClientAccumulativeRate> chartDataList) {

    }

    /**
     * 设置X轴的显示值
     *
     * @param min        x轴最小值
     * @param max        x轴最大值
     * @param labelCount x轴的分割数量
     */
    public void setXAxis(float min, float max, int labelCount) {

    }

    /**
     * 自定义的 X轴显示内容
     *
     * @param xAxisStr
     */
    public void setXAxis(List<String> xAxisStr) {

    }

    /**
     * 设置LineChart的描述信息
     *
     * @param desc
     */
    public void setDescription(String desc) {
        Description description = new Description();
        description.setText(desc);
        lineChart.setDescription(description);
        lineChart.invalidate();
    }
}
