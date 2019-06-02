sample
===
* 注释

	select #use("cols")# from auth_user  where  #use("condition")#

cols
===
	user_id,password,username,account_non_expired,account_non_locked,credentials_non_expired,enabled,version,create_by,create_date,last_modified_by,last_modified_date

updateSample
===
	
	user_id=#userId#,password=#password#,username=#username#,account_non_expired=#accountNonExpired#,account_non_locked=#accountNonLocked#,credentials_non_expired=#credentialsNonExpired#,enabled=#enabled#,version=#version#,create_by=#createBy#,create_date=#createDate#,last_modified_by=#lastModifiedBy#,last_modified_date=#lastModifiedDate#

condition
===

	1 = 1  
	@if(!isEmpty(userId)){
	 and user_id=#userId#
	@}
	@if(!isEmpty(password)){
	 and password=#password#
	@}
	@if(!isEmpty(username)){
	 and username=#username#
	@}
	@if(!isEmpty(accountNonExpired)){
	 and account_non_expired=#accountNonExpired#
	@}
	@if(!isEmpty(accountNonLocked)){
	 and account_non_locked=#accountNonLocked#
	@}
	@if(!isEmpty(credentialsNonExpired)){
	 and credentials_non_expired=#credentialsNonExpired#
	@}
	@if(!isEmpty(enabled)){
	 and enabled=#enabled#
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
	
	