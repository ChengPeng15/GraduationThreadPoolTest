package com.bjtu.JavaTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
/**
 * 
 * @author cuijianglin
 *
 */
public class CollectionAndMap {

	public static void main(String[] args) {
		
		//IteratorLinkedList();
		//ListIteratorLinkList();
		//mergeTwoLinkedList();
		//TreeSetTest();
		//queueArrayDequeTest();
		//priorityQueueTest();
		//viewSet();
		//CollectionsAlgorithm();
		StackTest();
	}
	/**
	 * 栈
	 */
	public static void StackTest()
	{
		Stack stack = new Stack(); // 创建堆栈对象 
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.pop());
		
		Iterator<Integer> iter = stack.iterator();
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
		
	}
	
	/**
	 * 集合中的算法
	 */
	public static void CollectionsAlgorithm()
	{
		List<Integer> numbers = new ArrayList<Integer>();
		for(int i = 1; i <= 49; i++)
		{
			numbers.add(i);
		}
		
	/*	//shuffle将数组顺序打乱
		Collections.shuffle(numbers);
		System.out.println("numbers:"+numbers);
		
		List<Integer> win = numbers.subList(0, 6);
		//排序——正序
		//Collections.sort(win);
		//排序——逆序
		Collections.sort(win,Collections.reverseOrder());
		System.out.println("win:"+win);*/
		
		
	/*	//二分查找——必须是有序的,
		//返回值是对象的索引
		int i = Collections.binarySearch(numbers, 2);
		System.out.println(i);*/
		
		
	/*	//返回最大元素
		int x = Collections.max(numbers);
		System.out.println(x);
		
		//返回最小元素
		int min = Collections.min(numbers);
		System.out.println(min);*/
		
		
	}
	/**
	 * Map三个试图，
	 * Set<K> keySet()
	 * Collection<K> values()
	 * Set<Map.Entry<K,V>> entrySet()
 	 */
	public static void viewSet()
	{
		Map<String,String> map = new HashMap<String,String>();
		map.put("1", "cuijianglin01");
		map.put("2", "cuijianglin02");
		map.put("3", "cuijianglin03");
		
		Set<String> keys = map.keySet();
		for(String key:keys)
		{
			System.out.println("key:"+key);
			System.out.println("key value:"+map.get(key));
		}
		
		
		Collection<String> values = map.values();
		for(String value: values)
		{
			System.out.println("values:"+value);
			//System.out.println();
		}
		
		Set<Map.Entry<String, String>> entrys = map.entrySet();
		for(Map.Entry<String, String> entry:entrys)
		{
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+","+value);
		}
	}
	
	/**
	 * 队列：queue of LinkedList
	 */
	public static void queueLinkedListTest()
	{
		 Queue<String> queue = new LinkedList<String>();
		 queue.offer("Hello");
		 queue.offer("Hello");   
	     queue.offer("World!");   
	     queue.offer("你好！"); 
	     System.out.println(queue.size()); 
	     
	     String str;   
	     while((str=queue.poll())!=null){   
	    	 System.out.print(str);   
	     }   
	     System.out.println();   
	     System.out.println(queue.size()); 
	}
	/**
	 * 队列：queue of ArrayDeque
	 */
	public static void queueArrayDequeTest()
	{
		 Queue<String> queue = new ArrayDeque<String>();
		 queue.offer("Hello");
		 queue.offer("Hello");   
	     queue.offer("World!");   
	     queue.offer("你好！"); 
	     System.out.println(queue.size()); 
	     
	     String str;   
	     while((str=queue.poll())!=null){   
	    	 System.out.print(str);   
	     }   
	     System.out.println();   
	     System.out.println(queue.size()); 
	}
	/**
	 * 队列：queue of priority queue
	 */
	public static void priorityQueueTest()
	{
		//GregorianCalendar 是 Calendar 的一个具体子类，提供了世界上大多数国家/地区使用的标准日历系统。
		//GregorianCalendar 是一种混合日历，可由调用者通过调用 setGregorianChange() 来更改起始日期。
		 PriorityQueue<GregorianCalendar> pq = new PriorityQueue<>();
		 pq.add(new GregorianCalendar(1906,Calendar.DECEMBER,9));
		 pq.add(new GregorianCalendar(1815,Calendar.DECEMBER,10));
		 pq.add(new GregorianCalendar(1903,Calendar.DECEMBER,3));
		 pq.add(new GregorianCalendar(1910,Calendar.JUNE,22));
		 
		 System.out.println("Iterating over elements...");
		 for(GregorianCalendar date:pq)
		 {
			 System.out.println(date.get(Calendar.YEAR));
		 }
		 
		 System.out.println("Removing elements.......");
		 
		 while(!pq.isEmpty())
		 {
			 System.out.println(pq.remove().get(Calendar.YEAR));
		 }
	}
	
	/**
	 * TreeSet可会议进行自动排序
	 */
	public static void TreeSetTest()
	{
		Set<String> sortor = new TreeSet<String>();
		sortor.add("Bob");
		sortor.add("Amy");
		sortor.add("Carl");
		
		for(String s:sortor)
			System.out.println(s);
	}
	
	/**
	 * 自定义比较类型
	 */
	
	public static void TreeSetComparator()
	{
		/*SortedSet<String> sortor = new TreeSet<>(new Comparator<Item>() {
			public int compara(Item a,Item b)
			{
				return 0;
			}
		});*/
	}
	
	
	/**
	 * 合并两个链表
	 */
	public static void mergeTwoLinkedList()
	{
		List<String> a = new LinkedList<String>();
		a.add("Amy");
		a.add("Carl");
		a.add("Erica");
		
		List<String> b = new LinkedList<String>();
		b.add("Bob");
		b.add("Doug");
		b.add("Frances");
		b.add("Gloria");
		
		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.iterator();
		//交叉的合并
		while(bIter.hasNext())
		{
			if(aIter.hasNext()) aIter.next();
			aIter.add(bIter.next());
		}
		
		//for形式的遍历
		for (Iterator iter01 = a.iterator(); iter01.hasNext();) {
			String str = (String)iter01.next();
			System.out.println(str);
		}
		
		
	}
	/**
	 * 使用ListIteratorLinkList操作链表
	 */
	public static void ListIteratorLinkList()
	{
		List<String> staff = new LinkedList<String>();
		staff.add("Amy");
		staff.add("Bob");
		staff.add("Carl");
		
		//LinkList提供了get方法来获取值，但是这个方法效率不高
		staff.get(0);
		
		ListIterator<String> iter = staff.listIterator();
		iter.next();//跳过提一个元素
		//while(iter.hasNext()){iter.next();};//在链表之后添加元素
		iter.add("Juliet");
		
		/*替换链表中的元素*/
		String oldValue = iter.next();
		System.out.println("oldVlaue:"+oldValue);
		iter.set("cuijianglin");
		
		
		//遍历
		//for形式的遍历
		for (Iterator iter01 = staff.iterator(); iter01.hasNext();) {
			String str = (String)iter01.next();
			System.out.println(str);
		}
		
	}
	/**
	 * Java中常见链表的操作,使用的是Iterator来操作LinkedList
	 */
	public static void IteratorLinkedList()
	{
		List<String> staff = new LinkedList<String>();
		staff.add("Amy");
		staff.add("Bob");
		staff.add("Carl");
		Iterator<String> iter = staff.iterator();
	
		String first = iter.next();
		System.out.println("first:"+first);
		String second = iter.next();
		System.out.println("second:"+second);
		iter.remove();//这里删除的是最后打印的元素，也就是第二个元素，而不是最后一个（第三个）元素
		//for形式的遍历
		for (Iterator iter01 = staff.iterator(); iter01.hasNext();) {
			  String str = (String)iter01.next();
			  System.out.println(str);
		}
		
		Iterator iter02 = staff.iterator();
		 while(iter02.hasNext()){
		  String str = (String) iter02.next();
		  System.out.println(str);
		 }
	}
}
