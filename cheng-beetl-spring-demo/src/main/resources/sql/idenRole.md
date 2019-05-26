findByUserIdIn
===
	select r.*, ur.user_id from iden_role r 
	left join iden_user_role ur on ur.role_id = r.role_id
	where ur.user_id in ( #join(userIds)#)


sample
===
* 注释

	select #use("cols")# from iden_role  where  #use("condition")#

cols
===
	role_id,role_code,role_name,role_description,version,create_by,create_date,last_modified_by,last_modified_date

updateSample
===
	
	role_id=#roleId#,role_code=#roleCode#,role_name=#roleName#,role_description=#roleDescription#,version=#version#,create_by=#createBy#,create_date=#createDate#,last_modified_by=#lastModifiedBy#,last_modified_date=#lastModifiedDate#

condition
===

	1 = 1  
	@if(!isEmpty(roleId)){
	 and role_id=#roleId#
	@}
	@if(!isEmpty(roleCode)){
	 and role_code=#roleCode#
	@}
	@if(!isEmpty(roleName)){
	 and role_name=#roleName#
	@}
	@if(!isEmpty(roleDescription)){
	 and role_description=#roleDescription#
	@}
	@if(!isEmpty(version)){
	 and version=#version#
	@}
	@if(!isEmpty(createBy)){
	 and create_by=#createBy#
	@}
	@if(!isEmpty(createDate)){
	 and create_date=#createDate#
	@}
	@if(!isEmpty(lastModifiedBy)){
	 and last_modified_by=#lastModifiedBy#
	@}
	@if(!isEmpty(lastModifiedDate)){
	 and last_modified_date=#lastModifiedDate#
	@}
	
	