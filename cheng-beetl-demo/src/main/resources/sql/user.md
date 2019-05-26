simple
===
* 注释

	select #use("cols")# from user  where  #use("condition")#

cols
===
	id,name,age,userName,roleId,create_date

updateSample
===
	
	id=#id#,name=#name#,age=#age#,userName=#username#,roleId=#roleid#,create_date=#createDate#

condition
===

	1 = 1  
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(name)){
	 and name=#name#
	@}
	@if(!isEmpty(age)){
	 and age=#age#
	@}
	@if(!isEmpty(userName)){
	 and userName=#userName#
	@}
	@if(!isEmpty(roleId)){
	 and roleId=#roleId#
	@}
	@if(!isEmpty(createDate)){
	 and create_date=#createDate#
	@}
	@if(!isEmpty(gender)){
	 and gender = #gender#
	@}
	
queryPageUser
===
	select
	@pageTag(){
	user.*
	@}
	from user where #use("condition")#
	@pageIgnoreTag() {
	order by create_date desc
	@}
	
simpleRelRole
===
	select u.*, r.role_code, r.role_name from user u 
	left join role r on r.id = u.roleid
	where u.id = #id#

simpleTimeStamp
===
	select #use("cols")# from user  where 1 = 1
	@if(isNotEmpty(name)){
		and name = #timeStamp(name)#
	@}
	
simpleIn
===
	select * from user where id in (#join(ids)#)
	