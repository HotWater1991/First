/**
 * 
 */
package com.zzu.dao;

import com.zzu.web.domain.Item;

/**  
* <p>Title: ItemDao.java</p>  

* <p>Description: </p>  

 * <p>Company: zzu</p>  

* @author HotWater  

* @date 2018年4月28日  
*/
public interface ItemDao {
	Item findById(Integer id);
}
