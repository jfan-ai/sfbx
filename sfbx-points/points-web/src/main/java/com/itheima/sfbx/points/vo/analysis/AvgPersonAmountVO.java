package com.itheima.sfbx.points.vo.analysis;

import com.itheima.sfbx.points.vo.table.LineChartsVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * DnuVO
 * @describe: 累计保单客户数
 * @date: 2022/12/28 10:10
 */
@Data
@NoArgsConstructor
@ApiModel(value = "CcnVO对象", description = "累计保单客户数")
public class AvgPersonAmountVO {


    @Builder
    public AvgPersonAmountVO(BigDecimal personAmount, BigDecimal qoq, BigDecimal qoqLastWeek, BigDecimal total, BigDecimal average, LineChartsVO table) {
        this.personAmount = personAmount;
        this.qoq = qoq;
        this.qoqLastWeek = qoqLastWeek;
        this.total = total;
        this.average = average;
        this.table = table;
    }

    @ApiModelProperty(value = "当日保费")
    private BigDecimal personAmount = BigDecimal.ZERO;

    @ApiModelProperty(value = "环比上期")
    private BigDecimal qoq = BigDecimal.ZERO;

    @ApiModelProperty(value = "环比上周")
    private BigDecimal qoqLastWeek = BigDecimal.ZERO;

    @ApiModelProperty(value = "合计")
    private BigDecimal total = BigDecimal.ZERO;

    @ApiModelProperty(value = "均值")
    private BigDecimal average = BigDecimal.ZERO;

    @ApiModelProperty(value = "折线表格数据")
    private LineChartsVO table;

}
