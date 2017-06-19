package com.pj.spider.queue;

import java.util.LinkedList;

/**
 *	@author		GFF
 *	@date		2017年6月9日下午2:58:03
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public class Queue {
	/**
	  * 定义一个队列，使用LinkedList实现
	  */
	 private LinkedList<Object> queue = new LinkedList<Object>(); // 入队列
	 /**
	  * 将t加入到队列中
	  */
	 public void enQueue(Object t) {
	  queue.addLast(t);
	 }
	 /**
	  * 移除队列中的第一项并将其返回
	  */
	 public Object deQueue() {
	  return queue.removeFirst();
	 }
	 /**
	  * 返回队列是否为空
	  */
	 public boolean isQueueEmpty() {
	  return queue.isEmpty();
	 }
	 /**
	  * 判断并返回队列是否包含t
	  */
	 public boolean contians(Object t) {
	  return queue.contains(t);
	 }
	 /**
	  * 判断并返回队列是否为空
	  */
	 public boolean empty() {
	  return queue.isEmpty();
	 }
}
