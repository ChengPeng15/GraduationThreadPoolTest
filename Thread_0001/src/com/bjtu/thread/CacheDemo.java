package com.bjtu.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *  编写一个简单的缓存
 * @author cuijianglin
 *
 */
public class CacheDemo {

	private Map<String,Object> cache = new HashMap<String,Object>();
	public static void main(String[] args) {
		
	}
	//加入一个读写锁
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	public Object getData(String key)
	{
		readWriteLock.readLock().lock();
		
		Object target = null;
		try
		{
			target = cache.get(key);
			if(target == null)
			{
				readWriteLock.readLock().unlock();
				readWriteLock.writeLock().lock();
				try
				{
					if(target == null)
						//到数据库中获取
						target = "aaaa";
				}finally
				{
					
					readWriteLock.writeLock().unlock();
				}
				readWriteLock.readLock().lock();
			}
		}finally
		{
			readWriteLock.readLock().unlock();
		}
		return target;
	}
}
