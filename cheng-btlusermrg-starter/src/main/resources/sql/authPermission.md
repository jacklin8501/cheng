sample
===
* 注释

	select #use("cols")# from auth_permission  where  #use("condition")#

cols
===
	perm_id,perm_code,uri,method,perm_description,version,create_by,create_date,last_modified_by,last_modified_date

updateSample
===
	
	perm_id=#permId#,perm_code=#permCode#,uri=#uri#,method=#method#,perm_description=#permDescription#,version=#version#,create_by=#createBy#,create_date=#createDate#,last_modified_by=#lastModifiedBy#,last_modified_date=#lastModifiedDate#

condition
===

	1 = 1  
	@if(!isEmpty(permId)){
	 and perm_id=#permId#
	@}
	@if(!isEmpty(permCode)){
	 and perm_code=#permCode#
	@}
	@if(!isEmpty(uri)){
	 and uri=#uri#
	@}
	@if(!isEmpty(method)){
	 and method=#method#
	@}
	@if(!isEmpty(permDescription)){
	 and perm_description=#permDescription#
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
	
	