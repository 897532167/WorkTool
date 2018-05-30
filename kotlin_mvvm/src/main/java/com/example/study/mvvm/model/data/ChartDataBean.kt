package com.example.study.mvvm.model.data

/**
 * Created by xhu_ww on 2018/5/30.
 * description:
 */

data class ChartDataBean(
        val ERRORNO: Int,
        val GRID0: GRID0
)

data class GRID0(
        val code: Int,
        val message: String,
        val result: Result
)

data class Result(
        val compositeIndexGEM: List<CompositeIndexGEM>,
        val clientAccumulativeRate: List<ClientAccumulativeRate>,
        val compositeIndexShanghai: List<CompositeIndexShanghai>,
        val compositeIndexShenzhen: List<CompositeIndexShenzhen>
)

data class ClientAccumulativeRate(
        val tradeDate: String,
        val value: Double
)

data class CompositeIndexShanghai(
        val rate: String,
        val tradeDate: String
)

data class CompositeIndexGEM(
        val rate: String,
        val tradeDate: String
)

data class CompositeIndexShenzhen(
        val rate: String,
        val tradeDate: String
)