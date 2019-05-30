package com.lkp.leetcode.utils;

/**
 *@className DelectRepeatEmail
 *@description TODO
 *@Auther 85291173@qq.com
 *@Date 2019/5/30 15:55
 *@Version
 */
 public class DelectRepeatEmail {
	/**
	 * 编写一个 SQL 查询，来删除 Person 表中所有重复的电子邮箱，重复的邮箱里只保留 Id 最小 的那个。
	 
	 +----+------------------+
	 | Id | Email            |
	 +----+------------------+
	 | 1  | john@example.com |
	 | 2  | bob@example.com  |
	 | 3  | john@example.com |
	 +----+------------------+
	 Id 是这个表的主键。
	 例如，在运行你的查询语句之后，上面的 Person 表应返回以下几行:
	 
	 +----+------------------+
	 | Id | Email            |
	 +----+------------------+
	 | 1  | john@example.com |
	 | 2  | bob@example.com  |
	 +----+------------------+
	 
	 正确答案： DELETE FROM person WHERE Id NOT in((SELECT Id FROM (SELECT MIN(Id) Id FROM person GROUP BY Email)a ))
	 
	 疑问：
	 执行 SELECT * FROM person WHERE Id NOT IN (SELECT MIN(Id) Id FROM person GROUP BY Email) 查询语句是可以执行的
	 但是 在执行 DELETE FROM person WHERE Id NOT IN (SELECT MIN(Id) Id FROM person GROUP BY Email) 时数据库语法错误
	 *
	 */
}
