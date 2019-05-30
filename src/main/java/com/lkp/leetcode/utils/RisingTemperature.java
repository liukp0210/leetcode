package com.lkp.leetcode.utils;

/**
 *@className RisingTemperature
 *@description TODO
 *@Auther 85291173@qq.com
 *@Date 2019/5/30 16:03
 *@Version
 */
 public class RisingTemperature {
	/**
	 * 给定一个 Weather 表，编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 Id。
	 
	 +---------+------------------+------------------+
	 | Id(INT) | RecordDate(DATE) | Temperature(INT) |
	 +---------+------------------+------------------+
	 |       1 |       2015-01-01 |               10 |
	 |       2 |       2015-01-02 |               25 |
	 |       3 |       2015-01-03 |               20 |
	 |       4 |       2015-01-04 |               30 |
	 +---------+------------------+------------------+
	 例如，根据上述给定的 Weather 表格，返回如下 Id:
	 +----+
	 | Id |
	 +----+
	 |  2 |
	 |  4 |
	 +----+
	 
	 解题： SELECT w1.Id AS Id FROM Weather w1 ,Weather w2 WHERE w1.RecordDate = ADDDATE(w2.RecordDate,1) AND w1.Temperature > w2.Temperature
	 */
}
