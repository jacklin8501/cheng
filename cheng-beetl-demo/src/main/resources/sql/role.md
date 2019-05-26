sample
===
* 注释

	select #use("cols")# from role  where  #use("condition")#

cols
===
	id,role_code,role_name

updateSample
===
	
	id=#id#,role_code=#roleCode#,role_name=#roleName#

condition
===

	1 = 1  
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(roleCode)){
	 and role_code=#roleCode#
	@}
	@if(!isEmpty(roleName)){
	 and role_name=#roleName#
	@}
	
	