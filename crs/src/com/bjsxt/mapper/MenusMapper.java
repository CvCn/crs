package com.bjsxt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Menus;

public interface MenusMapper
{
	@Results({
		@Result(id=true, property="menuid", column="menuid"),
		@Result(property="menuid", column="menuid"),
		@Result(property="fatherid", column="fatherid"),
		@Result(property="childrenmenus", many=@Many(select="com.bjsxt.mapper.MenusMapper.selMenus"), column="{roleid=roleid, fatherid=menuid}")
	})
	@Select("select m.*, #{roleid} roleid from menus m inner join roles_menus r_m on r_m.menuid=m.menuid and r_m.roleid=#{roleid} and m.fatherid=#{fatherid}")
	List<Menus> selMenus(Map<String, Integer> map);
//	
//	@Select("select * from menus where fatherid != 0")
//	List<Menus> selMenusTwo();
	/**
	 * 求两个角色的menu差集
	 * @param roleid
	 * @return
	 * @author xiaowei
	 */
	@Select("select * from menus where menuid in (select a.aid from (select m.menuid aid from menus m left join roles_menus r_m on m.menuid=r_m.menuid where r_m.roleid=#{0}) a left join (select m2.menuid bid from menus m2 left join roles_menus r_m2 on m2.menuid=r_m2.menuid where r_m2.roleid=#{1}) b on a.aid=b.bid where b.bid is null)")
	List<Menus> selDiffMenu(int roleid1, int roleid2);
}
