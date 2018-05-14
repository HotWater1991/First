/**
 * 
 */

/**  
* <p>Title: Test.java</p>  

* <p>Description: </p>  

 * <p>Company: zzu</p>  

* @author HotWater  

* @date 2018年5月14日  
*/
//接口
  interface  Test {
	  void  Xp();
	  //内部实现类
	  class  MyTest implements   Test{
		@Override
		public void Xp() {
			
		}
	  }
}
  //文件内部的类
class  Two {
	
	public   void XX() {
		
		System.out.println("我是测试的");
		
		new Test() {
			@Override
			public void Xp() {
				System.out.println("我是匿名内部类");
			}
		};
		
	}
  
}
 
