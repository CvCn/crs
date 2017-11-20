package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Funs;

public interface FunsMapper
{
	@Select("select * from funs f inner join roles_funs r_f on r_f.funid=f.funid and r_f.roleid=#{0}")
	List<Funs> selFuns(int roleid);
	
	@Select("select * from funs")
	List<Funs> selAllFuns();
	
	@Select("select * from funs where menuid in (select a.aid from (select m.menuid aid from menus m left join roles_menus r_m on m.menuid=r_m.menuid where r_m.roleid=#{0}) a left join (select m2.menuid bid from menus m2 left join roles_menus r_m2 on m2.menuid=r_m2.menuid where r_m2.roleid=#{1}) b on a.aid=b.bid where b.bid is null)")
	List<Funs> selDiffFuns(int roleid1, int roleid2);
}
