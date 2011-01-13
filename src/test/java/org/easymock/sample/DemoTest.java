package org.easymock.sample;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Test;

public class DemoTest {
	private IMathDemo demo;
	@Test
	public void testAddWithMock(){
		//1.创建模拟对象
		demo = EasyMock.createMock(IMathDemo.class);//EasyMock默认为接口生成模拟对象，如果需为类生成模拟对象需下载扩展包EasyMock Class Extension 
		
		//2.expect 记录
		EasyMock.expect(demo.add(1, 2)).andReturn(3).times(2);
		EasyMock.expect(demo.div(6, 3)).andReturn(2);
		//3.replay 回放
		EasyMock.replay(demo);
                //4.进行测试
		assertEquals(3, demo.add(1,2));
		assertEquals(3, demo.add(1,2));
		assertEquals(2, demo.div(6,3));
		//5.verify 检查EasyMock的执行情况
		EasyMock.verify(demo);
		//EasyMock是根据 记录+回放  测试+检查 的过程
	}

	@Test(expected=RuntimeException.class)
	public void testAddWithMockException(){
		demo = EasyMock.createMock(IMathDemo.class);
                //模拟方法抛出异常
		EasyMock.expect(demo.add(-1,-1)).andThrow(new RuntimeException("运行时错误！！"));
		EasyMock.replay(demo);
		demo.add(-1, -1);
		EasyMock.verify(demo);
	}
}
