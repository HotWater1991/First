/**
 * 
 */

/**  
* <p>Title: Test.java</p>  

* <p>Description: </p>  

 * <p>Company: zzu</p>  

* @author HotWater  

* @date 2018��5��14��  
*/
//�ӿ�
  interface  Test {
	  void  Xp();
	  //�ڲ�ʵ����
	  class  MyTest implements   Test{
		@Override
		public void Xp() {
			
		}
	  }
}
  //�ļ��ڲ�����
class  Two {
	
	public   void XX() {
		
		System.out.println("���ǲ��Ե�");
		
		new Test() {
			@Override
			public void Xp() {
				System.out.println("���������ڲ���");
			}
		};
		
	}
  
}
 
