sample
===
* 注释

	select #use("cols")# from iden_user_role  where  #use("condition")#

cols
===
	ur_id,user_id,role_id,create_date,create_by,last_modified_by,last_modified_date

updateSample
===
	
	ur_id=#urId#,user_id=#userId#,role_id=#roleId#,create_date=#createDate#,create_by=#createBy#,last_modified_by=#lastModifiedBy#,last_modified_date=#lastModifiedDate#

condition
===

	1 = 1  
	@if(!isEmpty(urId)){
	 and ur_id=#urId#
	@}
	@if(!isEmpty(userId)){
	 and user_id=#userId#
	@}
	@if(!isEmpty(roleId)){
	 and role_id=#roleId#
	@}
	@if(!isEmpty(createDate)){
	 and create_date=#createDate#
	@}
	@if(!isEmpty(createBy)){
	 and create_by=#createBy#
	@}
	@if(!isEmpty(lastModifiedBy)){
	 and last_modified_by=#lastModifiedBy#
	@}
	@if(!isEmpty(lastModifiedDate)){
	 and last_modified_date=#lastModifiedDate#
	@}
	
	