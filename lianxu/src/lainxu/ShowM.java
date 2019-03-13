package lainxu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ShowM {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		List<Integer> max=new ArrayList<Integer>();
		
		int maxp=-1; //储存从1开始的子组和最大值的位置
		
		Scanner it=new Scanner(System.in);
		
		int num=0;
		//手动输入区域
		//--------------------------------------------
		System.out.println("请输入你想要查找数组的长度:");
		while(num<=0)	//实现用户输入数组的大小
		{
			if(it.hasNextInt())
			{
				num=it.nextInt();
				if(num<=0)
				{
					System.out.println("输入数组不能小于等于0,请重新输入");
				}
				
			}
			else
			{
				it.next();
				System.out.println("输入格式错误,请重新输入");
			}
		}
		//--------------------------------------------
		
		List<Integer> nums=new ArrayList<Integer>();	//用于储存数组
		
		max.add(0);		//添加一个max使其为0
		for(int i=1;i<=num;i++)		//储存数组
		{
			//--------------------------------------------
			//手动输入区域
			System.out.println("请输入第"+i+"个数:");
			Integer g_down=null;
			
			while(g_down==null)
			{
				if(it.hasNextInt())
				{
					g_down=it.nextInt();
					max.add(g_down+max.get(i-1));
					nums.add(g_down);

				}
				else
				{
					it.next();
					System.out.println("输入格式错误,请重新输入");
				}
			}
			//--------------------------------------------
			
		}

		
		System.out.println("输入的数组是"+nums.toString());
		

		
		int minn=max.get(0);
		int minp=0;
		int remax=max.get(1);
		maxp=0;
		for(int i=1;i<max.size();i++)
		{
			List<Integer> max2=max.subList(0, i);
			int g_min=Collections.min(max2);
			if(max.get(i)-g_min>remax)
			{
				remax=max.get(i)-g_min;
				maxp=i-1;
				minp=max.indexOf(g_min);
			}
		}
			
		
		System.out.println("最大子数组和为是"+(remax-minn)+",位置为("+(minp+1)+","+(maxp+1)+")");
		
		it.close();
	}

}
