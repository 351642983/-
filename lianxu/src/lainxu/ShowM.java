package lainxu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ShowM {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
		List<Integer> max=new ArrayList<Integer>();
		
		int maxp=-1; //�����1��ʼ����������ֵ��λ��
		
		Scanner it=new Scanner(System.in);
		
		int num=0;
		//�ֶ���������
		//--------------------------------------------
		System.out.println("����������Ҫ��������ĳ���:");
		while(num<=0)	//ʵ���û���������Ĵ�С
		{
			if(it.hasNextInt())
			{
				num=it.nextInt();
				if(num<=0)
				{
					System.out.println("�������鲻��С�ڵ���0,����������");
				}
				
			}
			else
			{
				it.next();
				System.out.println("�����ʽ����,����������");
			}
		}
		//--------------------------------------------
		
		List<Integer> nums=new ArrayList<Integer>();	//���ڴ�������
		
		max.add(0);		//���һ��maxʹ��Ϊ0
		for(int i=1;i<=num;i++)		//��������
		{
			//--------------------------------------------
			//�ֶ���������
			System.out.println("�������"+i+"����:");
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
					System.out.println("�����ʽ����,����������");
				}
			}
			//--------------------------------------------
			
		}

		
		System.out.println("�����������"+nums.toString());
		

		
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
			
		
		System.out.println("����������Ϊ��"+(remax-minn)+",λ��Ϊ("+(minp+1)+","+(maxp+1)+")");
		
		it.close();
	}

}
