package com.yang.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * oee 相关指标
 * @TableName equipment_oee
 */
@TableName(value ="equipment_oee")
public class EquipmentOee implements Serializable {

    /**
     * 
     */
    @TableId(value = "serial_no", type = IdType.ASSIGN_ID)
    private Long serialNo;

    /**
     * 设备编号
     */
    @TableField(value = "equipment_id")
    private String equipmentId;

    /**
     * 统计周期 A、1分钟；B、5分钟；C、30 分钟；D、1小时；E、1天
     */
    @TableField(value = "statistics_cycle")
    private String statisticsCycle;

    /**
     * 开始统计时间，yyyyMMddHHmm，如果统计周期是天 201301010000
     */
    @TableField(value = "statistics_time")
    private String statisticsTime;

//    /**
//     * 最后未更新的状态编号
//     */
//    @TableField(value = "lastest_status_serial_no")
//    private Long lastestStatusSerialNo;

    /**
     * oee 指标
     */
    @TableField(value = "oee_ratio")
    private Double oeeRatio;

    /**
     * 可用率
     */
    @TableField(value = "availability")
    private Double availability;

    /**
     * 设备性能效率
     */
    @TableField(value = "effectiveness_performance")
    private Double effectivenessPerformance;

    /**
     * 质量指数
     */
    @TableField(value = "quality_ratio")
    private Double qualityRatio;

    /**
     * 实际生产时间（秒），根据设备状态确定
     */
    @TableField(value = "actual_production_time")
    private Long actualProductionTime;

    /**
     * 计划占用时间，如果取不到，则整个周期内多属于计划占用时间
     */
    @TableField(value = "plan_occupancy_time")
    private Long planOccupancyTime;

    /**
     * 节拍时间（秒），每个对象的计划运行时间
     */
    @TableField(value = "beat_time")
    private Double beatTime;

    /**
     * 统计周期内已生产数量
     */
    @TableField(value = "produced_quantity")
    private Long producedQuantity;

    /**
     * 统计周期内合格品数量
     */
    @TableField(value = "good_quantity")
    private Long goodQuantity;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Long getSerialNo() {
        return serialNo;
    }

    /**
     * 
     */
    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * 设备编号
     */
    public String getEquipmentId() {
        return equipmentId;
    }

    /**
     * 设备编号
     */
    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    /**
     * 统计周期 A、1分钟；B、5分钟；C、30 分钟；D、1小时；E、1天
     */
    public String getStatisticsCycle() {
        return statisticsCycle;
    }

    /**
     * 统计周期 A、1分钟；B、5分钟；C、30 分钟；D、1小时；E、1天
     */
    public void setStatisticsCycle(String statisticsCycle) {
        this.statisticsCycle = statisticsCycle;
    }

    /**
     * 开始统计时间，yyyyMMddHHmm，如果统计周期是天 201301010000
     */
    public String getStatisticsTime() {
        return statisticsTime;
    }

    /**
     * 开始统计时间，yyyyMMddHHmm，如果统计周期是天 201301010000
     */
    public void setStatisticsTime(String statisticsTime) {
        this.statisticsTime = statisticsTime;
    }

//    /**
//     * 最后未更新的状态编号
//     */
//    public Long getLastestStatusSerialNo() {
//        return lastestStatusSerialNo;
//    }
//
//    /**
//     * 最后未更新的状态编号
//     */
//    public void setLastestStatusSerialNo(Long lastestStatusSerialNo) {
//        this.lastestStatusSerialNo = lastestStatusSerialNo;
//    }

    /**
     * oee 指标
     */
    public Double getOeeRatio() {
        return oeeRatio;
    }

    /**
     * oee 指标
     */
    public void setOeeRatio(Double oeeRatio) {
        this.oeeRatio = oeeRatio;
    }

    /**
     * 可用率
     */
    public Double getAvailability() {
        return availability;
    }

    /**
     * 可用率
     */
    public void setAvailability(Double availability) {
        this.availability = availability;
    }

    /**
     * 设备性能效率
     */
    public Double getEffectivenessPerformance() {
        return effectivenessPerformance;
    }

    /**
     * 设备性能效率
     */
    public void setEffectivenessPerformance(Double effectivenessPerformance) {
        this.effectivenessPerformance = effectivenessPerformance;
    }

    /**
     * 质量指数
     */
    public Double getQualityRatio() {
        return qualityRatio;
    }

    /**
     * 质量指数
     */
    public void setQualityRatio(Double qualityRatio) {
        this.qualityRatio = qualityRatio;
    }

    /**
     * 实际生产时间（秒），根据设备状态确定
     */
    public Long getActualProductionTime() {
        return actualProductionTime;
    }

    /**
     * 实际生产时间（秒），根据设备状态确定
     */
    public void setActualProductionTime(Long actualProductionTime) {
        this.actualProductionTime = actualProductionTime;
    }

    /**
     * 计划占用时间，如果取不到，则整个周期内多属于计划占用时间
     */
    public Long getPlanOccupancyTime() {
        return planOccupancyTime;
    }

    /**
     * 计划占用时间，如果取不到，则整个周期内多属于计划占用时间
     */
    public void setPlanOccupancyTime(Long planOccupancyTime) {
        this.planOccupancyTime = planOccupancyTime;
    }

    /**
     * 节拍时间（秒），每个对象的计划运行时间
     */
    public Double getBeatTime() {
        return beatTime;
    }

    /**
     * 节拍时间（秒），每个对象的计划运行时间
     */
    public void setBeatTime(Double beatTime) {
        this.beatTime = beatTime;
    }

    /**
     * 统计周期内已生产数量
     */
    public Long getProducedQuantity() {
        return producedQuantity;
    }

    /**
     * 统计周期内已生产数量
     */
    public void setProducedQuantity(Long producedQuantity) {
        this.producedQuantity = producedQuantity;
    }

    /**
     * 统计周期内合格品数量
     */
    public Long getGoodQuantity() {
        return goodQuantity;
    }

    /**
     * 统计周期内合格品数量
     */
    public void setGoodQuantity(Long goodQuantity) {
        this.goodQuantity = goodQuantity;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        EquipmentOee other = (EquipmentOee) that;
        return (this.getSerialNo() == null ? other.getSerialNo() == null : this.getSerialNo().equals(other.getSerialNo()))
            && (this.getEquipmentId() == null ? other.getEquipmentId() == null : this.getEquipmentId().equals(other.getEquipmentId()))
            && (this.getStatisticsCycle() == null ? other.getStatisticsCycle() == null : this.getStatisticsCycle().equals(other.getStatisticsCycle()))
            && (this.getStatisticsTime() == null ? other.getStatisticsTime() == null : this.getStatisticsTime().equals(other.getStatisticsTime()))
//            && (this.getLastestStatusSerialNo() == null ? other.getLastestStatusSerialNo() == null : this.getLastestStatusSerialNo().equals(other.getLastestStatusSerialNo()))
            && (this.getOeeRatio() == null ? other.getOeeRatio() == null : this.getOeeRatio().equals(other.getOeeRatio()))
            && (this.getAvailability() == null ? other.getAvailability() == null : this.getAvailability().equals(other.getAvailability()))
            && (this.getEffectivenessPerformance() == null ? other.getEffectivenessPerformance() == null : this.getEffectivenessPerformance().equals(other.getEffectivenessPerformance()))
            && (this.getQualityRatio() == null ? other.getQualityRatio() == null : this.getQualityRatio().equals(other.getQualityRatio()))
            && (this.getActualProductionTime() == null ? other.getActualProductionTime() == null : this.getActualProductionTime().equals(other.getActualProductionTime()))
            && (this.getPlanOccupancyTime() == null ? other.getPlanOccupancyTime() == null : this.getPlanOccupancyTime().equals(other.getPlanOccupancyTime()))
            && (this.getBeatTime() == null ? other.getBeatTime() == null : this.getBeatTime().equals(other.getBeatTime()))
            && (this.getProducedQuantity() == null ? other.getProducedQuantity() == null : this.getProducedQuantity().equals(other.getProducedQuantity()))
            && (this.getGoodQuantity() == null ? other.getGoodQuantity() == null : this.getGoodQuantity().equals(other.getGoodQuantity()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSerialNo() == null) ? 0 : getSerialNo().hashCode());
        result = prime * result + ((getEquipmentId() == null) ? 0 : getEquipmentId().hashCode());
        result = prime * result + ((getStatisticsCycle() == null) ? 0 : getStatisticsCycle().hashCode());
        result = prime * result + ((getStatisticsTime() == null) ? 0 : getStatisticsTime().hashCode());
//        result = prime * result + ((getLastestStatusSerialNo() == null) ? 0 : getLastestStatusSerialNo().hashCode());
        result = prime * result + ((getOeeRatio() == null) ? 0 : getOeeRatio().hashCode());
        result = prime * result + ((getAvailability() == null) ? 0 : getAvailability().hashCode());
        result = prime * result + ((getEffectivenessPerformance() == null) ? 0 : getEffectivenessPerformance().hashCode());
        result = prime * result + ((getQualityRatio() == null) ? 0 : getQualityRatio().hashCode());
        result = prime * result + ((getActualProductionTime() == null) ? 0 : getActualProductionTime().hashCode());
        result = prime * result + ((getPlanOccupancyTime() == null) ? 0 : getPlanOccupancyTime().hashCode());
        result = prime * result + ((getBeatTime() == null) ? 0 : getBeatTime().hashCode());
        result = prime * result + ((getProducedQuantity() == null) ? 0 : getProducedQuantity().hashCode());
        result = prime * result + ((getGoodQuantity() == null) ? 0 : getGoodQuantity().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialNo=").append(serialNo);
        sb.append(", equipmentId=").append(equipmentId);
        sb.append(", statisticsCycle=").append(statisticsCycle);
        sb.append(", statisticsTime=").append(statisticsTime);
//        sb.append(", lastestStatusSerialNo=").append(lastestStatusSerialNo);
        sb.append(", oeeRatio=").append(oeeRatio);
        sb.append(", availability=").append(availability);
        sb.append(", effectivenessPerformance=").append(effectivenessPerformance);
        sb.append(", qualityRatio=").append(qualityRatio);
        sb.append(", actualProductionTime=").append(actualProductionTime);
        sb.append(", planOccupancyTime=").append(planOccupancyTime);
        sb.append(", beatTime=").append(beatTime);
        sb.append(", producedQuantity=").append(producedQuantity);
        sb.append(", goodQuantity=").append(goodQuantity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
